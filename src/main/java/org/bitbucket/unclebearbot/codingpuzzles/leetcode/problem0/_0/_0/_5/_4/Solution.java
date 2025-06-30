package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._0._5._4;

/*

https://leetcode.com/problems/spiral-matrix

54. Spiral Matrix
(Medium)

Given an m x n matrix, return all elements of the matrix in spiral order.

Example 1:

    (1) -> (2) -> (3)
                   |
    (4) -> (5)    (6)
     |             |
    (7) <- (8) <- (9)

Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]

Example 2:

    (1)  -> (2)  -> (3)  -> (4)
                             |
    (5)  -> (6)  -> (7)     (8)
     |                       |
    (9) <- (10) <- (11) <- (12)

Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]

Constraints:

    m == matrix.length
    n == matrix[i].length
    1 <= m, n <= 10
    -100 <= matrix[i][j] <= 100

 */

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int minColumn = 0;
        int maxColumn = matrix[0].length - 1;
        int minLine = 0;
        int maxLine = matrix.length - 1;
        int direction = 0;
        while (minColumn <= maxColumn && minLine <= maxLine) {
            switch (direction) {
                case 0:
                    for (int column = minColumn; column <= maxColumn; ++column) {
                        result.add(matrix[minLine][column]);
                    }
                    ++minLine;
                    break;
                case 1:
                    for (int line = minLine; line <= maxLine; ++line) {
                        result.add(matrix[line][maxColumn]);
                    }
                    --maxColumn;
                    break;
                case 2:
                    for (int column = maxColumn; column >= minColumn; --column) {
                        result.add(matrix[maxLine][column]);
                    }
                    --maxLine;
                    break;
                case 3:
                    for (int line = maxLine; line >= minLine; --line) {
                        result.add(matrix[line][minColumn]);
                    }
                    ++minColumn;
                    break;
                default:
                    throw new IllegalStateException();
            }
            direction = (direction + 1) % 4;
        }
        return result;
    }
}
