package com.paysera.lib.checkout.entities

enum class PSPaymentTypeGroup(val value: String) {
    EBanking("e-banking"),
    EMoney("e-money"),
    CreditCards("credit-cards"),
    Other("other")
}