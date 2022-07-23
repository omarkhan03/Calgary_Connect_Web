package com.example.yyc_hacks_2022

open class Attraction(type: Int, name: String, location: String, date: String, time: String){
    val type = when(type) {
        1-> "Event"
        2-> "Attraction"
        else -> {""}
    }
    val name = name
    val location = location
    val date = date
    val time = time
}
