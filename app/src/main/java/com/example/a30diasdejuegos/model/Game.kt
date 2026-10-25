package com.example.a30diasdejuegos.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Game(
    val dayNumber: Int,
    @param:StringRes val nameResourceId: Int,
    @param:StringRes val descriptionResourceId: Int,
    @param:DrawableRes val imageResourceId: Int
)
