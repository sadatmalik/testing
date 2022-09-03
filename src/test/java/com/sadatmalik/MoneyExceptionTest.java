package com.sadatmalik;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author sm@creativefusion.net
 */
public class MoneyExceptionTest {

    private final static int VALID_AMOUNT = 5;
    private final static String VALID_CURRENCY = "USD";


    @ParameterizedTest
    @ValueSource(ints = {-1, -205, -32})
    public void constructorShouldThrowIAEForInvalidAmount(int invalidAmount) {
        IllegalArgumentException thrown =
                assertThrows(IllegalArgumentException.class, () -> {
            new Money(invalidAmount, VALID_CURRENCY);
        });

        Assertions.assertEquals("illegal amount: ["
                + invalidAmount + "]", thrown.getMessage());
    }

    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {""})
    public void constructorShouldThrowIAEForInvalidCurrency(String invalidCurrency) {
        IllegalArgumentException thrown =
                assertThrows(IllegalArgumentException.class, () -> {
                    new Money(VALID_AMOUNT, invalidCurrency);
                });
        Assertions.assertEquals("illegal currency: ["
                + invalidCurrency + "]", thrown.getMessage());
    }
}
