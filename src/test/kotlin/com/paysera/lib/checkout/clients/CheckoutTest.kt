package com.paysera.lib.checkout.clients

import com.paysera.lib.checkout.entities.PSPaymentTypesFilter
import com.paysera.lib.checkout.entities.PSPaymentUrlRequest
import com.paysera.lib.checkout.enums.PSPaymentGroupType
import com.paysera.lib.checkout.runCatchingBlocking
import org.joda.money.CurrencyUnit
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class CheckoutTest : BaseTest() {

    private val paymentTypesFilter = PSPaymentTypesFilter(
        country = null,
        currency = null,
        group = PSPaymentGroupType.CreditCards
    )

    private val paymentUrlRequest = PSPaymentUrlRequest(
        paymentTypeKey = "quipu",
        amountInCents = "100",
        currencyUnit = CurrencyUnit.EUR,
        evpAccountNumber = "",
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