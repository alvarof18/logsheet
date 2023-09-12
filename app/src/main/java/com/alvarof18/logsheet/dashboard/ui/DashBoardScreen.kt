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
import com.alvarof18.logsheet.R
import com.alvarof18.logsheet.dashboard.ui.model.MenuItems
import com.alvarof18.logsheet.dashboard.ui.model.getItemsMenu
import com.alvarof18.logsheet.ui.theme.BluePrimary
import com.alvarof18.logsheet.ui.theme.LogsheetTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashBoardScreen() {
    val navigationState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = navigationState,
        drawerContent = { DrawerMenuApp(onClick = { scope.launch { navigationState.close() } }) }) {
        Scaffold(topBar = { LogSheetTopAppBar(onClick = { scope.launch { navigationState.open() } }) }) {
            Column(Modifier.padding(it)) {
                HeaderDashBoard(onClick = { Log.i("Alvaro", "Patitos Feos") })
                Spacer(modifier = Modifier.height(24.dp))
                BodyDashBoard()
            }
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HeaderDashBoard(isDrawerMenu: Boolean = false, onClick: () -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(horizontal = 32.dp)
    ) {

        BadgedBox(
            badge = {
                Badge(
                    modifier = Modifier
                        .size(9.dp)
                        .offset(x = -(8).dp, y = 12.dp),
                    containerColor = Color(0xff43936C)
                )
            }) {
            Image(
                painter = painterResource(id = R.drawable.profile_sample),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape),
                contentDescription = null,
            )

        }
        Spacer(modifier = Modifier.width(8.dp))
        Column(verticalArrangement = Arrangement.Center) {
            Text(
                text = "Good Morning,",
                style = MaterialTheme.typography.labelSmall,
                fontSize = 14.sp,
                color = Color(0xff5D5F61)
            )

            Text(
                text = "Alvaro Figueroa",
                style = MaterialTheme.typography.labelSmall,
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium
            )
        }
        Spacer(modifier = Modifier.weight(1f))

        if (isDrawerMenu) {
            IconButton(onClick = { onClick() }) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = null,
                    tint = BluePrimary
                )
            }
        } else {
            IconButton(
                onClick = { onClick() },
                modifier = Modifier
                    .clip(CircleShape)
                    .background(Color(0xffEBF0F4))
            ) {
                BadgedBox(badge = {
                    Badge(
                        modifier = Modifier
                            .offset(x = (-6.5).dp, y = (11).dp)
                            .size(7.dp)
                    )
                }) {

                    Icon(
                        imageVector = Icons.Outlined.Notifications,
                        contentDescription = null,
                        tint = Color(0xff717375)
                    )
                }
            }
        }
    }
}

@Composable
fun BodyDashBoard() {
    Column(modifier = Modifier.padding(horizontal = 32.dp)) {
        Text(
            text = stringResource(id = R.string.what_dashboard),
            style = MaterialTheme.typography.labelSmall,
            color = Color(0xff717375)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            BodyDashBoardCard(label = stringResource(id = R.string.PPU1_title))
            BodyDashBoardCard(label = stringResource(id = R.string.SSGPP_title))
        }

    }

}

@Composable
fun BodyDashBoardCard(label: String) {
    Card(
        Modifier
            .size(width = 150.dp, height = 100.dp)
            .clickable { }, colors = CardDefaults.cardColors(
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


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LogSheetTopAppBar(onClick: () -> Unit) {
    TopAppBar(
        modifier = Modifier.padding(horizontal = 12.dp),
        title = {
            Text(
                stringResource(id = R.string.dashboard_title),
                style = MaterialTheme.typography.labelMedium,
                color = BluePrimary
            )
        },
        navigationIcon = {
            IconButton(onClick = { onClick() }) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = null,
                    tint = BluePrimary
                )
            }
        })
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DrawerMenuApp(onClick: () -> Unit) {

    var selectedItemIndex by rememberSaveable {
        mutableStateOf(0)
    }

    ModalDrawerSheet {
        Spacer(modifier = Modifier.height(32.dp))
        HeaderDashBoard(onClick = { onClick() }, isDrawerMenu = true)
        Spacer(modifier = Modifier.height(24.dp))
        Divider(modifier = Modifier.padding(horizontal = 32.dp))
        Spacer(modifier = Modifier.height(12.dp))
        getItemsMenu.forEachIndexed { index, menuItem ->
            NavigationDrawerItem(
                label = {
                    Text(
                        text = stringResource(id = menuItem.title),
                        style = MaterialTheme.typography.labelSmall,
                        color = if (index == selectedItemIndex) Color(0xff347AB6) else Color(
                            0xff5D5F61
                        )
                    )
                },
                icon = {
                    Icon(
                        painter = painterResource(id = menuItem.icon),
                        contentDescription = null,
                        modifier = Modifier.size(28.dp),
                        tint = Color(0xff347AB6)
                    )
                },
                selected = index == selectedItemIndex,
                onClick = { selectedItemIndex = index },
                modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
            )

        }
        DrawerFooter()
    }

}

@Composable
fun DrawerFooter() {
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.BottomStart) {
        Row(modifier = Modifier
            .clickable { }
            .padding(16.dp)) {
            Icon(imageVector = Icons.Default.Settings, contentDescription = null)
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = stringResource(id = R.string.Setting))
        }
    }

}


@Preview
@Composable
fun previewDashBoardScreen() {
    LogsheetTheme {
        DashBoardScreen()
    }
}