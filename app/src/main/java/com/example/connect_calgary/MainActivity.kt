package com.example.connect_calgary

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.util.Log.i
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.connect_calgary.ui.theme.Connect_calgaryTheme
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.net.URL

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Connect_calgaryTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val context = applicationContext
                    val attractions = readJson(context)


                    Navigation(attractions)
                }
            }
        }
    }
}

fun readJson(context: Context) : MutableList<Attraction> {
    val jsonFileString = getJsonDataFromAsset(context, "first.json")
    val gson = Gson()
    val listAttractionType = object : TypeToken<List<Attraction>>() {}.type
    val attractions: List<Attraction> = gson.fromJson(jsonFileString, listAttractionType)

    return attractions.toMutableList()
}



@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Connect_calgaryTheme {
        Greeting("Android")
    }
}