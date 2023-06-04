package dev.mlds.wallet.ui.list

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.mlds.wallet.R
import dev.mlds.wallet.domain.models.CardModel
import dev.mlds.wallet.domain.models.CardsModel
import dev.mlds.wallet.domain.models.Resource
import dev.mlds.wallet.ui.components.CardComponent
import dev.mlds.wallet.ui.components.ThirdButton
import dev.mlds.wallet.ui.components.TitleComponent
import dev.mlds.wallet.ui.components.ToolbarWallet
import dev.mlds.wallet.ui.theme.WalletLigthTheme
import org.koin.androidx.compose.koinViewModel

private const val FIRST_POSITION = 0

@Composable
fun CardListScreen(
    backClick: () -> Unit = {},
    createClick: () -> Unit = {},
    viewModel: CardListViewModel = koinViewModel()
) {
    val context = LocalContext.current
    val cards = viewModel.cards.observeAsState()
    viewModel.getAllCards()

    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            Modifier
                .fillMaxSize()
                .background(WalletLigthTheme.colors.background)
        ) {
            ToolbarWallet(primaryIconClick = backClick, secondIconClick = createClick)
            TitleComponent()
            Body(cards, context)
        }
    }
}

@Composable
private fun Body(
    data: State<Resource<CardsModel>?>,
    context: Context
) {
    data.value?.let { state ->
        when (state) {
            is Resource.Success -> {
                CardList(state.data, context)
            }

            is Resource.HttpError -> {
                Toast.makeText(
                    context,
                    stringResource(id = R.string.request_error),
                    Toast.LENGTH_LONG
                ).show()
            }

            else -> Unit
        }
    }
}

@Composable
private fun CardList(cardsModel: CardsModel, context: Context) {
    var cards by remember { mutableStateOf(cardsModel.cards) }
    var canUseItem by remember { mutableStateOf(false) }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        itemsIndexed(cards) { index, card ->
            CardComponent(
                context = context,
                card = card,
                index = index,
                isLastItem = cards.lastIndex == index,
                canUseItem = canUseItem
            ) {
                canUseItem = false
                moveSelectedCardToLastPosition(cards.toMutableList(), card) {
                    cards = it
                }
            }
        }
        if (!canUseItem) {
            item {
                ThirdButton(
                    onClick = {
                        canUseItem = true
                    }) {
                    Text(text = stringResource(id = R.string.use_this))
                }
            }
        }
    }
}

private fun moveSelectedCardToLastPosition(
    cardList: MutableList<CardModel>,
    selectedCard: CardModel,
    onResult: (MutableList<CardModel>) -> Unit
) {
    val index = cardList.indexOf(selectedCard)
    if (index != -1) {
        cardList.removeAt(index)
        cardList.add(selectedCard)
    }
    onResult(cardList)
}

private fun moveSelectedCardToFirstPosition(
    cardList: MutableList<CardModel>,
    selectedCard: CardModel,
    onResult: (MutableList<CardModel>) -> Unit
) {
    val index = cardList.indexOf(selectedCard)
    if (index != -1) {
        cardList.removeAt(index)
        cardList.add(FIRST_POSITION, selectedCard)
    }
    onResult(cardList)
}

@Preview(name = "CardListScreen Ligth Mode", showBackground = true)
@Composable
fun CardListScreenPreview() {
    WalletLigthTheme {
        CardListScreen()
    }
}