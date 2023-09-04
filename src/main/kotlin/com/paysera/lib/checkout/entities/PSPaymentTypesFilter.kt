package com.paysera.lib.checkout.entities

import com.paysera.lib.checkout.enums.PSPaymentTypeGroup

data class PSPaymentTypesFilter(
    val country: String?,
    val currency: String?,
    val group: PSPaymentTypeGroup?
)