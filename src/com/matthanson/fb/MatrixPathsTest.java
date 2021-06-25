package com.matthanson.fb;

import org.junit.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MatrixPathsTest {
    private MatrixPaths matrixPaths = new MatrixPaths();

    @Test
    public void paths() {
        assertTrue(matrixPaths.paths(new int[][]{}).isEmpty());
        assertTrue(matrixPaths.paths(new int[1][1]).isEmpty());

        List<String> paths = matrixPaths.paths(new int[][]{{0, 0}, {0, 0}});
        assertEquals(2, paths.size());
        assertTrue(paths.contains("DR"));
        assertTrue(paths.contains("RD"));

        paths = matrixPaths.paths(new int[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}});
        assertEquals(6, paths.size());
        assertTrue(paths.contains("DDRR"));
        assertTrue(paths.contains("DRDR"));
        assertTrue(paths.contains("DRRD"));
        assertTrue(paths.contains("RDDR"));
        assertTrue(paths.contains("RDRD"));
        assertTrue(paths.contains("RRDD"));
    }
}