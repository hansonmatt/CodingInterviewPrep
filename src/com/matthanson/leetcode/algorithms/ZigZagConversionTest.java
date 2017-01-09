package com.matthanson.leetcode.algorithms;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by matthans on 1/9/17.
 */
public class ZigZagConversionTest {
    private ZigZagConversion zzc = new ZigZagConversion();

    @Test
    public void convertNullString() throws Exception {
        assertEquals("", zzc.convert(null, 4));
    }

    @Test
    public void convertEmptyString() throws Exception {
        assertEquals("", zzc.convert("", 4));
    }

    @Test
    public void convertSmallStrings() throws Exception {
        assertEquals("A", zzc.convert("A", 4));
        assertEquals("AB", zzc.convert("AB", 4));
        assertEquals("ABC", zzc.convert("ABC", 4));
        assertEquals("ABCD", zzc.convert("ABCD", 4));
    }

    @Test
    public void convertPAYPALISHIRING_InvalidRowNum() throws Exception {
        assertEquals("", zzc.convert("PAYPALISHIRING", 0));
    }

    @Test
    public void convertPAYPALISHIRING_InvalidRowNumv2() throws Exception {
        assertEquals("", zzc.convert("PAYPALISHIRING", -1));
    }

    @Test
    public void convertPAYPALISHIRING() throws Exception {
        assertEquals("PAHNAPLSIIGYIR", zzc.convert("PAYPALISHIRING", 3));
    }

    @Test
    public void convertPAYPALISHIRINGv2() throws Exception {
        assertEquals("PINALSIGYAHRPI", zzc.convert("PAYPALISHIRING", 4));
    }

    @Test
    public void convertPAYPALISHIRINGv3() throws Exception {
        assertEquals("PAYPALISHIRING", zzc.convert("PAYPALISHIRING", 1));
    }

}