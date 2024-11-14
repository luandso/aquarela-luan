package br.senai.sp.jandira.mobile_aquarela.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(val route: String, val label: String, val icon: ImageVector) {
    object Home : Screen(route = "home", label = "home", icon = Icons.Default.Home)
}