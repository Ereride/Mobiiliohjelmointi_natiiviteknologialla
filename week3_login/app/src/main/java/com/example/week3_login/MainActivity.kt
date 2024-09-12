package com.example.week3_login

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.dp
import com.example.week3_login.ui.theme.Week3_loginTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Week3_loginTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    LoginForm()
                }
            }
        }
    }
}



@Composable
fun LoginForm () {
    var email: String by remember { mutableStateOf(value = "") }
    var password: String by remember { mutableStateOf("") }

Column (
    verticalArrangement = Arrangement.spacedBy(16.dp),
    horizontalAlignment = Alignment.CenterHorizontally,
    modifier = Modifier.padding(20.dp).fillMaxSize()

) {
    Text(
        text = "Login",
        color = MaterialTheme.colorScheme.primary,
        fontSize = 28.sp,
        modifier = Modifier.padding(bottom = 16.dp)
    )
    OutlinedTextField(
        value = email,
        onValueChange = {email = it},
        label = { Text(text = stringResource(R.string.email)) },
        placeholder = { Text("example@gmail.com")},
        trailingIcon = { Icon(Icons.Filled.Email, contentDescription = null) },
        singleLine = true,
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
    )

    OutlinedTextField(
        value = password,
        onValueChange = {password = it},
        label = { Text("Enter password") },
        singleLine = true,
        trailingIcon = { Icon(Icons.Filled.Lock, contentDescription = null) },
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
    )
}
}


