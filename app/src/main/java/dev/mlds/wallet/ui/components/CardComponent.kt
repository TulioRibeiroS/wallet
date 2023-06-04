package dev.mlds.wallet.ui.components

import android.content.Context
import android.widget.Toast
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import dev.mlds.wallet.R
import dev.mlds.wallet.domain.models.CardModel
import dev.mlds.wallet.ui.theme.WalletLigthTheme

@Composable
fun CardComponent(
    context: Context = LocalContext.current,
    card: CardModel,
    index: Int = 0,
    isLastItem: Boolean = true,
    canUseItem: Boolean = false,
    onCLickItem: (CardModel) -> Unit
) {
    var expanded by remember { mutableStateOf(isLastItem) }
    var isSelect by remember { mutableStateOf(canUseItem) }

    if (expanded) {
        Column {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .offset { IntOffset(0, index * (-100)) }
                    .clickable {
                        isSelect = !isSelect
                        onCLickItem(card)
                    }
                    .animateContentSize(),
                shape = RoundedCornerShape(15.dp),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 5.dp
                )
            ) {
                CardOpened(card)
            }

            if (canUseItem) {
                Spacer(modifier = Modifier.height(50.dp))
                PrimaryButton(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = {
                        Toast.makeText(context, "Cartão selecionado", Toast.LENGTH_LONG)
                            .show()
                    },
                    content = {
                        Text(text = stringResource(id = R.string.use_this))
                    }
                )
                Spacer(modifier = Modifier.height(50.dp))
            }
        }
    } else {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .offset { IntOffset(0, index * (-95)) }
                .clickable {
                    isSelect = !isSelect
                    onCLickItem(card)
                }
                .animateContentSize(),
            shape = RoundedCornerShape(15.dp),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 5.dp
            )
        ) {
            CardClosed(card)
        }
    }
}

@Composable
private fun CardClosed(card: CardModel) {
    Column(
        modifier = Modifier
            .background(
                card.color?.background ?: WalletLigthTheme.cardColors.background
            )
            .height(100.dp)
            .fillMaxWidth()
            .padding(vertical = 30.dp, horizontal = 16.dp)
    ) {
        card.color?.let {
            Text(
                color = it.textColor,
                text = it.title
            )
        }
    }
}

@Composable
private fun CardOpened(c: CardModel) {
    Column(
        modifier = Modifier
            .background(c.color?.background ?: WalletLigthTheme.cardColors.background)
            .fillMaxWidth()
            .padding(horizontal = 15.dp, vertical = 30.dp)
    ) {
        c.color?.let { item ->
            Text(
                color = item.textColor,
                text = item.title
            )
            Spacer(modifier = Modifier.size(30.dp))
            Text(
                color = item.textColor,
                text = c.name
            )
            Text(
                color = item.textColor,
                text = c.number
            )
            Row {
                Text(
                    color = item.textColor,
                    text = stringResource(id = R.string.doDate)
                )
                Spacer(modifier = Modifier.size(6.dp))
                Text(
                    color = item.textColor,
                    text = c.validade.orEmpty()
                )
            }
        }
    }
}

@Preview(name = "Card", showBackground = true)
@Composable
fun CardComponentPreview() {
    WalletLigthTheme {
        CardComponent(
            card = CardModel(
                id = "",
                number = "**** **** **** 3727",
                cvv = "1234",
                name = "João Carlos Pereira",
                validade = "06/29",
                color = CardModel.CardType.GREEN
            ),
            onCLickItem = {}
        )
    }
}