package com.paysera.lib.checkout.retrofit

import com.paysera.lib.checkout.entities.PSPaymentTypes
import com.paysera.lib.checkout.entities.PSPaymentUrl
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface NetworkApiClient {

    @GET("payment-types")
    fun getPaymentTypes(
        @Query("country") country: String,
        @Query("currency") currency: String
    ): Deferred<PSPaymentTypes>

    @GET("payment-url/{paymentTypeKey}")
    fun getPaymentUrl(
        @Path("paymentTypeKey") paymentTypeKey: String,
        @Query("amount") amount: String,
        @Query("currency") currency: String,
        @Query("account") account: String,
        @Query("email") email: String,
        @Query("lang") locale: String
    ): Deferred<PSPaymentUrl>
}