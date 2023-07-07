package com.paysera.lib.checkout.retrofit

import com.paysera.lib.checkout.entities.PaymentTypeResponse
import com.paysera.lib.checkout.entities.PaymentUrl
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface NetworkApiClient {

    @GET("payment-types")
    fun getPaymentTypes(
        @Query("country") country: String,
        @Query("currency") currency: String
    ): Deferred<PaymentTypeResponse>

    @GET("payment-url/{paymentTypeId}")
    fun getPaymentUrl(
        @Path("paymentTypeId") paymentTypeId: String,
        @Query("amount") amount: String,
        @Query("currency") currency: String,
        @Query("account") account: String,
        @Query("email") email: String,
        @Query("lang") lang: String
    ): Deferred<PaymentUrl>
}