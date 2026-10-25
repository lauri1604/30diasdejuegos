package com.example.a30diasdejuegos.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.example.a30diasdejuegos.R

private val patrickHand = FontFamily(
    Font(R.font.patrick_hand_regular, FontWeight.Normal)
)

private val materialTypography = Typography()

val Typography = materialTypography.copy(
    headlineMedium = materialTypography.headlineMedium.copy(fontFamily = patrickHand),
    titleLarge = materialTypography.titleLarge.copy(fontFamily = patrickHand),
    labelLarge = materialTypography.labelLarge.copy(fontFamily = patrickHand),
    bodyLarge = materialTypography.bodyLarge.copy(fontFamily = patrickHand),
    bodyMedium = materialTypography.bodyMedium.copy(fontFamily = patrickHand)
)
