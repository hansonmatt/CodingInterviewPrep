package com.matthanson.leetcode.algorithms;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class TriangleTest {
    private Triangle t = new Triangle();

    @Test
    public void minimumTotal() {

        assertEquals(0, t.minimumTotal(null));

        Integer[][] tri = new Integer[][]{
        };
        assertEquals(0, t.minimumTotal(toTriangle(tri)));

        assertEquals(2, t.minimumTotal(toTriangle(new Integer[][]{
                {2}
        })));

        // [[2],[3,4],[6,5,7],[4,1,8,3]]
        tri = new Integer[][]{
                {2},
                {3, 4},
                {6, 5, 7},
                {4, 1, 8, 3}
        };
        assertEquals(11, t.minimumTotal(toTriangle(tri)));

        assertEquals(0, t.minimumTotal(toTriangle(new Integer[][]{
                {0},
                {0, 400},
                {0, 500, 0},
                {0, 0, 0, 2}
        })));

        assertEquals(2, t.minimumTotal(toTriangle(new Integer[][]{
                {2},
                {3, 4},
                {6, 5, 7},
                {4, 1, -8, 3}
        })));

        assertEquals(-3, t.minimumTotal(toTriangle(new Integer[][]{
                {2},
                {3, 4},
                {6, 5, 7},
                {-14, 1, -8, 3}
        })));
    }

    private List<List<Integer>> toTriangle(Integer[][] tri) {
        List<List<Integer>> triangle = new LinkedList<>();
        for (int n = 0; n < tri.length; ++n) {
            triangle.add(Arrays.asList(tri[n]));
        }
        return triangle;
    }
}