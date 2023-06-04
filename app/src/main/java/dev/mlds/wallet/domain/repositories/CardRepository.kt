package dev.mlds.wallet.domain.repositories

import dev.mlds.wallet.data.models.Card
import dev.mlds.wallet.data.models.Cards
import dev.mlds.wallet.data.models.Result
import kotlinx.coroutines.flow.Flow

interface CardRepository {
    suspend fun getCards(): Flow<Result<Cards>>
    suspend fun postCards(card: Card): Flow<Result<Card>>
}