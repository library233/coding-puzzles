package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._9._3._1;

/*

https://leetcode.com/problems/minimum-falling-path-sum

931. Minimum Falling Path Sum
(Medium)

Given an n x n array of integers matrix, return the minimum sum of any falling path through matrix.

A falling path starts at any element in the first row and chooses the element in the next row that is either directly below or diagonally left/right. Specifically, the next element from position (row, col) will be (row + 1, col - 1), (row + 1, col), or (row + 1, col + 1).

Example 1:

     2  (1)  3          2  (1)  3
         |                    \
     6  (5)  4    or    6   5  (4)
       /                      /
    (7)  8   9          7  (8)  9


Input: matrix = [[2,1,3],[6,5,4],[7,8,9]]
Output: 13
Explanation: There are two falling paths with a minimum sum as shown.

Example 2:

    (-19)   57
      |
    (-40)   -5

Input: matrix = [[-19,57],[-40,-5]]
Output: -59
Explanation: The falling path with a minimum sum is shown.

Constraints:

    n == matrix.length == matrix[i].length
    1 <= n <= 100
    -100 <= matrix[i][j] <= 100

 */

import java.util.Arrays;

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int size = matrix.length;
        int[] sums = new int[size];
        for (int line = size - 2; line >= 0; --line) {
            for (int column = 0; column < size; ++column) {
                int center = matrix[line + 1][column];
                int left = column > 0 ? matrix[line + 1][column - 1] : Integer.MAX_VALUE;
                int right = column < size - 1 ? matrix[line + 1][column + 1] : Integer.MAX_VALUE;
                int min = Math.min(center, Math.min(left, right));
                matrix[line][column] += min;
            }
        }
        return Arrays.stream(matrix[0]).min().orElseThrow(IllegalArgumentException::new);
    }
}
