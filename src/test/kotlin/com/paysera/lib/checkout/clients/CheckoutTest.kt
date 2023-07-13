package com.paysera.lib.checkout.clients

import com.paysera.lib.checkout.entities.SPPaymentUrlRequest
import com.paysera.lib.checkout.runCatchingBlocking
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class CheckoutTest : BaseTest() {
    private val country = "lt"
    private val currency = "EUR"

    private val paymentUrlRequest = SPPaymentUrlRequest(
        paymentTypeKey = "quipu",
        amount = "100",//cents
        currency = currency,
        account = "", //evp-id
        email = "",
        locale = "en"
    )

    @Test
    fun getPaymentTypes() {
        val response = apiClient.getPaymentTypes(country, currency).runCatchingBlocking()
        assert(response.isSuccess)
    }

    @Test
    fun getQuipuPaymentUrl() {
        val response = apiClient.getPaymentUrl(paymentUrlRequest).runCatchingBlocking()
        assert(response.isSuccess)
    }
}