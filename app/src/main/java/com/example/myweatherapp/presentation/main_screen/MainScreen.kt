package com.example.myweatherapp.presentation.main_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.myweatherapp.presentation.main_screen.components.WeatherComponents

@Composable
fun MainScreen(
    viewModel:MainScreenViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    val inputState = viewModel.inputCityState.value

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(4.dp)
        ){
            OutlinedTextField(
                value = inputState,
                label = {
                    Text("Enter a city name")
                },
                onValueChange = {viewModel.changeCityInputState(it)},
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                modifier = Modifier.weight(0.8f)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Button(onClick = {
                viewModel.getCityWeather(inputState)
            },
                enabled = inputState.isNotBlank(),
                modifier = Modifier.weight(0.4f)
            ) {
                Text(text = "Search")
            }
        }
        Spacer(modifier = Modifier.height(15.dp))
        if(state.isLoading)
            CircularProgressIndicator()
        if(state.error.isNotBlank())
            Text(state.error)
        if(state.cityWeather!=null)
            WeatherComponents(cityWeather = state.cityWeather){
                viewModel.getCityWeather(it)
            }

    }
}