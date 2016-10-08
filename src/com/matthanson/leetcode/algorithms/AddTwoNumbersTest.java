package com.matthanson.leetcode.algorithms;

import com.matthanson.datastructures.bst.BinarySearchTree;
import org.junit.Test;

import java.math.BigInteger;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by matthans on 10/7/16.
 */
public class AddTwoNumbersTest {
    @Test
    public void addTwoNumbers() throws Exception {
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();

        AddTwoNumbers.ListNode n1 = new AddTwoNumbers.ListNode(5);
        AddTwoNumbers.ListNode n2 = new AddTwoNumbers.ListNode(2);

        AddTwoNumbers.ListNode n3 = addTwoNumbers.addTwoNumbers(null, null);
        assertNotNull(n3);
        assertEquals(0, n3.val);
        assertNull(n3.next);

        n3 = addTwoNumbers.addTwoNumbers(n1, n2);
        assertNotNull(n3);
        assertEquals(7, n3.val);

        n1.next = new AddTwoNumbers.ListNode(8); // n1 = (5,8) -> 85
        n2.next = new AddTwoNumbers.ListNode(4); // n2 = (2,4) -> 42
        n3 = addTwoNumbers.addTwoNumbers(n1, n2); // n3 = 85 + 42 = 127 -> (7,2,1);
        assertEquals(7, n3.val);
        assertEquals(2, n3.next.val);
        assertEquals(1, n3.next.next.val);

        n1.next.next = new AddTwoNumbers.ListNode(7); // n1 = (5,8,7) -> 785
        n2.next.next = new AddTwoNumbers.ListNode(6); // n2 = (2,4,6) -> 642
        n3 = addTwoNumbers.addTwoNumbers(n1, n2); // n3 = 785 + 642 = 1427 -> (7,2,4,1);
        assertEquals(7, n3.val);
        assertEquals(2, n3.next.val);
        assertEquals(4, n3.next.next.val);
        assertEquals(1, n3.next.next.next.val);
    }

    @Test
    public void testIntFromList() {
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        assertEquals(BigInteger.ZERO, addTwoNumbers.intFromList(null));
        assertEquals(BigInteger.ZERO, addTwoNumbers.intFromList(new AddTwoNumbers.ListNode(0)));
        assertEquals(BigInteger.ONE, addTwoNumbers.intFromList(new AddTwoNumbers.ListNode(1)));
        AddTwoNumbers.ListNode node = new AddTwoNumbers.ListNode(6);
        node.next = new AddTwoNumbers.ListNode(3);
        assertEquals(36, addTwoNumbers.intFromList(node).intValue());
    }

}