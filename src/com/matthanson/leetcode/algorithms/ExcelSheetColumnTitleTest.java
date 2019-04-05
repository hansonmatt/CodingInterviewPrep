package com.matthanson.leetcode.algorithms;

import org.junit.Test;

import static org.junit.Assert.*;

public class ExcelSheetColumnTitleTest {
    private ExcelSheetColumnTitle excelSheetColumnTitle = new ExcelSheetColumnTitle();

    @Test
    public void convertToTitle() {
        assertEquals("A", excelSheetColumnTitle.convertToTitle(1));
        assertEquals("Z", excelSheetColumnTitle.convertToTitle(26));
        assertEquals("AZ", excelSheetColumnTitle.convertToTitle(52));
        assertEquals("CV", excelSheetColumnTitle.convertToTitle(100));
        assertEquals("AZZ", excelSheetColumnTitle.convertToTitle(1378));
        assertEquals("CBIGYQJ", excelSheetColumnTitle.convertToTitle(954763248));
        assertEquals("KZKCV", excelSheetColumnTitle.convertToTitle(5491248));
    }

    @Test(expected = IllegalArgumentException.class)
    public void convertToTitleIllegalArgument() {
        excelSheetColumnTitle.convertToTitle(0);
    }
}