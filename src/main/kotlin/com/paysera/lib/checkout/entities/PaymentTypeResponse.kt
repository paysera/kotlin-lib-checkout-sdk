package com.paysera.lib.checkout.entities

import org.joda.money.Money

data class PaymentTypeResponse(val items: List<PaymentType>) {
    data class PaymentType(
        val name: String,
        val key: String,
        val countries: List<String>,
        val currencies: List<String>,
        val minTransferAmount: Money,
        val maxTransferAmount: Money
    )
}