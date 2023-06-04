package dev.mlds.wallet.data.di

import android.util.Log
import dev.mlds.wallet.data.api.CardService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitConfig {
    private const val BASE_URL = "http://192.168.50.4:3000"
    private const val OK_HTTP = "Ok Http"

    private fun config() = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(createOkHttpClient())
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(CardService::class.java)

    val retrofitModule = module {
        single {
            config()
        }
    }

    private fun createOkHttpClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor {
            Log.e(OK_HTTP, it)
        }
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        return OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .addInterceptor { chain ->
                val newRequest = chain.request().newBuilder()
                    .addHeader("Content-Type", "application/json")
                    .addHeader("deviceplatform", "android")
                    .build()
                chain.proceed(newRequest)
            }
            .build()
    }
}