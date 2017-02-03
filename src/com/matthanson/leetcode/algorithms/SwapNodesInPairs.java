package com.matthanson.leetcode.algorithms;

/**
 * Created by matthans on 2/1/17.
 */
public class SwapNodesInPairs {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode newHead = head;
        ListNode p1 = head;
        ListNode p2 = head.next;
        ListNode p3 = null;

        while (p1 != null && p2 != null) {
            p1.next = p2.next;
            p2.next = p1;

            if (p3 == null) {
                newHead = p2;
                p3 = p1;
            } else {
                p3.next = p2;
                p3 = p1;
            }

            p1 = p1.next;
            if (p1 != null) p2 = p1.next;
        }

        return newHead;
    }
}
