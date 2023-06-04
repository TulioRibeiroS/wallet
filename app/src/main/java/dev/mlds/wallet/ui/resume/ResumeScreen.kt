package dev.mlds.wallet.ui.resume

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.mlds.wallet.R
import dev.mlds.wallet.domain.models.CardModel
import dev.mlds.wallet.ui.components.CardComponent
import dev.mlds.wallet.ui.components.PrimaryButton
import dev.mlds.wallet.ui.components.ToolbarTransparentWallet
import dev.mlds.wallet.ui.theme.WalletLigthTheme

@Composable
fun ResumeScreen(
    card: CardModel? = null,
    backClick: () -> Unit = {},
    nextPage: () -> Unit = {}
) {
    Surface(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(WalletLigthTheme.colors.background)
        ) {
            Image(
                painter = painterResource(R.drawable.background),
                contentDescription = null,
                modifier = Modifier.fillMaxSize()
            )

            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                ToolbarTransparentWallet(
                    primaryIconClick = backClick
                )
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 24.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    ProvideTextStyle(
                        value = WalletLigthTheme.typography.title
                    ) {
                        Text(
                            text = stringResource(id = R.string.app_name)
                        )
                    }
                    Spacer(modifier = Modifier.size(10.dp))
                    ProvideTextStyle(
                        value = WalletLigthTheme.typography.subTitle
                    ) {
                        Text(
                            color = WalletLigthTheme.colors.text,
                            text = stringResource(id = R.string.create_sucess)
                        )
                    }
                    Spacer(modifier = Modifier.size(30.dp))
                    card?.let {
                        CardComponent(
                            card = CardModel(
                                id = it.id,
                                number = it.number,
                                cvv = it.cvv,
                                name = it.name,
                                validade = it.validade,
                                color = it.color
                            ),
                            onCLickItem = {}
                        )
                    }
                    Spacer(modifier = Modifier.size(22.dp))
                    PrimaryButton(
                        modifier = Modifier.fillMaxWidth(),
                        onClick = {
                            nextPage()
                        },
                        content = {
                            Text(text = stringResource(id = R.string.next_button))
                        }
                    )
                }
            }
        }
    }
}

@Preview(name = "ResumeScreenPreview", showBackground = true)
@Composable
fun ResumeScreenPreview() {
    WalletLigthTheme {
        ResumeScreen()
    }
}