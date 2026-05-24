package com.example.la_liga_2022.ui.theme.screen

import com.example.la_liga_2022.R

fun getTeamLogo(teamName: String): Int {
    return when (teamName) {
        "Barcelona" -> R.drawable.barcelona
        "Real Madrid" -> R.drawable.real_madrid
        "Atletico Madrid" -> R.drawable.atletico_madrid
        "Sevilla" -> R.drawable.sevilla
        "Real Sociedad" -> R.drawable.real_sociedad
        "Villarreal" -> R.drawable.villarreal
        "Real Betis" -> R.drawable.real_betis
        "Osasuna" -> R.drawable.osasuna
        "Athletic Bilbao" -> R.drawable.athletic_bilbao
        "Valencia" -> R.drawable.valencia
        "Celta Vigo" -> R.drawable.celta_vigo
        "Rayo Vallecano" -> R.drawable.rayo_vallecano
        "Mallorca" -> R.drawable.mallorca
        "Getafe" -> R.drawable.getafe
        "Espanyol" -> R.drawable.espanyol
        "Almeria" -> R.drawable.almeria
        "Cadiz" -> R.drawable.cadiz
        "Elche" -> R.drawable.elche
        "Granada" -> R.drawable.granada
        "Valladolid" -> R.drawable.valladolid
        else -> R.drawable.ic_launcher_foreground
    }
}
