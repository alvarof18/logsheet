package com.alvarof18.logsheet.ssgpp.ui.screens


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.alvarof18.logsheet.R
import com.alvarof18.logsheet.ssgpp.ui.common.CustomChip
import com.alvarof18.logsheet.ssgpp.ui.common.CustomTextField
import com.alvarof18.logsheet.ssgpp.ui.common.HeaderForm
import com.alvarof18.logsheet.ssgpp.ui.common.LabelSSGPP
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
    }
}

@Composable
fun BodyFormCondensing(){

    val loadControlModeList = listOf("Manual", "ALR")
    val controlModeList = listOf("GOV", "Load Limit")
    val loadChargingList = listOf("Hold", "3%", "5%")
    val offONList = listOf("OFF", "ON")

    Column() {

        Text(
            text = "Air Conditioner", style = MaterialTheme.typography.labelMedium,
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold
        )
        Spacer(modifier = Modifier.height(8.dp))
        CustomTextField(
            textInput = "0",
            label = R.string.temperature_label,
            onValueChange = {},
        )
        Spacer(modifier = Modifier.height(8.dp))
        CustomTextField(
            textInput = "0",
            label = R.string.humidity_label,
            onValueChange = {},
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Generator", style = MaterialTheme.typography.labelMedium,
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold
        )
        Spacer(modifier = Modifier.height(8.dp))
        CustomTextField(
            textInput = "0,00",
            label = R.string.generator_gross_label,
            onValueChange = {},
        )
        Spacer(modifier = Modifier.height(8.dp))
        CustomTextField(
            textInput = "0,00",
            label = R.string.own_used_label,
            onValueChange = {},
        )
        Spacer(modifier = Modifier.height(8.dp))
        CustomTextField(
            textInput = "0,00",
            label = R.string.SSGPP_bruto_label,
            onValueChange = {},
        )
        Spacer(modifier = Modifier.height(8.dp))
        CustomTextField(
            textInput = "0,00",
            label = R.string.generator_voltage_label,
            onValueChange = {},
        )
        Spacer(modifier = Modifier.height(8.dp))
        CustomTextField(
            textInput = "0,00",
            label = R.string.generator_current_label,
            onValueChange = {},
        )
        Spacer(modifier = Modifier.height(8.dp))
        CustomTextField(
            textInput = "0,00",
            label = R.string.generator_frequency_label,
            onValueChange = {},
        )
        Spacer(modifier = Modifier.height(8.dp))
        CustomTextField(
            textInput = "0,00",
            label = R.string.generator_mvar_label,
            onValueChange = {},
        )
        Spacer(modifier = Modifier.height(8.dp))
        CustomTextField(
            textInput = "0,00",
            label = R.string.exciter_voltage_label,
            onValueChange = {},
        )
        Spacer(modifier = Modifier.height(8.dp))
        CustomTextField(
            textInput = "0,00",
            label = R.string.exciter_current_label,
            onValueChange = {},
        )
        Spacer(modifier = Modifier.height(8.dp))
        CustomTextField(
            textInput = "0,00",
            label = R.string.generator_PF_label,
            onValueChange = {},
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Load Control", style = MaterialTheme.typography.labelMedium,
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold
        )
        Spacer(modifier = Modifier.height(8.dp))
        CustomTextField(
            textInput = "0,00",
            label = R.string.alt_target_label,
            onValueChange = {},
        )
        Spacer(modifier = Modifier.height(8.dp))
        CustomTextField(
            textInput = "0,00",
            label = R.string.gov_setting_label,
            onValueChange = {},
        )
        Spacer(modifier = Modifier.height(8.dp))
        CustomTextField(
            textInput = "0,00",
            label = R.string.load_limit_label,
            onValueChange = {},
        )

        Spacer(modifier = Modifier.height(8.dp))
        CustomTextField(
            textInput = "0,00",
            label = R.string.setter_90R_label,
            onValueChange = {},
        )

        Spacer(modifier = Modifier.height(8.dp))
        CustomTextField(
            textInput = "0,00",
            label = R.string.setter_55R_label,
            onValueChange = {},
        )
        Spacer(modifier = Modifier.height(8.dp))
        CustomTextField(
            textInput = "0,00",
            label = R.string.setter_57R_label,
            onValueChange = {},
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = stringResource(id = R.string.load_control_mode_label),
            style = MaterialTheme.typography.labelMedium
        )
        Spacer(modifier = Modifier.height(8.dp))
        CustomChip(items = 2, valueList = loadControlModeList)
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = stringResource(id = R.string.control_mode_label),
            style = MaterialTheme.typography.labelMedium
        )
        Spacer(modifier = Modifier.height(8.dp))
        CustomChip(items = 2, valueList = controlModeList)
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = stringResource(id = R.string.alt_load_changing_rate_label),
            style = MaterialTheme.typography.labelMedium
        )
        Spacer(modifier = Modifier.height(8.dp))
        CustomChip(items = 3, valueList = loadChargingList)
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = stringResource(id = R.string.IPR_label),
            style = MaterialTheme.typography.labelMedium
        )
        Spacer(modifier = Modifier.height(8.dp))
        CustomChip(items = 2, valueList = offONList)
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = stringResource(id = R.string.PSS_label),
            style = MaterialTheme.typography.labelMedium
        )
        Spacer(modifier = Modifier.height(8.dp))
        CustomChip(items = 2, valueList = offONList)
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = stringResource(id = R.string.AQR_label),
            style = MaterialTheme.typography.labelMedium
        )
        Spacer(modifier = Modifier.height(8.dp))
        CustomChip(items = 2, valueList = offONList)
        Spacer(modifier = Modifier.height(8.dp))
        CustomTextField(
            textInput = "0,00",
            label = R.string.stator_coil_temperature_v1_label,
            onValueChange = {},
        )
        Spacer(modifier = Modifier.height(8.dp))
        CustomTextField(
            textInput = "0,00",
            label = R.string.stator_coil_temperature_w1_label,
            onValueChange = {},
        )
        Spacer(modifier = Modifier.height(8.dp))
        CustomTextField(
            textInput = "0,00",
            label = R.string.stator_coil_temperature_u2_label,
            onValueChange = {},
        )
        Spacer(modifier = Modifier.height(8.dp))
        CustomTextField(
            textInput = "0,00",
            label = R.string.stator_coil_temperature_v2_label,
            onValueChange = {},
        )
        Spacer(modifier = Modifier.height(8.dp))
        CustomTextField(
            textInput = "0,00",
            label = R.string.stator_coil_temperature_w2_label,
            onValueChange = {},
        )
        Spacer(modifier = Modifier.height(8.dp))
        CustomTextField(
            textInput = "0,00",
            label = R.string.air_cooler_temp_inlet_label,
            onValueChange = {},
        )
        Spacer(modifier = Modifier.height(8.dp))
        CustomTextField(
            textInput = "0,00",
            label = R.string.air_cooler_temp_outlet_label,
            onValueChange = {},
        )
        Spacer(modifier = Modifier.height(24.dp))
        LabelSSGPP(title = R.string.confirmation)
        Spacer(modifier = Modifier.height(24.dp))
        OutlinedButton(
            shape = RoundedCornerShape(8.dp),
            border = BorderStroke(1.dp, color = Color(0xffBBABEC1)),
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp),
            onClick = { /*TODO*/ }) {
            Icon(imageVector = Icons.Default.CameraAlt, contentDescription = "", tint = Color.Black)
        }
        Spacer(modifier = Modifier.height(8.dp))
        CustomTextField(
            textInput = "",
            label = R.string.remarks_label,
            onValueChange = {},
        )
        Spacer(modifier = Modifier.height(8.dp))
        CustomTextField(
            textInput = "",
            label = R.string.submitted_by_label,
            onValueChange = {},
        )

        Spacer(modifier = Modifier.height(8.dp))
        CustomTextField(
            textInput = "",
            label = R.string.approver_label,
            onValueChange = {},
        )

        Spacer(modifier = Modifier.height(16.dp))
        FilledTonalButton(
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.filledTonalButtonColors(containerColor = Color(0xff347AB6)),
            onClick = { /*TODO*/ }) {
            Text(text = "Save", style = MaterialTheme.typography.labelSmall, color = Color.White)
        }
        FilledTonalButton(
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.filledTonalButtonColors(containerColor = Color(0xffCB3A31)),
            onClick = { /*TODO*/ }) {
            Text(text = "Cancel", style = MaterialTheme.typography.labelSmall, color = Color.White)
        }
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