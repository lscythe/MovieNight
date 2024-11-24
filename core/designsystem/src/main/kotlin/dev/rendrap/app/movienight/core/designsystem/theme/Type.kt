package dev.rendrap.app.movienight.core.designsystem.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.googlefonts.GoogleFont
import dev.rendrap.app.movienight.core.resource.AppFont.LEXEND_DECA_BLACK
import dev.rendrap.app.movienight.core.resource.AppFont.LEXEND_DECA_BOLD
import dev.rendrap.app.movienight.core.resource.AppFont.LEXEND_DECA_EXTRA_BOLD
import dev.rendrap.app.movienight.core.resource.AppFont.LEXEND_DECA_MEDIUM
import dev.rendrap.app.movienight.core.resource.AppFont.LEXEND_DECA_REGULAR
import dev.rendrap.app.movienight.core.resource.AppFont.LEXEND_DECA_SEMI_BOLD
import dev.rendrap.app.movienight.core.resource.AppFont.PUBLIC_SANS_MEDIUM
import dev.rendrap.app.movienight.core.resource.AppFont.PUBLIC_SANS_REGULAR
import dev.rendrap.app.movienight.core.resource.AppFont.PUBLIC_SANS_SEMI_BOLD
import dev.rendrap.app.movienight.core.designsystem.R

val provider = GoogleFont.Provider(
    providerAuthority = "com.google.android.gms.fonts",
    providerPackage = "com.google.android.gms",
    certificates = R.array.com_google_android_gms_fonts_certs
)

val bodyFontFamily = FontFamily(
    Font(
        googleFont = GoogleFont("Public Sans"),
        fontProvider = provider,
    ),
    Font(
        resId = PUBLIC_SANS_MEDIUM,
        weight = FontWeight.Medium
    ),
    Font(
        resId = PUBLIC_SANS_REGULAR,
        weight = FontWeight.Normal
    ),
    Font(
        resId = PUBLIC_SANS_SEMI_BOLD,
        weight = FontWeight.SemiBold
    ),
)

val displayFontFamily = FontFamily(
    Font(
        googleFont = GoogleFont("DM Sans"),
        fontProvider = provider,
    ),
    Font(
        resId = LEXEND_DECA_BLACK,
        weight = FontWeight.Black
    ),
    Font(
        resId = LEXEND_DECA_BOLD,
        weight = FontWeight.Bold
    ),
    Font(
        resId = LEXEND_DECA_EXTRA_BOLD,
        weight = FontWeight.ExtraBold
    ),
    Font(
        resId = LEXEND_DECA_MEDIUM,
        weight = FontWeight.Medium
    ),
    Font(
        resId = LEXEND_DECA_REGULAR,
        weight = FontWeight.Normal
    ),
    Font(
        resId = LEXEND_DECA_SEMI_BOLD,
        weight = FontWeight.SemiBold
    ),
)

// Default Material 3 typography values
val baseline = Typography()

val AppTypography = Typography(
    displayLarge = baseline.displayLarge.copy(fontFamily = displayFontFamily),
    displayMedium = baseline.displayMedium.copy(fontFamily = displayFontFamily),
    displaySmall = baseline.displaySmall.copy(fontFamily = displayFontFamily),
    headlineLarge = baseline.headlineLarge.copy(fontFamily = displayFontFamily),
    headlineMedium = baseline.headlineMedium.copy(fontFamily = displayFontFamily),
    headlineSmall = baseline.headlineSmall.copy(fontFamily = displayFontFamily),
    titleLarge = baseline.titleLarge.copy(fontFamily = displayFontFamily),
    titleMedium = baseline.titleMedium.copy(fontFamily = displayFontFamily),
    titleSmall = baseline.titleSmall.copy(fontFamily = displayFontFamily),
    bodyLarge = baseline.bodyLarge.copy(fontFamily = bodyFontFamily),
    bodyMedium = baseline.bodyMedium.copy(fontFamily = bodyFontFamily),
    bodySmall = baseline.bodySmall.copy(fontFamily = bodyFontFamily),
    labelLarge = baseline.labelLarge.copy(fontFamily = bodyFontFamily),
    labelMedium = baseline.labelMedium.copy(fontFamily = bodyFontFamily),
    labelSmall = baseline.labelSmall.copy(fontFamily = bodyFontFamily),
)

