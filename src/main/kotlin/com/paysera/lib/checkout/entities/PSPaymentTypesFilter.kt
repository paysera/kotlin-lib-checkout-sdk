package com.paysera.lib.checkout.entities

import com.paysera.lib.checkout.enums.PSPaymentGroupType

data class PSPaymentTypesFilter(
    val country: String?,
    val currency: String?,
    val group: PSPaymentGroupType?
)