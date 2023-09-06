package com.paysera.lib.checkout.enums

enum class PSPaymentGroupType(val value: String) {
    EBanking("e-banking"),
    EMoney("e-money"),
    CreditCards("credit-cards"),
    Other("other")
}