package com.alvarof18.logsheet.ssgpp.ui.screens


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.alvarof18.logsheet.R
import com.alvarof18.logsheet.ssgpp.ui.common.CustomTextField
import com.alvarof18.logsheet.ssgpp.ui.common.FooterForm
import com.alvarof18.logsheet.ssgpp.ui.common.HeaderForm
import com.alvarof18.logsheet.ui.theme.LogsheetTheme


@Composable
fun CondensingSystemScreen(navController: NavController){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        HeaderForm(navController = navController)
        Spacer(modifier = Modifier.height(16.dp))
        BodyFormCondensing()
        Spacer(modifier = Modifier.height(24.dp))
        FooterForm()
    }
}

@Composable
fun BodyFormCondensing(){

    Column() {
        Text(
            text = stringResource(id = R.string.main_steam_line_label), style = MaterialTheme.typography.labelMedium,
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold
        )
        Spacer(modifier = Modifier.height(8.dp))
        CustomTextField(
            textInput = "0",
            label = R.string.main_steam_pressure_label,
            onValueChange = {},
        )
        Spacer(modifier = Modifier.height(8.dp))
        CustomTextField(
            textInput = "0",
            label = R.string.mist_eliminator_level_label,
            onValueChange = {},
        )
        Spacer(modifier = Modifier.height(8.dp))
        CustomTextField(
            textInput = "0,00",
            label = R.string.differential_pressure_label,
            onValueChange = {},
        )
        Spacer(modifier = Modifier.height(8.dp))
        CustomTextField(
            textInput = "0,00",
            label = R.string.aa_001_label,
            onValueChange = {},
        )
        Spacer(modifier = Modifier.height(8.dp))
        CustomTextField(
            textInput = "0,00",
            label = R.string.aa_002_label,
            onValueChange = {},
        )
        Spacer(modifier = Modifier.height(8.dp))
        CustomTextField(
            textInput = "0,00",
            label = R.string.main_steam_temperature_label,
            onValueChange = {},
        )
        Spacer(modifier = Modifier.height(8.dp))
        CustomTextField(
            textInput = "0,00",
            label = R.string.inlet_turbine_label,
            onValueChange = {},
        )
        Spacer(modifier = Modifier.height(8.dp))
        CustomTextField(
            textInput = "0,00",
            label = R.string.total_steam_flow_label,
            onValueChange = {},
        )
        Spacer(modifier = Modifier.height(8.dp))
        CustomTextField(
            textInput = "0,00",
            label = R.string.stage_bowl_pressure_label,
            onValueChange = {},
        )
        Spacer(modifier = Modifier.height(8.dp))
        CustomTextField(
            textInput = "0,00",
            label = R.string.flow_ejector_label,
            onValueChange = {},
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = stringResource(id = R.string.turbine_generator_vibration_label), style = MaterialTheme.typography.labelMedium,
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold
        )
        Spacer(modifier = Modifier.height(8.dp))
        CustomTextField(
            textInput = "0,00",
            label = R.string.speed_label,
            onValueChange = {},
        )
        Spacer(modifier = Modifier.height(8.dp))
        CustomTextField(
            textInput = "0,00",
            label = R.string.eccentricity_label,
            onValueChange = {},
        )
        Spacer(modifier = Modifier.height(8.dp))
        CustomTextField(
            textInput = "0,00",
            label = R.string.thrust_position_label,
            onValueChange = {},
        )
        Spacer(modifier = Modifier.height(8.dp))
        CustomTextField(
            textInput = "0,00",
            label = R.string.vibration_bearing_x_label,
            onValueChange = {},
        )
        Spacer(modifier = Modifier.height(8.dp))
        CustomTextField(
            textInput = "0,00",
            label = R.string.vibration_bearing_y_label,
            onValueChange = {},
        )

        Spacer(modifier = Modifier.height(8.dp))
        CustomTextField(
            textInput = "0,00",
            label = R.string.vibration_bearing_2x_label,
            onValueChange = {},
        )

        Spacer(modifier = Modifier.height(8.dp))
        CustomTextField(
            textInput = "0,00",
            label = R.string.vibration_bearing_2y_label,
            onValueChange = {},
        )
        Spacer(modifier = Modifier.height(8.dp))
        CustomTextField(
            textInput = "0,00",
            label = R.string.vibration_bearing_3x_label,
            onValueChange = {},
        )
        Spacer(modifier = Modifier.height(8.dp))
        CustomTextField(
            textInput = "0,00",
            label = R.string.vibration_bearing_3y_label,
            onValueChange = {},
        )
        Spacer(modifier = Modifier.height(8.dp))
        CustomTextField(
            textInput = "0,00",
            label = R.string.vibration_bearing_4x_label,
            onValueChange = {},
        )
        Spacer(modifier = Modifier.height(8.dp))
        CustomTextField(
            textInput = "0,00",
            label = R.string.vibration_bearing_4y_label,
            onValueChange = {},
        )

    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCondensingSystemScreen(){
        LogsheetTheme {
            val navController = rememberNavController()
        CondensingSystemScreen(navController)
    }
}