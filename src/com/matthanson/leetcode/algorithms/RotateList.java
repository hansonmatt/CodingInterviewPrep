package com.matthanson.leetcode.algorithms;

/**
 * Created by matthans on 5/17/17.
 */
public class RotateList {
    static public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        int len = 0;

        ListNode node = head;
        while (node != null) {
            node = node.next;
            ++len;
        }

        k %= len;

        if (k == 0) {
            return head;
        }

        node = head;
        ListNode rotate = head;
        ListNode newTail = head;

        while (node != null) {
            rotate = node;
            node = node.next;

            if (k < 0) {
                newTail = newTail.next;
            }

            --k;
        }

        rotate.next = head;
        head = newTail.next;
        newTail.next = null;

        return head;
    }
}
