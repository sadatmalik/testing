package com.sadatmalik;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;

import java.util.HashMap;
import java.util.HashSet;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author sm@creativefusion.net
 */
public class HashMapTest {
    private HashMap<String, Object> map;
    private static final String KEY = "key";
    private static final Object OBJECT = new Object();

    @BeforeEach
    void setUp() {
        map = new HashMap<>();
    }

    private static Stream<Object> objectProvider() {
        return Stream.of("a string", 1, new HashSet<>());
    }

    @ParameterizedTest
    @MethodSource("objectProvider")
    void testPut(Object object) {
        map.put(KEY, object);
        assertEquals(map.get(KEY), object);
    }

    @ParameterizedTest
    @MethodSource("objectProvider")
    void testPutWithSameKey(Object object) {
        map.put(KEY, object);
        assertEquals(map.get(KEY), object);
        map.put(KEY, OBJECT);
        assertEquals(map.get(KEY), OBJECT);
    }

    @Test
    void testClear() {
        objectProvider()
                .forEach(object ->
                        map.put(String.valueOf(object.hashCode()), object));
        int count = (int) objectProvider().count();
        assertEquals(map.size(), count);
        map.clear();
        assertTrue(map.isEmpty());
    }

    @ParameterizedTest
    @NullSource
    void testNullKey(String nullString) {
        map.put(nullString, OBJECT);
        assertEquals(map.get(nullString), OBJECT);
    }

}
