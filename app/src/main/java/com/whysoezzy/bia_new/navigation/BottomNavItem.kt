package com.whysoezzy.bia.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import com.whysoezzy.bia_new.R

data class BottomNavItem(
    val label:String,
    val route:String,
    val icon: Int,
    val badgeCount: Int =0
)

val listofNavItems: List<BottomNavItem> = listOf(
    BottomNavItem(
        label = "Tasks",
        icon = R.drawable.baseline_task_24,
        route = Screens.TaskScreen.name
    ),
    BottomNavItem(
        label = "Graphics",
        icon = R.drawable.baseline_calendar,
        route = Screens.GraphicsScreen.name
    ),
    BottomNavItem(
        label = "Chat",
        icon = R.drawable.baseline_chat,
        route = Screens.ChatScreen.name
    ),
    BottomNavItem(
        label = "Profile",
        icon = R.drawable.baseline_person,
        route = Screens.ProfileScreen.name
    )
)
