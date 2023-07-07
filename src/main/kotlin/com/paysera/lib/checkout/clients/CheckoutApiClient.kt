package com.paysera.lib.checkout.clients

import com.paysera.lib.checkout.entities.PaymentTypeResponse
import com.paysera.lib.checkout.entities.PaymentUrl
import com.paysera.lib.checkout.retrofit.NetworkApiClient
import com.paysera.lib.common.retrofit.ApiRequestManager
import com.paysera.lib.common.retrofit.BaseApiClient
import kotlinx.coroutines.Deferred

class CheckoutApiClient(
    private val networkApiClient: NetworkApiClient,
    apiRequestManager: ApiRequestManager
) : BaseApiClient(apiRequestManager) {

    fun getPaymentTypes(country: String, currency: String): Deferred<PaymentTypeResponse> {
        return networkApiClient.getPaymentTypes(country, currency)
    }

    fun getPaymentUrl(
        paymentTypeId: String,
        amount: String,
        currency: String,
        account: String,
        email: String,
        lang: String
    ): Deferred<PaymentUrl> {
        return networkApiClient.getPaymentUrl(
            paymentTypeId = paymentTypeId,
            amount = amount,
            currency = currency,
            account = account,
            email = email,
            lang = lang
        )
    }
}