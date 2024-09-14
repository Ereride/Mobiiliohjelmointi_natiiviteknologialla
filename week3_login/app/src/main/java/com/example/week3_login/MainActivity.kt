package com.example.week3_login

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.dp
import com.example.week3_login.ui.theme.Week3_loginTheme
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.platform.LocalFocusManager

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Week3_loginTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { _ -> // Poistetaan käyttämätön innerPadding
                    LoginForm()
                }
            }
        }
    }
}

@Composable
fun LoginForm() {
    var email: String by remember { mutableStateOf(value = "") }
    var password: String by remember { mutableStateOf(value = "") }
    var passwordHidden: Boolean by remember { mutableStateOf(value = true) }
    val passwordFocusRequester = remember { FocusRequester() }
    val isPasswordFocused = remember { mutableStateOf(value = false) }

    val textFieldColors = TextFieldDefaults.colors(
        focusedContainerColor = Color.Transparent,
        unfocusedContainerColor = Color.Transparent,
        focusedIndicatorColor = colorResource(id = R.color.purple_700),
        unfocusedIndicatorColor = Color.Gray
    )

    val trailIcon = if (isPasswordFocused.value) {
        Icons.Filled.Visibility
    } else {
        Icons.Filled.Lock
    }


    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier
            .padding(20.dp)
            .fillMaxSize()

    ) {
        Text(
            text = "Login",
            color = colorResource(id = R.color.purple_700),
            fontSize = 28.sp,
            modifier = Modifier.padding(bottom = 16.dp, top = 20.dp),
            textAlign = TextAlign.Left
        )

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text(text = "Username") },
            placeholder = { Text (text = "example@gmail.com")},
            trailingIcon = { Icon(Icons.Filled.Email, contentDescription = null) },
            singleLine = true,
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            colors = textFieldColors
        )

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text(text = "Enter password") },
            singleLine = true,
            visualTransformation =
            if (passwordHidden) PasswordVisualTransformation() else VisualTransformation.None,
           trailingIcon = {
                IconButton(onClick = { passwordHidden = !passwordHidden }) {
                    val visibilityIcon =
                        if (passwordHidden) trailIcon else Icons.Filled.VisibilityOff
                    val description = if (passwordHidden) "Show password" else "Hide password"
                    Icon(imageVector = visibilityIcon, contentDescription = description)
                }
            },
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
                .focusRequester(passwordFocusRequester)
                .onFocusChanged { focusState ->
                    isPasswordFocused.value = focusState.isFocused
                },
            colors = textFieldColors
        )

        Button(
            onClick = {},
            shape = RoundedCornerShape(4.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(color = 0xFF6200EE),
                contentColor = Color.White
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),

            ) {
            Text(text = "Submit",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,

            )}
    }
}
