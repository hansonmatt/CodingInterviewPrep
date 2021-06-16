package com.matthanson.ctci;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SortStackTest {
    private SortStack sortStack = new SortStack();

    @Test
    public void testSortStack() {
        sortStack.push(4);
        sortStack.push(9);
        sortStack.push(2);
        sortStack.push(6);
        sortStack.push(1);
        sortStack.push(8);
        sortStack.push(12);
        assertEquals(1, sortStack.peek());
        assertEquals(1, sortStack.pop());
        assertFalse(sortStack.isEmpty());
        assertEquals(2, sortStack.peek());
        assertEquals(2, sortStack.pop());
        assertFalse(sortStack.isEmpty());
        assertEquals(4, sortStack.peek());
        assertEquals(4, sortStack.pop());
        assertFalse(sortStack.isEmpty());
        assertEquals(6, sortStack.peek());
        assertEquals(6, sortStack.pop());
        assertFalse(sortStack.isEmpty());
        assertEquals(8, sortStack.peek());
        assertEquals(8, sortStack.pop());
        assertFalse(sortStack.isEmpty());
        assertEquals(9, sortStack.peek());
        assertEquals(9, sortStack.pop());
        assertFalse(sortStack.isEmpty());
        assertEquals(12, sortStack.peek());
        assertEquals(12, sortStack.pop());
        assertTrue(sortStack.isEmpty());
    }
}