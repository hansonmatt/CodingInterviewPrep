package com.matthanson.leetcode.algorithms;

import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.*;

/*
    Given two non-negative integers num1 and num2 represented as strings,
    return the product of num1 and num2, also represented as a string.
 */
public class MultiplyStringsTest {
    private MultiplyStrings multiplyStrings = new MultiplyStrings();

    @Test
    public void add() {
        assertEquals("2", MultiplyStrings.add("1","1"));
        assertEquals("", MultiplyStrings.add("",""));
        assertEquals("1234", MultiplyStrings.add("","1234"));
        assertEquals("2468", MultiplyStrings.add("1234","1234"));
        assertEquals("8088", MultiplyStrings.add("6888","1200"));
        assertEquals("12221", MultiplyStrings.add("5555","6666"));
        assertEquals("19998", MultiplyStrings.add("9999","9999"));
    }

    @Test
    public void multiply() {

        assertEquals("0", multiplyStrings.multiply(null, null));
        assertEquals("0", multiplyStrings.multiply("", null));
        assertEquals("0", multiplyStrings.multiply("", ""));
        assertEquals("0", multiplyStrings.multiply(null, ""));
        assertEquals("0", multiplyStrings.multiply(null, "123"));

        assertEquals("000", multiplyStrings.multiply("0", "123"));

        assertEquals("000000000000999456", multiplyStrings.multiply("999456", "0000000000001"));
        assertEquals("999456", multiplyStrings.multiply("999456", "1"));

        assertEquals("1", multiplyStrings.multiply("1", "1"));
        assertEquals("6", multiplyStrings.multiply("2", "3"));

        assertEquals("56088", multiplyStrings.multiply("123", "456"));

        BigInteger bi1 = BigInteger.valueOf(123456);
        BigInteger bi2 = BigInteger.valueOf(987654);
        assertEquals(bi1.multiply(bi2).toString(), multiplyStrings.multiply(bi1.toString(), bi2.toString()));

        bi1 = BigInteger.valueOf(8739);
        bi2 = BigInteger.valueOf(98411548651L);
        assertEquals(bi1.multiply(bi2).toString(), multiplyStrings.multiply(bi1.toString(), bi2.toString()));

        bi1 = BigInteger.valueOf(6987125);
        bi2 = BigInteger.valueOf(984154726941548651L);
        assertEquals(bi1.multiply(bi2).toString(), multiplyStrings.multiply(bi1.toString(), bi2.toString()));
    }
}