package com.themayfields.mike.prestoqcodingchallenge.Model.DomainModel

import java.math.BigDecimal

/**
 * Domain currency should be in a standardized format, rather than assuming dollars/cents. That allows extension to
 * support multiple currencies with little change impact.
 */
class Money (
    val usd: String  //Input value as US Dollars
) {
    private val amount: String = usd;  //Fake value for example. In reality this would typically be a BigDecimal

    /**
     * Get the amount formatted in the user's selected currency
     */
    fun toLocalCurrency() : String {
        return "$$amount";  //Fake implementation of currency support for example
    }
}