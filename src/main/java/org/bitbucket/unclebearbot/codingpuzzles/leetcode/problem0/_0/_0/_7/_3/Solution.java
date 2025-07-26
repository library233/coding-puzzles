package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._0._7._3;

/*

https://leetcode.com/problems/set-matrix-zeroes

73. Set Matrix Zeroes
(Medium)

Given an m x n integer matrix `matrix`, if an element is 0, set its entire row and column to 0's.

You must do it in place.

Example 1:

    1  1  1           1 (0) 1
    1 (0) 1    ->    (0)(0)(0)
    1  1  1           1 (0) 1

Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
Output: [[1,0,1],[0,0,0],[1,0,1]]

Example 2:

    (0) 1  2 (0)          (0)(0)(0)(0)
     3  4  5  2     ->    (0) 4  5 (0)
     1  3  1  5           (0) 3  1 (0)

Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]

Constraints:

    m == matrix.length
    n == matrix[0].length
    1 <= m, n <= 200
    -2^31 <= matrix[i][j] <= 2^31 - 1

Follow up:

    A straightforward solution using O(mn) space is probably a bad idea.
    A simple improvement uses O(m + n) space, but still not the best solution.
    Could you devise a constant space solution?

 */

class Solution {
    public void setZeroes(int[][] matrix) {
        int lines = matrix.length;
        int columns = matrix[0].length;
        boolean zeroInFirstColumn = false;
        for (int line = 0; line < lines; ++line) {
            if (matrix[line][0] == 0) {
                zeroInFirstColumn = true;
                break;
            }
        }
        boolean zeroInFirstLine = false;
        for (int column = 0; column < columns; ++column) {
            if (matrix[0][column] == 0) {
                zeroInFirstLine = true;
                break;
            }
        }
        for (int line = 1; line < lines; ++line) {
            for (int column = 1; column < columns; ++column) {
                if (matrix[line][column] == 0) {
                    matrix[line][0] = 0;
                    matrix[0][column] = 0;
                }
            }
        }
        for (int line = 1; line < lines; ++line) {
            for (int column = 1; column < columns; ++column) {
                if (matrix[line][0] == 0 || matrix[0][column] == 0) {
                    matrix[line][column] = 0;
                }
            }
        }
        if (zeroInFirstColumn) {
            for (int line = 0; line < lines; ++line) {
                matrix[line][0] = 0;
            }
        }
        if (zeroInFirstLine) {
            for (int column = 0; column < columns; ++column) {
                matrix[0][column] = 0;
            }
        }
    }
}
