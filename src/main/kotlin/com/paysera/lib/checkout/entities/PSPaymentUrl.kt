package com.paysera.lib.checkout.entities

data class PSPaymentUrl(
    val paymentUrl: String,
    val acceptUrl: String,
    val cancelUrl: String,
)