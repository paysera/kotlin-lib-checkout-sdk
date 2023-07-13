package com.paysera.lib.checkout.entities

data class SPPaymentUrlRequest(
    val paymentTypeKey: String,
    val amount: String,
    val currency: String,
    val account: String,
    val email: String,
    val locale: String
)