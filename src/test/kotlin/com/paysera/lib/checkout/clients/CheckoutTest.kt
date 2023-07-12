package com.paysera.lib.checkout.clients

import com.paysera.lib.checkout.runCatchingBlocking
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class CheckoutTest : BaseTest() {
    private val country = "lt"
    private val currency = "EUR"
    private val paymentTypeKey = "quipu"
    private val amount = "100" //cents
    private val email = ""
    private val accountEVP = ""

    @Test
    fun getPaymentTypes() {
        val response = apiClient.getPaymentTypes(country, currency).runCatchingBlocking()
        assert(response.isSuccess)
    }

    @Test
    fun getQuipuPaymentUrl() {
        val response = apiClient.getPaymentUrl(
            paymentTypeKey = paymentTypeKey,
            amount = amount,
            currency = currency,
            account = accountEVP,
            email = email,
            locale = "en"
        ).runCatchingBlocking()
        assert(response.isSuccess)
    }
}