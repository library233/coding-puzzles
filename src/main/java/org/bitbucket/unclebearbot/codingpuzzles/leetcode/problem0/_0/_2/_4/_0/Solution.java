package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._2._4._0;

/*

https://leetcode.com/problems/search-a-2d-matrix-ii

240. Search a 2D Matrix II
(Medium)

Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. This matrix has the following properties:

    Integers in each row are sorted in ascending from left to right.
    Integers in each column are sorted in ascending from top to bottom.

Example 1:

     1  4  7 11 15
     2 (5) 8 12 19
     3  6  9 16 22
    10 13 14 17 24
    18 21 23 26 30

               15
            11    19
          7    12    22
       4     8    16    24
    1    (5)    9    17    30
       2     6    14    26
          3    13    23
            10    21
               18

Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
Output: true

Example 2:

     1  4  7 11 15
     2  5  8 12 19
     3  6  9 16 22
    10 13 14 17 24
    18 21 23 26 30

Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
Output: false

Constraints:

    m == matrix.length
    n == matrix[i].length
    1 <= n, m <= 300
    -10^9 <= matrix[i][j] <= 10^9
    All the integers in each row are sorted in ascending order.
    All the integers in each column are sorted in ascending order.
    -10^9 <= target <= 10^9

 */

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int lines = matrix.length;
        int columns = matrix[0].length;
        int line = lines - 1;
        int column = 0;
        while (line >= 0 && column < columns) {
            int number = matrix[line][column];
            if (target < number) {
                --line;
                continue;
            }
            if (target > number) {
                ++column;
                continue;
            }
            return true;
        }
        return false;
    }
}
