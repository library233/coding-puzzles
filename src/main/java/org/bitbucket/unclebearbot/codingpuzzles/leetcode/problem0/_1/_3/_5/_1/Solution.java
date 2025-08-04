package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._1._3._5._1;

/*

https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix

1351. Count Negative Numbers in a Sorted Matrix
(Easy)

Given a m x n matrix grid which is sorted in non-increasing order both row-wise and column-wise, return the number of negative numbers in grid.

Example 1:

Input: grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
Output: 8
Explanation: There are 8 negatives number in the matrix.

Example 2:

Input: grid = [[3,2],[1,0]]
Output: 0

Constraints:

    m == grid.length
    n == grid[i].length
    1 <= m, n <= 100
    -100 <= grid[i][j] <= 100

Follow up: Could you find an O(n + m) solution?

 */

class Solution {
    public int countNegatives(int[][] grid) {
        int lines = grid.length;
        int columns = grid[0].length;
        int line = lines - 1;
        int column = 0;
        int count = 0;
        while (line >= 0 && column < columns) {
            if (grid[line][column] < 0) {
                count += columns - column;
                --line;
            } else {
                ++column;
            }
        }
        return count;
    }
}
