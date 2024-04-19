package com.chootadev.interview.sharedelementtry.navigation

import android.window.SplashScreen
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.chootadev.interview.sharedelementtry.presentation.DetailsScreen
import com.chootadev.interview.sharedelementtry.presentation.HomeScreen

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun AppNavHost(
    modifier: Modifier = Modifier.fillMaxSize(),
    navController: NavHostController,
    startDestination: String = Destinations.Home.route
) {
    SharedTransitionLayout {
        NavHost(
            modifier = modifier,
            navController = navController,
            startDestination = startDestination
        ) {
            composable(Destinations.Home.route) {
                HomeScreen(animatedVisibilityScope = this, navigateToDetails = {
                    navController.navigate(Destinations.Details.route + "/${it.id}")
                })
            }
            composable(Destinations.Details.route + "/{movie_id}") {
                DetailsScreen(animatedVisibilityScope = this, navController, it.arguments?.getString("movie_id")!!)
            }
        }
    }
}

