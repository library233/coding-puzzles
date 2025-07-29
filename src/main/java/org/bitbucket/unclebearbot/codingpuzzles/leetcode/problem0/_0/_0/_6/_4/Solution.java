package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._0._6._4;

/*

https://leetcode.com/problems/minimum-path-sum

64. Minimum Path Sum
(Medium)

Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

Example 1:

    (1)->(3)->(1)
               V
     1    5   (1)
               V
     4    2   (1)

Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
Output: 7
Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.

Example 2:

    (1)->(2)->(3)
               V
     4    5   (6)

Input: grid = [[1,2,3],[4,5,6]]
Output: 12

Constraints:

    m == grid.length
    n == grid[i].length
    1 <= m, n <= 200
    0 <= grid[i][j] <= 200

 */

class Solution {
    public int minPathSum(int[][] grid) {
        int lines = grid.length;
        int columns = grid[0].length;
        int[][] sums = new int[lines][columns];
        sums[0][0] = grid[0][0];
        for (int line = 0; line < lines; ++line) {
            for (int column = 0; column < columns; ++column) {
                int accumulated = getAccumulated(line, column, sums);
                int number = grid[line][column];
                sums[line][column] = accumulated + number;
            }
        }
        return sums[lines - 1][columns - 1];
    }

    private int getAccumulated(int line, int column, int[][] sums) {
        if (line > 0 && column > 0) {
            int fromTop = sums[line - 1][column];
            int fromLeft = sums[line][column - 1];
            return Math.min(fromTop, fromLeft);
        }
        if (line > 0) {
            return sums[line - 1][0];
        }
        if (column > 0) {
            return sums[0][column - 1];
        }
        return 0;
    }
}
