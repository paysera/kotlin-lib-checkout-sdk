package com.paysera.lib.checkout.entities

data class PSPaymentUrlRequest(
    val paymentTypeKey: String,
    val amountInCents: String,
    val currency: String,
    val evpAccountNumber: String,
    val email: String
)