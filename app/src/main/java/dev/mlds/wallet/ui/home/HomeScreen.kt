package dev.mlds.wallet.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import dev.mlds.wallet.R
import dev.mlds.wallet.ui.components.PrimaryButton
import dev.mlds.wallet.ui.components.SecondButton
import dev.mlds.wallet.ui.theme.WalletLigthTheme

@Composable
fun HomeScreen(openList: () -> Unit = {}, openCreate: () -> Unit = {}) {
    WalletLigthTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(WalletLigthTheme.colors.background),
                contentAlignment = Alignment.Center
            ) {

                HomeBody(openList, openCreate)
            }
        }
    }
}

@Composable
private fun HomeBody(openList: () -> Unit, openCreate: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ProvideTextStyle(
            value = WalletLigthTheme.typography.title
        ) {
            Text(
                color = WalletLigthTheme.colors.text,
                text = stringResource(id = R.string.app_name)
            )
        }
        Spacer(Modifier.size(30.dp))
        PrimaryButton(
            modifier = Modifier.fillMaxWidth(),
            content = {
                Text(text = stringResource(id = R.string.primary_button))
            },
            onClick = { openList() }
        )
        Spacer(Modifier.size(20.dp))
        SecondButton(
            modifier = Modifier.fillMaxWidth(),
            content = {
                Text(text = stringResource(id = R.string.second_button))
            },
            onClick = { openCreate() }
        )
    }
}
