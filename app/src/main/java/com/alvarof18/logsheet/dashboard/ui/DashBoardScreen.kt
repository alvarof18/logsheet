package com.alvarof18.logsheet.dashboard.ui

import android.util.Log
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.isDebugInspectorInfoEnabled
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.alvarof18.logsheet.DrawerMenuApp
import com.alvarof18.logsheet.HeaderProfile
import com.alvarof18.logsheet.LogSheetTopAppBar
import com.alvarof18.logsheet.R
import com.alvarof18.logsheet.config.Routes
import com.alvarof18.logsheet.dashboard.ui.model.MenuItems
import com.alvarof18.logsheet.dashboard.ui.model.getItemsMenu
import com.alvarof18.logsheet.ui.theme.BluePrimary
import com.alvarof18.logsheet.ui.theme.LogsheetTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashBoardScreen(navController: NavController) {
    val navigationState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = navigationState,
        drawerContent = { DrawerMenuApp(onClick = { scope.launch { navigationState.close() } }) }) {
        Scaffold(topBar = { LogSheetTopAppBar(onClick = { scope.launch { navigationState.open() } }) }) {
            Column(Modifier.padding(it)) {
                HeaderProfile(onClick = { Log.i("Alvaro", "Patitos Feos") })
                Spacer(modifier = Modifier.height(24.dp))
                BodyDashBoard(navController)
            }
        }
    }
}

@Composable
fun BodyDashBoard(navController: NavController) {
    Column(modifier = Modifier.padding(horizontal = 32.dp)) {
        Text(
            text = stringResource(id = R.string.what_dashboard),
            style = MaterialTheme.typography.labelSmall,
            color = Color(0xff717375)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            BodyDashBoardCard(label = stringResource(id = R.string.PPU1_title),
                navigateTo = {navController.navigate(Routes.SSGPPScreenNav.route)}
            )
            BodyDashBoardCard(label = stringResource(id = R.string.SSGPP_title), navigateTo = {navController.navigate(Routes.SSGPPScreenNav.route)})
        }

    }
}

@Composable
fun BodyDashBoardCard(label: String, navigateTo: () -> Unit) {
    Card(
        Modifier
            .size(width = 150.dp, height = 100.dp)
            .clickable { navigateTo() }, colors = CardDefaults.cardColors(
            containerColor = Color(0xffD6E4F0)
        )
    ) {
        Column(
            Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier.size(50.dp),
                painter = painterResource(id = R.drawable.logsheets_icon),
                contentScale = ContentScale.Fit,
                contentDescription = null
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = label.uppercase(),
                style = MaterialTheme.typography.labelSmall,
                color = Color(0xff347AB6)
            )
        }
    }
}


