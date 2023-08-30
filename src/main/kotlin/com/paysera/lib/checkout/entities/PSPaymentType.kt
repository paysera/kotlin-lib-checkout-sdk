package com.paysera.lib.checkout.entities

import org.joda.money.Money

data class PSPaymentType(
    val name: String,
    val key: String,
    val group: String,
    val groupDescription: String,
    val countries: List<String>,
    val currencies: List<String>,
    val minTransferAmount: Money?,
    val maxTransferAmount: Money?,
    val logoUrl: String,
    val creditingFee: PSCreditingFee?,
    val creditingTime: String?,
    val supportedCards: List<String>?
)