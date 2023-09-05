package com.paysera.lib.checkout.clients

import com.paysera.lib.checkout.entities.PSPaymentTypes
import com.paysera.lib.checkout.entities.PSPaymentTypesFilter
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

    fun getPaymentTypes(filter: PSPaymentTypesFilter): Deferred<PSPaymentTypes> {
        return networkApiClient.getPaymentTypes(
            filter.country,
            filter.currency,
            filter.group?.value
        )
    }

    fun getPaymentUrl(paymentUrlRequest: PSPaymentUrlRequest): Deferred<PSPaymentUrl> {
        return networkApiClient.getPaymentUrl(
            paymentTypeKey = paymentUrlRequest.paymentTypeKey,
            amountInCents = paymentUrlRequest.amountInCents,
            currencyUnit = paymentUrlRequest.currencyUnit.currencyCode,
            evpAccountNumber = paymentUrlRequest.evpAccountNumber,
            email = paymentUrlRequest.email
        )
    }
}