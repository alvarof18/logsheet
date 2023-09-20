package com.alvarof18.logsheet.ssgpp.ui.screens

import android.util.Log
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.alvarof18.logsheet.Backbutton
import com.alvarof18.logsheet.DrawerMenuApp
import com.alvarof18.logsheet.HeaderProfile
import com.alvarof18.logsheet.LogSheetTopAppBar
import com.alvarof18.logsheet.MyBottomNavigationBar
import com.alvarof18.logsheet.R
import com.alvarof18.logsheet.config.Routes
import com.alvarof18.logsheet.ssgpp.ui.common.LabelSSGPP
import com.alvarof18.logsheet.ui.theme.LogsheetTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SSGPPScreen(navController: NavController) {
    val navigationState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    ModalNavigationDrawer(
        drawerState = navigationState,
        drawerContent = { DrawerMenuApp { } }) {
        Scaffold(
            bottomBar = { MyBottomNavigationBar() },
            topBar = { LogSheetTopAppBar(onClick = { scope.launch { navigationState.open() } }) }) {
            Column(Modifier.padding(it)) {
                HeaderProfile(onClick = { Log.i("Alvaro", "Patitos Feos") })
                Spacer(modifier = Modifier.height(24.dp))
                SSGPPBody(navController)
            }
        }
    }
}

@Composable
fun SSGPPBody(navController: NavController) {
    Column(modifier = Modifier.padding(horizontal = 32.dp)) {
        Backbutton() { navController.popBackStack() }
        Spacer(modifier = Modifier.height(8.dp))
        LabelSSGPP(showTextLabel = true, title = R.string.ccrhmi_label)
        Spacer(modifier = Modifier.height(16.dp))
        MenuSSGPP(
            icon = R.drawable.generator_icon,
            title = R.string.generator_title,
            subtitle = R.string.generator_subtitle,
            firstItem = true,
            navigateTo = {navController.navigate(Routes.GeneratorParm.route)}
        )
        MenuSSGPP(
            icon = R.drawable.condensing_icon,
            title = R.string.condensing_title,
            subtitle = R.string.condensing_subtitle,
            navigateTo = {navController.navigate(Routes.CondensingSystem.route)}
        )
        MenuSSGPP(
            icon = R.drawable.condensing_icon,
            title = R.string.steam_title,
            subtitle = R.string.steam_subtitle,
            navigateTo = {}
        )
        Spacer(modifier = Modifier.height(16.dp))
        LabelSSGPP(title = R.string.field_label)
        Spacer(modifier = Modifier.height(16.dp))
        MenuSSGPP(
            icon = R.drawable.electrical_icon,
            title = R.string.BOP_title,
            subtitle = R.string.BOP_subtitle,
            firstItem = true,
            navigateTo = {}
        )
        MenuSSGPP(
            icon = R.drawable.field_process_icon,
            title = R.string.field_title,
            subtitle = R.string.field_subtitle,
            navigateTo = {})

        Spacer(modifier = Modifier.height(16.dp))
        LabelSSGPP(title = R.string.weekly_label)
        Spacer(modifier = Modifier.height(16.dp))
        MenuSSGPP(
            icon = R.drawable.tech_icon,
            title = R.string.tech_title,
            subtitle = R.string.tech_subtitle,
            firstItem = true,
            navigateTo = {}
        )

    }
}

@Composable
fun MenuSSGPP(
    @DrawableRes icon: Int,
    @StringRes title: Int,
    @StringRes subtitle: Int,
    firstItem: Boolean = false,
    navigateTo:()->Unit
) {
    Column(modifier = Modifier.clickable {navigateTo()}) {
        if (firstItem) {
            HorizontalDivider()
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp), verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = "",
                modifier = Modifier.size(32.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(
                    text = stringResource(id = title),
                    style = MaterialTheme.typography.labelMedium
                )
                Text(
                    text = stringResource(id = subtitle),
                    style = MaterialTheme.typography.labelMedium.copy(
                        fontSize = 10.sp,
                        color = Color(0xff717375)
                    )
                )
            }

        }
    HorizontalDivider()
    }
}


@Preview
@Composable
fun PreviewSSGPPScreen() {
    LogsheetTheme {
        val navController: NavHostController = rememberNavController()
        SSGPPScreen(navController = navController)
    }
}
