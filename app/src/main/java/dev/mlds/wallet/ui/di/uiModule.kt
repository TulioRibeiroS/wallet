package dev.mlds.wallet.ui.di

import dev.mlds.wallet.ui.create.CreateCardViewModel
import dev.mlds.wallet.ui.list.CardListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val uiModule = module {
    viewModel {
        CardListViewModel(get())
    }

    viewModel {
        CreateCardViewModel(get())
    }
}