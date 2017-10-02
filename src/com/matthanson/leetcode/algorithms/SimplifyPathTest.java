package com.matthanson.leetcode.algorithms;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class SimplifyPathTest {
    private SimplifyPath simplify = new SimplifyPath();

    @Test
    public void simplifyPath() {
        assertNull(simplify.simplifyPath(null));

        assertEquals("", simplify.simplifyPath(""));

        assertEquals("/", simplify.simplifyPath("/"));

        assertEquals("/home", simplify.simplifyPath("/home/"));

        assertEquals("/", simplify.simplifyPath("/home/../.././../../"));

        assertEquals("/c", simplify.simplifyPath("/a/./b/../../c/"));

        assertEquals("/home/foo", simplify.simplifyPath("/home//foo/"));

        assertEquals("/home/hansonsmatt/github/leetcode/simplify",
                simplify.simplifyPath("//.././home/hansonsmatt/github/./leetcode/algorithms/../simplify///./"));
    }

}