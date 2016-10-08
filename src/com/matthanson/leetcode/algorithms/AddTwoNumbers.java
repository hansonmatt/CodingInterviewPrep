package com.matthanson.leetcode.algorithms;

import java.math.BigInteger;

/**
 * Created by matthans on 10/7/16.
 */
public class AddTwoNumbers {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        BigInteger bi = intFromList(l1);
        bi = bi.add(intFromList(l2));

        ListNode root = null;
        ListNode curr = null;
        while (!bi.equals(BigInteger.ZERO)) {
            int mod = bi.mod(BigInteger.TEN).intValue();
            bi = bi.divide(BigInteger.TEN);

            if (root == null) {
                root = new ListNode(mod);
                curr = root;
            } else {
                curr.next = new ListNode(mod);
                curr = curr.next;
            }
        }

        if (root == null) {
            root = new ListNode(0);
        }

        return root;
    }

    public BigInteger intFromList(ListNode head) {
        BigInteger bi = BigInteger.ZERO;

        ListNode node = head;
        int n = 0;
        while (node != null) {
            int multiplier = (int) Math.pow(10, n);
            bi = bi.add(BigInteger.valueOf(node.val * multiplier));
            node = node.next;
            n++;
        }

        return bi;
    }
}
