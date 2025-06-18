package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem00200;

/*

https://leetcode.com/problems/number-of-islands

200. Number of Islands
(Medium)

Given an m x n 2D binary grid 'grid' which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1

Example 2:

Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3

Constraints:

    m == grid.length
    n == grid[i].length
    1 <= m, n <= 300
    grid[i][j] is '0' or '1'.

 */

class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int line = 0; line < grid.length; ++line) {
            for (int column = 0; column < grid[0].length; ++column) {
                if (!isRemoved(grid, line, column)) {
                    ++count;
                    remove(grid, line, column);
                }
            }
        }
        return count;
    }

    private void remove(char[][] grid, int line, int column) {
        if (!isAdjacent(grid, line, column)) {
            return;
        }
        setRemoved(grid, line, column);
        remove(grid, line - 1, column);
        remove(grid, line + 1, column);
        remove(grid, line, column - 1);
        remove(grid, line, column + 1);
    }

    private boolean isAdjacent(char[][] grid, int line, int column) {
        if (line < 0) {
            return false;
        }
        if (line >= grid.length) {
            return false;
        }
        if (column < 0) {
            return false;
        }
        if (column >= grid[0].length) {
            return false;
        }
        return !isRemoved(grid, line, column);
    }

    private boolean isRemoved(char[][] grid, int line, int column) {
        return grid[line][column] == '0';
    }

    private void setRemoved(char[][] grid, int line, int column) {
        grid[line][column] = '0';
    }
}
