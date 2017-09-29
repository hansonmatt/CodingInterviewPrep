package com.matthanson.leetcode.algorithms;

import org.junit.Test;

import static org.junit.Assert.*;

public class ValidParenthesesTest {
    private ValidParentheses valid = new ValidParentheses();

    @Test
    public void testValidParentheses() throws Exception {
        assertTrue(valid.isValid(null));
        assertTrue(valid.isValid(""));
        assertTrue(valid.isValid("()"));
        assertTrue(valid.isValid("()[]{}"));
        assertTrue(valid.isValid("{([])}"));
        assertTrue(valid.isValid("[{([()])}(){}]"));
        assertFalse(valid.isValid("[}"));
        assertFalse(valid.isValid("(]"));
        assertFalse(valid.isValid("([)]"));
        assertFalse(valid.isValid("[["));
        assertFalse(valid.isValid("[{([()])}(){}"));
        assertFalse(valid.isValid("[{([()])}({}]"));
    }
}