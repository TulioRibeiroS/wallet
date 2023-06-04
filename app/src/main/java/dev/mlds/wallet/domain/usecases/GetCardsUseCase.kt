package dev.mlds.wallet.domain.usecases

import dev.mlds.wallet.data.mappers.toCardsModel
import dev.mlds.wallet.data.models.Result
import dev.mlds.wallet.domain.models.CardsModel
import dev.mlds.wallet.domain.models.Resource
import dev.mlds.wallet.domain.repositories.CardRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetCardsUseCase(private val cardRepository: CardRepository) :
    SingleUseCase<CardsModel, GetCardsUseCase.Param> {
    class Param()

    override suspend fun execute(params: Param?): Flow<Resource<CardsModel>> {
        return cardRepository.getCards().map { result ->
            when (result) {
                is Result.Success -> Resource.Success(result.data.toCardsModel())
                is Result.Error -> Resource.Error(result.exception)
            }
        }
    }
}