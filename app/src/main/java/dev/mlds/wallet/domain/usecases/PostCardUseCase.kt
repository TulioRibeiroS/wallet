package dev.mlds.wallet.domain.usecases

import dev.mlds.wallet.data.mappers.toCardModel
import dev.mlds.wallet.data.models.Card
import dev.mlds.wallet.data.models.Result
import dev.mlds.wallet.domain.models.CardModel
import dev.mlds.wallet.domain.models.Resource
import dev.mlds.wallet.domain.repositories.CardRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class PostCardUseCase(private val repository: CardRepository) :
    SingleUseCase<CardModel, CardModel> {

    data class Params(
        val card: CardModel
    )

    override suspend fun execute(params: CardModel?): Flow<Resource<CardModel>> {
        return repository.postCards(
            Card(
                cvv = params?.cvv.orEmpty(),
                id = params?.id.orEmpty(),
                name = params?.name.orEmpty(),
                number = params?.number.orEmpty(),
                expirationDate = params?.validade.orEmpty(),
                cardType = params?.color?.name.orEmpty()
            )
        ).map { result ->
            when (result) {
                is Result.Success -> Resource.Success(result.data.toCardModel())
                is Result.Error -> Resource.Error(result.exception)
            }
        }
    }
}