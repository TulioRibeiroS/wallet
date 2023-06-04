package dev.mlds.wallet.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp

@Immutable
data class ExtendedColors(
    val ToolbarBackground: Color,
    val background: Color,
    val text: Color,
    val primary: Color,
    val enabledColor: Color,
    val enabledTextColor: Color,
    val TitleScreenText: Color,
    val darkText: Color,
    val ligthText: Color,
    val primaryButton: Color,
    val secondButton: Color,
    val secondButtonText: Color
)

@Immutable
data class CardColors(
    val background: Color,
    val text: Color
)

@Immutable
data class CustomTypography(
    val body: TextStyle,
    val title: TextStyle,
    val subTitle: TextStyle,
    val label: TextStyle,
    val header: TextStyle
)

private val LocalExtendedColors = staticCompositionLocalOf {
    ExtendedColors(
        ToolbarBackground = Color.Unspecified,
        background = Color.Unspecified,
        text = Color.Unspecified,
        primary = Color.Unspecified,
        enabledColor = Color.Unspecified,
        enabledTextColor = Color.Unspecified,
        TitleScreenText = Color.Unspecified,
        darkText = Color.Unspecified,
        ligthText = Color.Unspecified,
        primaryButton = Color.Unspecified,
        secondButton = Color.Unspecified,
        secondButtonText = Color.Unspecified
    )
}

private val LocalCardColors = staticCompositionLocalOf {
    CardColors(
        background = Color.Unspecified,
        text = Color.Unspecified
    )
}

val LocalCustomTypography = staticCompositionLocalOf {
    CustomTypography(
        body = TextStyle.Default,
        title = TextStyle.Default,
        subTitle = TextStyle.Default,
        label = TextStyle.Default,
        header = TextStyle.Default
    )
}

@Composable
fun WalletLigthTheme(
    content: @Composable () -> Unit
) {
    val extendedColors = ExtendedColors(
        ToolbarBackground = ToolbarBackground,
        background = Background,
        text = Text,
        primary = primary,
        enabledColor = EnabledColor,
        enabledTextColor = EnabledTextColor,
        TitleScreenText = TitleScreenText,
        darkText = DarkText,
        ligthText = LigthText,
        primaryButton = PrimaryButton,
        secondButton = SecondButton,
        secondButtonText = secondButtonText
    )

    val cardColors = CardColors(
        background = cardGreen,
        text = cardGreenText
    )

    val customTypography = CustomTypography(
        body = TextStyle(fontSize = 16.sp),
        title = TextStyle(fontSize = 28.sp, color = Text),
        subTitle = TextStyle(fontSize = 20.sp, color = Text),
        label = TextStyle(fontSize = 14.sp, color = fieldTitle),
        header = TextStyle(fontSize = 22.sp, color = LigthText)
    )
    CompositionLocalProvider(
        LocalExtendedColors provides extendedColors,
        LocalCardColors provides cardColors,
        LocalCustomTypography provides customTypography
    ) {
        MaterialTheme(
            /* colors = ..., typography = ..., shapes = ... */
            typography = WalletTypography,
            content = content
        )
    }
}

object WalletLigthTheme {
    val colors: ExtendedColors
        @Composable
        get() = LocalExtendedColors.current
    val cardColors: CardColors
        @Composable
        get() = LocalCardColors.current
    val typography: CustomTypography
        @Composable
        get() = LocalCustomTypography.current
}