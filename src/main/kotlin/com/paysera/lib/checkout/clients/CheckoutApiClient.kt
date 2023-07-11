package com.paysera.lib.checkout.clients

import com.paysera.lib.checkout.entities.PSPaymentTypes
import com.paysera.lib.checkout.entities.PaymentUrl
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

    fun getPaymentUrl(
        paymentTypeKey: String,
        amount: String,
        currency: String,
        account: String,
        email: String,
        locale: String
    ): Deferred<PaymentUrl> {
        return networkApiClient.getPaymentUrl(
            paymentTypeKey = paymentTypeKey,
            amount = amount,
            currency = currency,
            account = account,
            email = email,
            locale = locale
        )
    }
}