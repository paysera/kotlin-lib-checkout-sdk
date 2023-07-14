package com.paysera.lib.checkout.clients

import com.paysera.lib.checkout.entities.PSPaymentTypes
import com.paysera.lib.checkout.entities.PSPaymentUrl
import com.paysera.lib.checkout.entities.PSPaymentUrlRequest
import com.paysera.lib.checkout.retrofit.NetworkApiClient
import com.paysera.lib.common.retrofit.ApiRequestManager
import com.paysera.lib.common.retrofit.BaseApiClient
import kotlinx.coroutines.Deferred

class CheckoutApiClient(
    private val networkApiClient: NetworkApiClient,
    apiRequestManager: ApiRequestManager
) : BaseApiClient(apiRequestManager) {

    fun getPaymentTypes(country: String, currency: String): Deferred<PSPaymentTypes> {
        return networkApiClient.getPaymentTypes(country, currency)
    }

    fun getPaymentUrl(paymentUrlRequest: PSPaymentUrlRequest): Deferred<PSPaymentUrl> {
        return networkApiClient.getPaymentUrl(
            paymentTypeKey = paymentUrlRequest.paymentTypeKey,
            amount = paymentUrlRequest.amount,
            currency = paymentUrlRequest.currency,
            account = paymentUrlRequest.account,
            email = paymentUrlRequest.email,
            locale = paymentUrlRequest.locale
        )
    }
}