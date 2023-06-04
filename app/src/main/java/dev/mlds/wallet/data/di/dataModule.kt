package dev.mlds.wallet.data.di

import dev.mlds.wallet.data.repo.CardRepositoryImpl
import dev.mlds.wallet.domain.repositories.CardRepository
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataModule = module {
    single<CardRepository> { CardRepositoryImpl(androidContext(), get()) }
}
