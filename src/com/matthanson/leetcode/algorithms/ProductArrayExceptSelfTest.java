package com.matthanson.leetcode.algorithms;

import org.junit.Test;

import static org.junit.Assert.*;

public class ProductArrayExceptSelfTest {
    private ProductArrayExceptSelf product = new ProductArrayExceptSelf();

    @Test
    public void productExceptSelf() {
        assertArrayEquals(new int[]{20, 8}, product.productExceptSelf(new int[]{8, 20}));

        int[] nums = new int[]{5, 3, 7};
        assertArrayEquals(new int[]{21, 35, 15}, product.productExceptSelf(nums));

        nums = new int[]{1, 2, 3, 4};
        int[] productsExceptSelf = product.productExceptSelf(nums);
        assertArrayEquals(new int[]{24, 12, 8, 6}, productsExceptSelf);

        nums = new int[]{2, 6, 8, 5, 0, 3, 7};
        productsExceptSelf = product.productExceptSelf(nums);
        assertArrayEquals(new int[]{0, 0, 0, 0, 10080, 0, 0}, productsExceptSelf);

        nums = new int[]{2, 6, 8, 5, 0, 3, 7, 5, 10, 15, 0, 99, 100};
        productsExceptSelf = product.productExceptSelf(nums);
        assertArrayEquals(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, productsExceptSelf);

        nums = new int[]{15, 6, 3, -2, 10, 25};
        int products[] = getProducts(nums);
        assertArrayEquals(products, product.productExceptSelf(nums));

        nums = new int[]{15, -1, 6, 3, -2, 10, 25};
        products = getProducts(nums);
        assertArrayEquals(products, product.productExceptSelf(nums));

        nums = new int[]{15, 6, 3, 8, 12, 18, 1, 4, 4, 2, 10, 7};
        products = getProducts(nums);
        assertArrayEquals(products, product.productExceptSelf(nums));
    }

    private int[] getProducts(int[] nums) {
        int[] products = new int[nums.length];

        int product = 1;
        for (int n = 0; n < nums.length; ++n) {
            product *= nums[n];
        }

        for (int n = 0; n < nums.length; ++n) {
            products[n] = product / nums[n];
        }

        return products;
    }
}