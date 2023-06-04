package dev.mlds.wallet.ui.components

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import dev.mlds.wallet.ui.theme.WalletLigthTheme

@Composable
fun PrimaryButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable RowScope.() -> Unit,
    enabled: Boolean = true
) {
    Button(
        shape = AbsoluteRoundedCornerShape(12.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = WalletLigthTheme.colors.primaryButton,
            contentColor = WalletLigthTheme.colors.text,
            disabledContainerColor = WalletLigthTheme.colors.enabledColor,
            disabledContentColor = WalletLigthTheme.colors.enabledTextColor
        ),
        modifier = modifier.height(55.dp),
        enabled = enabled,
        onClick = onClick,
        content = {
            ProvideTextStyle(
                value = WalletLigthTheme.typography.body
            ) {
                content()
            }
        }
    )
}

@Composable
fun SecondButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable RowScope.() -> Unit
) {
    Button(
        shape = AbsoluteRoundedCornerShape(12.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = WalletLigthTheme.colors.secondButton,
            contentColor = WalletLigthTheme.colors.secondButtonText
        ),
        modifier = modifier.height(55.dp),
        onClick = onClick,
        content = {
            ProvideTextStyle(
                value = WalletLigthTheme.typography.body
            ) {
                content()
            }
        }
    )
}

@Composable
fun ThirdButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable RowScope.() -> Unit
) {
    Button(
        shape = AbsoluteRoundedCornerShape(12.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Unspecified,
            contentColor = WalletLigthTheme.colors.text
        ),
        modifier = modifier.height(55.dp),
        onClick = onClick,
        content = {
            ProvideTextStyle(
                value = WalletLigthTheme.typography.body
            ) {
                content()
            }
        }
    )
}