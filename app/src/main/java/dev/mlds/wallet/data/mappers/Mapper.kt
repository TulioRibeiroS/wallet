package dev.mlds.wallet.data.mappers

import dev.mlds.wallet.data.models.Card
import dev.mlds.wallet.data.models.Cards
import dev.mlds.wallet.domain.models.CardModel
import dev.mlds.wallet.domain.models.CardsModel

fun Cards.toCardsModel(): CardsModel {
    return CardsModel(
        this.map {
            CardModel(
                id = it.id,
                number = it.number,
                cvv = it.cvv,
                name = it.name,
                validade = it.expirationDate,
                color = CardModel.CardType.stringToCardType(it.cardType)
            )
        }
    )
}

fun Card.toCardModel(): CardModel {
    return CardModel(
        id = this.id,
        number = this.number,
        cvv = this.cvv,
        name = this.name,
        validade = this.expirationDate,
        color = CardModel.CardType.stringToCardType(this.cardType)
    )
}