package com.matthanson.leetcode.algorithms;

/**
 * Created by matthans on 5/15/17.
 */
public class RemoveDuplicatesSortedList {
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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode n = head;
        while (n.next != null) {
            if (n.val == n.next.val) {
                n.next = n.next.next;
            } else {
                n = n.next;
            }
        }

        return head;
    }
}
