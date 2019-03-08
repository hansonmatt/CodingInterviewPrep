package com.matthanson.leetcode.algorithms;

import org.junit.Test;

import static org.junit.Assert.*;

public class BestTimeBuySellStockTest {
    BestTimeBuySellStock stock = new BestTimeBuySellStock();

    @Test
    public void maxProfit() {
        assertEquals(5, stock.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));

        assertEquals(52, stock.maxProfit(new int[]{50, 10, 3, 8, 40, 55}));

        assertEquals(0, stock.maxProfit(new int[]{7, 6, 4, 3, 1}));

        assertEquals(6, stock.maxProfit(new int[]{-7, -6, -4, -3, -1}));

        assertEquals(8, stock.maxProfit(new int[]{-7, -6, -4, -3, 1}));
    }

}