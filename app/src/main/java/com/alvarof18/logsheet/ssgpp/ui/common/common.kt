package com.alvarof18.logsheet.ssgpp.ui.common

import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.alvarof18.logsheet.Backbutton
import com.alvarof18.logsheet.R


@Composable
fun LabelSSGPP(showTextLabel: Boolean = false, @StringRes title: Int) {

    if (showTextLabel) {
        Text(
            text = "SSGPP",
            style = MaterialTheme.typography.labelMedium.copy(fontSize = 14.sp),
            fontWeight = FontWeight.SemiBold
        )
        Spacer(modifier = Modifier.height(4.dp))
    }

    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(6.dp))
            .fillMaxWidth()
            .height(36.dp)
            .background(
                color = Color(0xffD6E4F0),
            )
    ) {
        Text(
            text = stringResource(id = title),
            style = MaterialTheme.typography.labelSmall.copy(
                fontSize = 14.sp,
                color = Color(0xff717375)
            ),
            modifier = Modifier
                .padding(start = 16.dp)
                .align(Alignment.CenterStart)
        )
    }
}


@Composable
fun HeaderForm(navController: NavController) {
    val timestampFormField by remember {
        mutableStateOf("")
    }

    val timeFormField by remember {
        mutableStateOf("")
    }

    val groupShiftList = listOf("A", "B", "C", "D")

    Column {
        Backbutton(onClick = {navController.popBackStack()})
        Spacer(modifier = Modifier.height(12.dp))
        LabelSSGPP(title = R.string.information)
        Spacer(modifier = Modifier.height(18.dp))
        CustomTextField(
            textInput = timestampFormField,
            label = R.string.form_timestamp,
            onValueChange = {},
            readOnly = true
        )
        Spacer(modifier = Modifier.height(8.dp))
        CustomTextField(
            textInput = timeFormField,
            label = R.string.form_time,
            onValueChange = {},
            readOnly = true
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Group Shift",
            style = MaterialTheme.typography.labelMedium,
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold
        )
        Spacer(modifier = Modifier.height(8.dp))
        CustomChip(items = 4, valueList = groupShiftList)
        Spacer(modifier = Modifier.height(16.dp))
    }

}


@Composable
fun CustomChip(items: Int, valueList: List<String>) {
    var selectedItem by remember {
        mutableStateOf(-1)
    }

    if (valueList.size < items || valueList.size > items) {
        throw IllegalArgumentException("El valor de item y valueList deben ser iguales")
    }

    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
        repeat(items) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .border(
                        border = BorderStroke(1.dp, color = Color(0xffD8DCE0)),
                        shape = RoundedCornerShape(8.dp)
                    )
                    .weight(1f)
                    .height(40.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(if (selectedItem == it) Color.Magenta else Color.White)
                    .clickable {
                        selectedItem = if (selectedItem == it) {
                            -1
                        } else {
                            it
                        }
                    }
            ) {
                Text(text = valueList[it], style = MaterialTheme.typography.labelSmall)
            }
            if (it != (items - 1))
                Spacer(modifier = Modifier.width(10.dp))
        }

    }
}



@Composable
fun CustomTextField(
    textInput: String,
    @StringRes label: Int,
    hint: String = "",
    onValueChange: (String) -> Unit,
    keyboardType: KeyboardType = KeyboardType.Text,
    readOnly: Boolean = false
) {
    Column {
        Text(text = stringResource(id = label), style = MaterialTheme.typography.labelMedium)
        Spacer(modifier = Modifier.size(4.dp))
        OutlinedTextField(
            value = textInput,
            readOnly = readOnly,
            singleLine = true,
            onValueChange = { onValueChange(it) },
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text(text = hint) },
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color(0xffD8DCE0),
                unfocusedBorderColor = Color(0xffD8DCE0),
            ),
            shape = RoundedCornerShape(8.dp),
            keyboardOptions = KeyboardOptions(
                keyboardType = keyboardType
            ),

            )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCustomTextField() {

    CustomTextField(textInput = "Hola", label = R.string.approver_label, onValueChange = {})
}