package com.paysera.lib.checkout.enums

enum class PSPaymentTypeGroup(val value: String) {
    EBanking("e-banking"),
    EMoney("e-money"),
    CreditCards("credit-cards"),
    Other("other")
}