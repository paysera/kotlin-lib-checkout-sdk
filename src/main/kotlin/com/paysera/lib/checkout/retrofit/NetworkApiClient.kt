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
        @Query("country") country: String?,
        @Query("currency") currency: String?,
        @Query("group") group: String?
    ): Deferred<PSPaymentTypes>

    @GET("payment-url/{paymentTypeKey}")
    fun getPaymentUrl(
        @Path("paymentTypeKey") paymentTypeKey: String,
        @Query("amount") amountInCents: String,
        @Query("currency") currencyUnit: String,
        @Query("account") evpAccountNumber: String,
        @Query("email") email: String
    ): Deferred<PSPaymentUrl>
}