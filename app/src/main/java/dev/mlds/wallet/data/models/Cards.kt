package dev.mlds.wallet.data.models

import com.google.gson.annotations.SerializedName

class Cards : ArrayList<Card>()

data class Card(
    @SerializedName("cvv")
    val cvv: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("number")
    val number: String,
    @SerializedName("expirationDate")
    val expirationDate: String,
    @SerializedName("cardType")
    val cardType: String
)

