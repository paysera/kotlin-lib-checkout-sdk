package com.paysera.lib.checkout.entities

import org.joda.money.Money

data class PSPaymentType(
    val name: String,
    val key: String,
    val countries: List<String>,
    val currencies: List<String>,
    val minTransferAmount: Money,
    val maxTransferAmount: Money
)