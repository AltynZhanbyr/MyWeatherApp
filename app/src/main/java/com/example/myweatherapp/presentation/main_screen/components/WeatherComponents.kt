package com.example.myweatherapp.presentation.main_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myweatherapp.data.local.entity.LocalCityWeather

@Composable
fun WeatherComponents(
    cityWeather: LocalCityWeather,
    onClickUpdate:(String)->Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(Color.LightGray)
            .padding(4.dp)
    ){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.LightGray)
                .padding(4.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                shape = RoundedCornerShape(4.dp),
                elevation = 5.dp
            ){
                Box(
                    modifier = Modifier.fillMaxSize()
                ){
                    Column(
                        modifier = Modifier
                            .align(Alignment.Center),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ){
                        Text(
                            text = cityWeather.degreeInCel.toString() + " C",
                            fontSize = 35.sp,
                            fontWeight = FontWeight.Bold,
                        )
                        Spacer(modifier = Modifier.height(25.dp))
                        Text(
                            text = cityWeather.cityName,
                            fontSize = 30.sp,
                            fontWeight = FontWeight.Bold,
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        IconButton(onClick = {
                            onClickUpdate(cityWeather.cityName)
                        }) {
                            Icon(
                                imageVector = Icons.Default.Refresh,
                                contentDescription = null,
                                modifier = Modifier
                                    .size(25.dp),
                                tint = Color.Gray
                            )
                        }
                    }
                }
            }
            Spacer(
                modifier = Modifier.height(10.dp)
            )
            Column{
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                ){
                    Card(
                        modifier = Modifier
                            .height(75.dp)
                            .weight(1f),
                        shape = RoundedCornerShape(4.dp),
                        elevation = 5.dp
                    ){
                        Box(
                            modifier = Modifier.fillMaxSize()
                        ){
                            Column(
                                modifier = Modifier
                                    .align(Alignment.Center),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ){
                                Text(
                                    text = "Wind",
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold,
                                )
                                Spacer(modifier = Modifier.height(15.dp))
                                Text(
                                    text = cityWeather.windSpeed.toString() + " kph",
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold,
                                )
                            }
                        }
                    }
                    Spacer(modifier = Modifier.width(15.dp))
                    Card(
                        modifier = Modifier
                            .weight(1f)
                            .height(75.dp),
                        shape = RoundedCornerShape(4.dp),
                        elevation = 5.dp
                    ){
                        Box(
                            modifier = Modifier.fillMaxSize()
                        ){
                            Column(
                                modifier = Modifier
                                    .align(Alignment.Center),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ){
                                Text(
                                    text = "Wind direction",
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold,
                                )
                                Spacer(modifier = Modifier.height(15.dp))
                                Text(
                                    text = cityWeather.windDirection,
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold,
                                )
                            }
                        }
                    }
                }
                Spacer(modifier = Modifier.height(25.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                ){
                    Card(
                        modifier = Modifier
                            .height(75.dp)
                            .weight(1f),
                        shape = RoundedCornerShape(4.dp),
                        elevation = 5.dp
                    ){
                        Box(
                            modifier = Modifier.fillMaxSize()
                        ){
                            Column(
                                modifier = Modifier
                                    .align(Alignment.Center),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ){
                                Text(
                                    text = "Feels Like",
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold,
                                )
                                Spacer(modifier = Modifier.height(15.dp))
                                Text(
                                    text = cityWeather.feelsLikeDegreeInCel.toString()+" C",
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold,
                                )
                            }
                        }
                    }
                    Spacer(modifier = Modifier.width(15.dp))
                    Card(
                        modifier = Modifier
                            .weight(1f)
                            .height(75.dp),
                        shape = RoundedCornerShape(4.dp),
                        elevation = 5.dp
                    ){
                        Box(
                            modifier = Modifier.fillMaxSize()
                        ){
                            Column(
                                modifier = Modifier
                                    .align(Alignment.Center),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ){
                                Text(
                                    text = "Cloud Cover",
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold,
                                )
                                Spacer(modifier = Modifier.height(15.dp))
                                Text(
                                    text = cityWeather.cloudCover.toString() + "%",
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold,
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
