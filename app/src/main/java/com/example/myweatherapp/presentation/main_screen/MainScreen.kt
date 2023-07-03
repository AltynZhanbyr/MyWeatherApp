package com.example.myweatherapp.presentation.main_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun MainScreen(
    viewModel:MainScreenViewModel = hiltViewModel()
) {
    val state = viewModel.state.value

    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        if(state.isLoading)
            CircularProgressIndicator()
        if(state.error.isNotBlank())
            Text(state.error)
        else
            Text(state.cityWeather?.location?.name.toString())
        Button(onClick = {
            viewModel.getCityWeather("London")
        }) {
            Text(text = "Search")
        }
    }
}