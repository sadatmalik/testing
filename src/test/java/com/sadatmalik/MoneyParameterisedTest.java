package com.sadatmalik;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author sm@creativefusion.net
 */
public class MoneyParameterisedTest {
    private static final Object[] getMoney() {
        return new Object[] {
                new Object[] {10, "USD"},
                new Object[] {20, "EUR"}
        };
    }

    @ParameterizedTest
    //@ValueSource(ints = {1, 3, 5, 15, Integer.MAX_VALUE})
    @CsvSource({"1,GBP", "20,USD", "50,SDK"})
    public void constructorShouldSetAmountAndCurrency(
            int amount, String currency) {
        Money money = new Money(amount, currency);
        assertEquals(amount, money.getAmount());
        assertEquals(currency, money.getCurrency());
    }
}