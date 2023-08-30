package com.paysera.lib.checkout.clients

import com.paysera.lib.checkout.entities.PSPaymentTypesFilter
import com.paysera.lib.checkout.entities.PSPaymentUrlRequest
import com.paysera.lib.checkout.runCatchingBlocking
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class CheckoutTest : BaseTest() {

    private val paymentTypesFilter = PSPaymentTypesFilter(
        country = null,
        currency = null,
        group = "credit-cards"
    )

    private val paymentUrlRequest = PSPaymentUrlRequest(
        paymentTypeKey = "quipu",
        amount = "100",//cents
        currency = "EUR",
        account = "", //evp-id
        email = ""
    )

    @Test
    fun getPaymentTypes() {
        val response = apiClient.getPaymentTypes(paymentTypesFilter).runCatchingBlocking()
        assert(response.isSuccess)
    }

    @Test
    fun getQuipuPaymentUrl() {
        val response = apiClient.getPaymentUrl(paymentUrlRequest).runCatchingBlocking()
        assert(response.isSuccess)
    }
}