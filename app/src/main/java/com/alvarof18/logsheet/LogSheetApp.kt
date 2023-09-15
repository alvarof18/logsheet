package com.alvarof18.logsheet

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.alvarof18.logsheet.config.LogSheetNav


@Composable
fun LogSheetApp(navController: NavHostController = rememberNavController()) {
    LogSheetNav(navController = navController)
}