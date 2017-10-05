package com.matthanson.leetcode.algorithms;

public class PartitionList {

    static public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return head;
        }

        ListNode ltHead = null;
        ListNode ltTail = null;
        ListNode gtHead = null;
        ListNode gtTail = null;

        ListNode node = head;
        while (node != null) {
            if (node.val < x) {
                if (ltHead == null) {
                    ltHead = node;
                    ltTail = ltHead;
                } else {
                    ltTail.next = node;
                    ltTail = ltTail.next;
                }
            } else {
                if (gtHead == null) {
                    gtHead = node;
                    gtTail = gtHead;
                } else {
                    gtTail.next = node;
                    gtTail = gtTail.next;
                }
            }

            node = node.next;
        }

        if (gtTail != null) {
            gtTail.next = null;
        }

        if (ltHead != null) {
            ltTail.next = gtHead;
            return ltHead;
        }


        return head;
    }
}
