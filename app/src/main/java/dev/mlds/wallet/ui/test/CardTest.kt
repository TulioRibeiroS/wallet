package dev.mlds.wallet.ui.test

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import dev.mlds.wallet.R
import dev.mlds.wallet.domain.models.CardModel
import dev.mlds.wallet.domain.models.CardsModel
import dev.mlds.wallet.ui.theme.WalletLigthTheme

@Composable
fun CardItem(card: CardModel, index: Int) {
    var expanded by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { expanded = !expanded }
            .padding(16.dp)
            .offset { IntOffset(0, index * (150)) }
            .animateContentSize()
    ) {
        if (expanded) {
            Column(
                modifier = Modifier
                    .background(card.color?.background ?: WalletLigthTheme.cardColors.background)
                    .fillMaxWidth()
                    .padding(horizontal = 15.dp, vertical = 30.dp)
            ) {
                Text(text = card.color?.title.orEmpty())
                Spacer(modifier = Modifier.size(30.dp))
                Text(text = card.name)
                Text(text = card.number)
                Row {
                    Text(text = stringResource(id = R.string.doDate))
                    Spacer(modifier = Modifier.size(6.dp))
                    Text(text = card.validade.orEmpty())
                }
            }
        } else {
            Column(
                modifier = Modifier
                    .background(
                        card.color?.background
                            ?: WalletLigthTheme.cardColors.background
                    )
                    .fillMaxWidth()
                    .padding(horizontal = 15.dp, vertical = 30.dp)
            ) {
                Text(text = card.color?.title.orEmpty())
            }
        }
    }
}

@Composable
fun CardList(cardList: CardsModel) {
    var cards by remember { mutableStateOf(cardList.cards) }
    Box(modifier = Modifier.fillMaxSize()) {
        cards.forEachIndexed { index, card ->
            CardItem(card = card, index = index)
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .clickable { if (cards.isNotEmpty()) cards.drop(cards.lastIndex) }
        ) {
            Text(
                text = "Remove Last Card",
                textAlign = TextAlign.Center,
                modifier = Modifier.align(Alignment.BottomCenter)
            )
        }
    }
}

@Preview(name = "CardListPreview", showBackground = true)
@Composable
fun CardListPreview() {
    CardList(
        CardsModel(
            cards = listOf(
                CardModel(
                    id = "",
                    number = "**** **** **** 3727",
                    cvv = "1234",
                    name = "João Carlos Pereira",
                    validade = "06/29",
                    color = CardModel.CardType.GREEN
                ),
                CardModel(
                    id = "",
                    number = "**** **** **** 3727",
                    cvv = "1234",
                    name = "João Carlos Pereira",
                    validade = "06/29",
                    color = CardModel.CardType.BLACK
                )
            )
        )
    )
}