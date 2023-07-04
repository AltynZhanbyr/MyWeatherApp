package com.example.myweatherapp.presentation.main_screen

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myweatherapp.domain.use_case.GetCityWeatherUseCase
import com.example.myweatherapp.utlis.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val getCityWeatherUseCase: GetCityWeatherUseCase
):ViewModel() {

    private val _state = mutableStateOf(CityState())
    val state = _state

    private val _inputCityState = mutableStateOf("")
    val inputCityState = _inputCityState

    fun getCityWeather(name:String){
        viewModelScope.launch {
            getCityWeatherUseCase(name).collect {resource ->
                when(resource){
                    is Resource.Loading->{
                        _state.value = CityState(isLoading = true)
                    }
                    is Resource.Error->{
                        _state.value = CityState(error = resource.message?:"Unexpected error")
                    }
                    is Resource.Success->{
                        _state.value = CityState(cityWeather = resource.data)
                    }
                }
            }
        }
    }

    fun changeCityInputState(name:String){
        _inputCityState.value = name
    }
}