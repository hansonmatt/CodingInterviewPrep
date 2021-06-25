package com.matthanson.fb;

import java.util.LinkedList;
import java.util.List;

/*
Given N, representing the size of an NxN square grid,
I want you to return all the paths from the top left corner to the bottom right corner,
given that you can only move down or right in the grid.
The return value should be an array of strings.

N: size of the square grid

Example:
3 x 3 grid

  R
o -> o    o
|
v D
o    o    o
o    o    o

["RRDD", "RDRD", ... ]

List<String> paths(int[][] N) {
  int x = 0;
  int y = 0;
}

void path(int[][] N, int x, int y, char direction, String path) {
  path.append(direction);

  if (x == N[x].length - 1 && y == N[x][y].length) {
    List.add(path);
    return;
  }

  // boundary check
  if ((x + 1) < input
  path(N, x+1, y, path, "R");
  path(N, x, y + 1, path, "D")
}

 */
public class MatrixPaths {
    public List<String> paths(int[][] matrix) {
        List<String> paths = new LinkedList<>();
        if (matrix != null && matrix.length > 1) {
            path(matrix, 0, 0, "", paths);
        }

        return paths;
    }

    private void path(int[][] matrix, int x, int y, String path, List<String> paths) {
        if ((x == matrix.length - 1) && (y == matrix[matrix.length - 1].length - 1)) {
            paths.add(path);
            return;
        }

        if ((x + 1) < matrix.length) {
            path(matrix, x + 1, y, path.concat("R"), paths);
        }

        if ((y + 1) < matrix[x].length) {
            path(matrix, x, y + 1, path.concat("D"), paths);
        }

    }
}
