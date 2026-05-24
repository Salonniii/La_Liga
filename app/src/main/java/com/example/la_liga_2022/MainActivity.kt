package com.example.la_liga_2022

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.la_liga_2022.ui.navigation.AppNavHost
import com.example.la_liga_2022.ui.theme.La_Liga_2022Theme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            La_Liga_2022Theme {
                AppNavHost()
            }
        }
    }
}
