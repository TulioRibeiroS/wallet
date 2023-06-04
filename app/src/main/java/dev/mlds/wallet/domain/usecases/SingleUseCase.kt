package dev.mlds.wallet.domain.usecases

import dev.mlds.wallet.domain.models.Resource
import kotlinx.coroutines.flow.Flow


interface SingleUseCase<R, P> {
    suspend fun execute(params: P? = null): Flow<Resource<R>>
}