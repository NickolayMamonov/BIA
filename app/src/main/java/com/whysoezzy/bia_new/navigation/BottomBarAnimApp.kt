package com.whysoezzy.bia_new.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.whysoezzy.bia.navigation.Screens
import com.whysoezzy.bia.ui.components.ChatScreen
import com.whysoezzy.bia.ui.components.GraphicsScreen
import com.whysoezzy.bia.ui.components.ProfileScreen
import com.whysoezzy.bia.ui.components.TaskScreen
import com.whysoezzy.bia_new.ui.components.SplashScreen
import com.whysoezzy.bia_new.ui.theme.BIA_NEWTheme

@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun BottomBarAnimationApp() {

    // State of bottomBar, set state to false, if current page route is "car_details"
    val bottomBarState = rememberSaveable { (mutableStateOf(true)) }

    BIA_NEWTheme {
        val navController = rememberNavController()

        // Subscribe to navBackStackEntry, required to get current route
        val navBackStackEntry by navController.currentBackStackEntryAsState()

        // Control TopBar and BottomBar
        when (navBackStackEntry?.destination?.route) {
            Screens.TaskScreen.name -> {
                bottomBarState.value = true
            }

            Screens.GraphicsScreen.name -> {
                // Show BottomBar
                bottomBarState.value = true
            }

            Screens.ChatScreen.name -> {
                // Show BottomBar
                bottomBarState.value = true
            }

            Screens.ProfileScreen.name -> {
                // Show BottomBar
                bottomBarState.value = true
            }

            Screens.SplashScreen.name -> {
                // Hide BottomBar
                bottomBarState.value = false
            }
        }

        Scaffold(
            bottomBar = {
                BottomBar(
                    navController = navController,
                    bottomBarState = bottomBarState
                )
            },
            content = { paddingValues ->
                NavHost(
                    navController = navController,
                    startDestination = Screens.SplashScreen.name,
                    modifier = Modifier
                        .padding(paddingValues)
                ) {
                    composable(route = Screens.SplashScreen.name) {
                        SplashScreen(navController = navController)
                    }
                    composable(route = Screens.TaskScreen.name) {
                        TaskScreen(navController = navController)
                    }
                    composable(route = Screens.GraphicsScreen.name) {
                        GraphicsScreen(navController = navController)
                    }
                    composable(route = Screens.ChatScreen.name) {
                        ChatScreen(navController = navController)
                    }
                    composable(route = Screens.ProfileScreen.name) {
                        ProfileScreen(navController = navController)
                    }
                }
            }
        )
    }

}