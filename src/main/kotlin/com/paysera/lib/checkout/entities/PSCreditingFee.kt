package com.paysera.lib.checkout.entities

import org.joda.money.Money

data class PSCreditingFee(
    val type: String,
    val percentage: String,
    val minimumAmount: Money?,
    val maximumAmount: Money?
)