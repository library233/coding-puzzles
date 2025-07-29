package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._2._2._1;

/*

https://leetcode.com/problems/maximal-square

221. Maximal Square
(Medium)

Given an m x n binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

Example 1:

    1  0  1  0  0          1  0  1  0  0
    1  0 (1)(1) 1          1  0  1 (1)(1)
    1  1 (1)(1) 1    or    1  1  1 (1)(1)
    1  0  0  1  0          1  0  0  1  0

Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
Output: 4

Example 2:

    0 (1)         0  1
    1  0    or   (1) 0

Input: matrix = [["0","1"],["1","0"]]
Output: 1

Example 3:

Input: matrix = [["0"]]
Output: 0

Constraints:

    m == matrix.length
    n == matrix[i].length
    1 <= m, n <= 300
    matrix[i][j] is '0' or '1'.

 */

class Solution {
    public int maximalSquare(char[][] matrix) {
        int maxSideLength = 0;
        int lines = matrix.length;
        int columns = matrix[0].length;
        int[][] sideLengths = new int[lines + 1][columns + 1];
        for (int line = 1; line <= lines; ++line) {
            for (int column = 1; column <= columns; ++column) {
                if (matrix[line - 1][column - 1] == '1') {
                    int top = sideLengths[line - 1][column];
                    int left = sideLengths[line][column - 1];
                    int topLeft = sideLengths[line - 1][column - 1];
                    int sideLength = Math.min(Math.min(top, left), topLeft) + 1;
                    sideLengths[line][column] = sideLength;
                    maxSideLength = Math.max(maxSideLength, sideLength);
                }
            }
        }
        return maxSideLength * maxSideLength;
    }
}
