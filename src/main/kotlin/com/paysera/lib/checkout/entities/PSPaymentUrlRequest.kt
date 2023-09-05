package com.paysera.lib.checkout.entities

import org.joda.money.CurrencyUnit

data class PSPaymentUrlRequest(
    val paymentTypeKey: String,
    val amountInCents: String,
    val currencyUnit: CurrencyUnit,
    val evpAccountNumber: String,
    val email: String
)