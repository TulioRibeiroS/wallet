package dev.mlds.wallet.data.api

import dev.mlds.wallet.data.models.Card
import dev.mlds.wallet.data.models.Cards
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface CardService {
    @GET("/cards")
    suspend fun getCards(): Response<Cards>

    @GET("/cards/{id}")
    suspend fun getCard(@Path("id") cardId: String): Response<Cards>

    @POST("/cards")
    suspend fun postCard(@Body card: Card): Response<Card>
}