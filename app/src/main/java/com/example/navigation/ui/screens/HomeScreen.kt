package com.example.navigation.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.navigation.ui.theme.NavigationTheme

@Composable
fun HomeScreen(name: String?, navController: NavHostController, modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Welcome ${name}",
            fontSize = 24.sp
        )

        Button(
            onClick = { navController.popBackStack() }
        ) {
          Text(text = "Back")
        }

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NavigationTheme {
        HomeScreen(name= "", navController = rememberNavController())
    }
}