package br.senai.sp.jandira.mobile_aquarela.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.material3.rememberTooltipState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun TabItem(controleDeNavegacao : NavHostController, id : String){
Column(modifier = Modifier.fillMaxWidth().fillMaxHeight(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.SpaceEvenly){
    val tabItem = listOf(
        br.senai.sp.jandira.mobile_aquarela.tabitem.TabItem(
            title = "Histórico de compras", unSelectedItem = Icons.Outlined.Home, selectedIcon = Icons.Filled.Home
        ), br.senai.sp.jandira.mobile_aquarela.tabitem.TabItem(
            title = "Histórico de vendas",
            unSelectedItem = Icons.Outlined.ShoppingCart,
            selectedIcon = Icons.Filled.ShoppingCart
        )
    )
    val pagerState = rememberPagerState {
        tabItem.size
    }
    var tabIndex by remember { mutableStateOf(0) }

    Scaffold(bottomBar = {
        BottomAppBar(actions = {
            NavigationBar(containerColor = Color.White){
                NavigationBarItem(selected = true, onClick = {}, icon = {})
                NavigationBarItem(selected = true, onClick = {}, icon = {})
                FloatingActionButton(onClick = {}) { }
                NavigationBarItem(selected = true, onClick = {}, icon = {})
                NavigationBarItem(selected = true, onClick = {}, icon = {})
            }/* IconButton(onClick = {}){}*/
//        IconButton(onClick = {}){ }
//        IconButton(onClick = {}){ }
//        IconButton(onClick = {}){ }
//        IconButton(onClick = {})
        },
         containerColor = Color.White)
    }, contentColor = Color.White){Column() {

        TabRow(selectedTabIndex = tabIndex, containerColor = Color(0x1A3E7D8D), indicator = {tabPositions -> if(tabIndex<tabPositions.size){TabRowDefaults.SecondaryIndicator(modifier = Modifier.tabIndicatorOffset(tabPositions[tabIndex]), color = Color(0xff3E7D8D))} }) {
            tabItem.forEachIndexed { index, tabItem ->

                androidx.compose.material3.Tab(
                    selected = tabIndex == index,
                    onClick = {
                        tabIndex = index
                    },
                    text = { Text(text = tabItem.title, color = Color(0xff3E7D8D)) },
                    icon = {}

                )
            }
        }

        HorizontalPager(
            state = pagerState, modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) { index ->
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(text = tabItem[index].title)
            }
        }
        when (tabIndex) {
            0 -> Compra()
            1 -> Vendas()
//                1 -> AboutScreen()
//                2 -> SettingsScreen()
        }
    }}
    }
    }


@Composable
@Preview(showBackground = true)
fun TabItemPreview(){
    TabItem(controleDeNavegacao = NavHostController(LocalContext.current), id = "1")
}