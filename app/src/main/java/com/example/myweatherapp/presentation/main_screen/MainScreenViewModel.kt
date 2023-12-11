package com.example.myweatherapp.presentation.main_screen

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myweatherapp.domain.model.CityWeather
import com.example.myweatherapp.domain.use_case.DeleteAllCityUseCase
import com.example.myweatherapp.domain.use_case.GetAllLocalCityUseCase
import com.example.myweatherapp.domain.use_case.GetCityWeatherUseCase
import com.example.myweatherapp.domain.use_case.GetLocalCityByNameUseCase
import com.example.myweatherapp.domain.use_case.SaveCityToDBUseCase
import com.example.myweatherapp.utlis.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val getCityWeatherUseCase: GetCityWeatherUseCase,
    private val getLocalCityByNameUseCase: GetLocalCityByNameUseCase,
    private val saveCityToDBUseCase: SaveCityToDBUseCase,
    private val deleteAllCityUseCase: DeleteAllCityUseCase,
    private val getAllCityUseCase: GetAllLocalCityUseCase
):ViewModel() {

    private val _state = mutableStateOf(CityState())
    val state = _state

    private val _inputCityState = mutableStateOf("")
    val inputCityState = _inputCityState

    init{
        getAllCityUseCase().onEach {
            if(it!=null)
                _state.value = CityState(cityWeather = it)
        }.launchIn(viewModelScope)
    }

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
                        saveCityToLocalDB(resource.data)
                    }
                }
            }
        }
    }

    fun changeCityInputState(name:String){
        _inputCityState.value = name
    }

    private fun deleteAllCity(){
        viewModelScope.launch {
            deleteAllCityUseCase()
        }
    }

    private fun getCityByNameInDB(name: String){
        getLocalCityByNameUseCase(name).onEach {
            _state.value = CityState(cityWeather = it)
        }.launchIn(viewModelScope)
    }

    private fun saveCityToLocalDB(cityWeather: CityWeather?){
        viewModelScope.launch {
            deleteAllCity()
            delay(100L)
            saveCityToDBUseCase(cityWeather)
            getCityByNameInDB(cityWeather?.location?.name?:"")
        }
    }
}