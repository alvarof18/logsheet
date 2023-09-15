package com.alvarof18.logsheet.login.ui


import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalMinimumTouchTargetEnforcement
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.alvarof18.logsheet.R
import com.alvarof18.logsheet.config.MainRoutes
import com.alvarof18.logsheet.ui.theme.LogsheetTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navController: NavController) {
    var email by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    var recuerdame by remember {
        mutableStateOf(false)
    }
    Column(
        Modifier
            .fillMaxSize()
            .padding(32.dp)
    ) {
        LoginTitle()
        Spacer(modifier = Modifier.height(32.dp))
        LoginCustomField(
            textInput = email,
            label = R.string.login_email_label,
            hint = R.string.hint_email,
            onValueChange = { email = it },
            keyboardType = KeyboardType.Email
        )
        Spacer(modifier = Modifier.height(24.dp))
        LoginCustomField(
            textInput = password,
            label = R.string.login_password_label,
            hint = R.string.hint_password,
            onValueChange = { password = it },
            isPasswordField = true,
        )
        Spacer(modifier = Modifier.height(24.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            CompositionLocalProvider(LocalMinimumTouchTargetEnforcement provides false) {
                Checkbox(
                    checked = recuerdame,
                    onCheckedChange = { recuerdame = it },
                    colors = CheckboxDefaults.colors(),

                    )
            }

            Spacer(modifier = Modifier.width(8.dp))
            Text(text = stringResource(id = R.string.remember_me_label), style = MaterialTheme.typography.labelSmall)
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(text = stringResource(id = R.string.forgot_password_label), style = MaterialTheme.typography.labelSmall)
            Spacer(modifier = Modifier.size(4.dp))
            ClickableText(
                text = AnnotatedString(stringResource(id = R.string.click_here_label)),
                onClick = {},
                style = MaterialTheme.typography.labelSmall.copy(color = Color(0xff347AB6))
            )
        }
        Spacer(modifier = Modifier.height(24.dp))
        Button(
            onClick = { navController.navigate(MainRoutes.DashboardGraph.route) },
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xff347AB6)
            )
        ) {
            Text(text = stringResource(id = R.string.sign_in_label), style = MaterialTheme.typography.labelSmall)
        }

    }
}


@Composable
fun LoginTitle() {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Box(
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape)
                .background(Color.Gray)
        )
        Spacer(Modifier.width(8.dp))
        Text(
            text = stringResource(id = R.string.title),
            style = MaterialTheme.typography.titleLarge
        )
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginCustomField(
    textInput: String,
    @StringRes label: Int,
    @StringRes hint: Int,
    isPasswordField: Boolean = false,
    onValueChange: (String) -> Unit,
    keyboardType: KeyboardType = KeyboardType.Text
) {
    Column {
        Text(text = stringResource(id = label), style = MaterialTheme.typography.labelMedium)
        Spacer(modifier = Modifier.size(4.dp))
        OutlinedTextField(
            value = textInput,
            singleLine = true,
            onValueChange = { onValueChange(it) },
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text(text = stringResource(id = hint)) },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color(0xffD8DCE0),
                unfocusedBorderColor = Color(0xffD8DCE0)
            ),
            shape = RoundedCornerShape(8.dp),
            keyboardOptions = KeyboardOptions(
                keyboardType = keyboardType
            ),
            visualTransformation = if (isPasswordField) PasswordVisualTransformation() else VisualTransformation.None,
        )

    }
}
