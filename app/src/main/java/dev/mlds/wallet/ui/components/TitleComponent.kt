package dev.mlds.wallet.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.mlds.wallet.R
import dev.mlds.wallet.ui.theme.WalletLigthTheme

@Composable
fun TitleComponent() {
    Card(
        shape = RoundedCornerShape(bottomStart = 50.dp, bottomEnd = 50.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 5.dp
        )
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(WalletLigthTheme.colors.ToolbarBackground),
            contentAlignment = Alignment.Center
        ) {
            Text(
                modifier = Modifier
                    .padding(16.dp),
                color = WalletLigthTheme.colors.TitleScreenText,
                text = stringResource(id = R.string.my_cards)
            )
        }
    }
}

@Preview(name = "CardListScreen Ligth Mode", showBackground = true)
@Composable
fun TitleComponentPreview() {
    WalletLigthTheme {
        TitleComponent()
    }
}