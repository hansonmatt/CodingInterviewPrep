package com.matthanson.leetcode.algorithms;

public class ProductArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] products = new int[nums.length];

        products[1] = nums[0];

        if (nums.length == 2) {
            products[0] = nums[1];
            return products;
        }

        products[0] = 1;

        for (int n = 2; n < nums.length; ++n) {
            products[n] = products[n - 1] * nums[n - 1];
        }

        int product = nums[nums.length - 1];
        for (int n = nums.length - 2; n >= 0; --n) {
            products[n] *= product;
            product *= nums[n];
        }

        return products;
    }
}
