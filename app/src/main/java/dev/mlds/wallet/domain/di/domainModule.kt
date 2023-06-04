package dev.mlds.wallet.domain.di

import dev.mlds.wallet.domain.usecases.GetCardsUseCase
import dev.mlds.wallet.domain.usecases.PostCardUseCase
import org.koin.dsl.module

val domainModule = module {
    single { GetCardsUseCase(get()) }
    single { PostCardUseCase(get()) }
}