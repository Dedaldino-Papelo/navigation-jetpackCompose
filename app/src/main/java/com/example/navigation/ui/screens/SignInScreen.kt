package com.example.navigation.ui.screens

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.navigation.R
import com.example.navigation.ui.theme.NavigationTheme

@Composable
fun SignInScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    var userName by rememberSaveable { mutableStateOf("") }
    var Password by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(25.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Sign In",
            fontSize = 30.sp,
            modifier = Modifier
                .padding(bottom = 30.dp)
        )

        EditTextField(
            label = R.string.username,
            value = userName,
            onValueChange = { userName = it },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Next
            )
        )

        Spacer(modifier = Modifier.padding(vertical = 10.dp))

        EditTextField(
            label = R.string.password,
            value = Password,
            onValueChange = { Password = it },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            )
        )

        SignInButton(
            onClick = { navController.navigate("Home?name=$userName") }
        )
    }
}

@Composable
fun EditTextField(
    @StringRes label: Int,
    value: String,
    onValueChange: (String) -> Unit,
    keyboardOptions: KeyboardOptions,
    modifier: Modifier = Modifier
){
    TextField(
        value = value,
        onValueChange = onValueChange,
        keyboardOptions = keyboardOptions,
        label = { Text(stringResource(label)) },
        singleLine = true,
        modifier = Modifier
            .fillMaxWidth()
    )
}

@Composable
fun SignInButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
){
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp),
        onClick = onClick
    ) {
        Text(text = "SignIn")
    }
}

@Preview(showBackground = true)
@Composable
fun SignInPreview() {
    NavigationTheme {
        SignInScreen(navController = rememberNavController())
    }
}