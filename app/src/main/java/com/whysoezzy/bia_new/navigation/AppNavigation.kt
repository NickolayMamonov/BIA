package com.whysoezzy.bia.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.whysoezzy.bia.ui.components.ChatScreen
import com.whysoezzy.bia.ui.components.GraphicsScreen
import com.whysoezzy.bia.ui.components.ProfileScreen
import com.whysoezzy.bia.ui.components.TaskScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppNavigation() {
    val navController: NavHostController = rememberNavController()

    Scaffold(
        bottomBar = {
            NavigationBar {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination

                listofNavItems.forEach {navItem ->
                    NavigationBarItem(
                        selected =currentDestination?.hierarchy?.any{it.route == navItem.route} == true,
                        onClick = {
                                  navController.navigate(navItem.route){
                                      popUpTo(navController.graph.findStartDestination().id){
                                          saveState=true
                                      }
                                      launchSingleTop =true
                                      restoreState = true
                                  }
                                  },
                        icon = {
                            Icon(painter = painterResource(id = navItem.icon), contentDescription =null )
                        },
                        label = {
                            Text(text = navItem.label)

                        }
                    )
                }
            }
        }


    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = Screens.TaskScreen.name,
            modifier = Modifier
                .padding(paddingValues)
        ) {
            composable(route = Screens.TaskScreen.name) {
                TaskScreen()
            }
            composable(route = Screens.GraphicsScreen.name) {
                GraphicsScreen()
            }
            composable(route = Screens.ChatScreen.name) {
                ChatScreen()
            }
            composable(route = Screens.ProfileScreen.name) {
                ProfileScreen()
            }

        }


    }
}