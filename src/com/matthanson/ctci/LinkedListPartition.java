package com.matthanson.ctci;

public class LinkedListPartition {
    // Definition for a binary tree node.
    public static class ListNode {
        int val;
        ListNode next;
        ListNode previous;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode partition(ListNode head, ListNode tail, int listLength, int partition) {
        if (head == null || tail == null) {
            throw new IllegalArgumentException("List nodes cannot be null");
        }

        int leftIdx = 0;
        int rightIdx = listLength - 1;
        ListNode left = head;
        ListNode right = tail;
        while (leftIdx < rightIdx) {
            while (left != null && left.val < partition) {
                left = left.next;
                ++leftIdx;
            }

            while (right != null && right.val >= partition) {
                right = right.previous;
                --rightIdx;
            }

            if (leftIdx < rightIdx) {
                int swap = left.val;
                left.val = right.val;
                right.val = swap;
            }

            ++leftIdx;
            --rightIdx;
            if (left != null) {
                left = left.next;
            }
            if (right != null) {
                right = right.previous;
            }
        }

        return head;
    }
}
