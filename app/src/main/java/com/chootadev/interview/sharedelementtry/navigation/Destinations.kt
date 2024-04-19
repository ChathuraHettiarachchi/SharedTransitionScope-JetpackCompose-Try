package com.chootadev.interview.sharedelementtry.navigation

enum class Screen {
    HOME,
    DETAILS,
}

sealed class Destinations (val route: String){
    object Home: Destinations(route = Screen.HOME.name)
    object Details: Destinations(route = Screen.DETAILS.name)
}