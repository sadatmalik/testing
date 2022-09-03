package com.sadatmalik;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringUtilTest {

    @ParameterizedTest
    @CsvSource({"abcde, edcba", " , ", "sadat, tadas"})
    void testReverse(String string, String reversed) {
        String result = StringUtil.reverse(string);
        assertEquals(result, reversed);
    }
}