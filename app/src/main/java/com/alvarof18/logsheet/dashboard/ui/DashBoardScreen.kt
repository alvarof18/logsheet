package com.alvarof18.logsheet.dashboard.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alvarof18.logsheet.R
import com.alvarof18.logsheet.ui.theme.BluePrimary
import com.alvarof18.logsheet.ui.theme.LogsheetTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashBoardScreen() {
    Scaffold(topBar = { LogSheetTopAppBar() }) {
        Column(Modifier.padding(it)) {
            HeaderDashBoard()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HeaderDashBoard(modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(horizontal = 16.dp)
    ) {

        Box(contentAlignment = Alignment.TopEnd) {
            Image(
                painter = painterResource(id = R.drawable.profile_sample),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape),
                contentDescription = null,
            )
            Image(
                painter = painterResource(id = R.drawable.dot_online),
                contentDescription = null,
                modifier = Modifier.size(15.dp),
                contentScale = ContentScale.Crop
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
        IconButton(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .clip(CircleShape)
                    .background(Color(0xffEBF0F4))
            ) {
                Icon(
                    imageVector = Icons.Outlined.Notifications,
                    contentDescription = null,
                    tint = Color(0xff717375)
                )

            }
    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LogSheetTopAppBar() {
    TopAppBar(
        title = {
            Text(
                "Dashboard",
                style = MaterialTheme.typography.labelMedium,
                color = BluePrimary
            )
        },
        navigationIcon = {
            IconButton(onClick = { }) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = null,
                    tint = BluePrimary
                )
            }
        })
}

@Composable
fun DrawerMenuApp() {


}

@Preview
@Composable
fun previewDashBoardScreen() {
    LogsheetTheme {
        DashBoardScreen()
    }
}