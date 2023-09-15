package com.alvarof18.logsheet.config

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.alvarof18.logsheet.config.Routes.*
import com.alvarof18.logsheet.dashboard.ui.DashBoardScreen
import com.alvarof18.logsheet.login.ui.LoginScreen
import com.alvarof18.logsheet.ssgpp.SSGPPScreen

@Composable
fun LogSheetNav(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        modifier = modifier,
        navController = navController, startDestination = MainRoutes.LoginGraph.route
    ) {
        loginGraph(navController)
        dashboardGraph(navController)
    }
}

fun NavGraphBuilder.loginGraph(navController: NavController){
    navigation(startDestination = LoginScreenNav.route, route = MainRoutes.LoginGraph.route){
        composable(route = LoginScreenNav.route) {LoginScreen(navController)}
        //register

        //Forgot Password
    }
}

fun NavGraphBuilder.dashboardGraph(navController: NavController){
    navigation(startDestination = DashboardScreenNav.route, route = MainRoutes.DashboardGraph.route){
        composable(route = DashboardScreenNav.route){ DashBoardScreen(navController = navController)}
        composable(route = SSGPPScreenNav.route){ SSGPPScreen(navController)}
    }
}