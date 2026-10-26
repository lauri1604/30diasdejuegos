package com.example.a30diasdejuegos.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.example.a30diasdejuegos.R

private val firstTimeWriting = FontFamily(
    Font(R.font.first_time_writing, FontWeight.Normal)
)

private val typeLightSans = FontFamily(
    Font(R.font.type_light_sans, FontWeight.Normal)
)

private val materialTypography = Typography()

val Typography = materialTypography.copy(
    headlineMedium = materialTypography.headlineMedium.copy(
        fontFamily = firstTimeWriting,
        fontWeight = FontWeight.Bold
    ),
    titleLarge = materialTypography.titleLarge.copy(
        fontFamily = firstTimeWriting,
        fontWeight = FontWeight.Bold
    ),
    labelLarge = materialTypography.labelLarge.copy(
        fontFamily = firstTimeWriting,
        fontWeight = FontWeight.Bold
    ),
    bodyLarge = materialTypography.bodyLarge.copy(
        fontFamily = typeLightSans
    ),
    bodyMedium = materialTypography.bodyMedium.copy(
        fontFamily = typeLightSans
    )
)
