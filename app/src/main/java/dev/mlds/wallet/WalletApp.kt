package dev.mlds.wallet

import android.app.Application
import dev.mlds.wallet.data.di.RetrofitConfig
import dev.mlds.wallet.data.di.dataModule
import dev.mlds.wallet.domain.di.domainModule
import dev.mlds.wallet.ui.di.uiModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class WalletApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@WalletApp)
            modules(dataModule, RetrofitConfig.retrofitModule, domainModule, uiModule)
        }
    }
}