package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._0._7._4;

/*

https://leetcode.com/problems/search-a-2d-matrix

74. Search a 2D Matrix
(Medium)

You are given an m x n integer matrix `matrix` with the following two properties:

    Each row is sorted in non-decreasing order.
    The first integer of each row is greater than the last integer of the previous row.

Given an integer target, return true if target is in matrix or false otherwise.

You must write a solution in O(log(m * n)) time complexity.

Example 1:

     1  (3)  5   7
    10  11  16  20
    23  30  34  60

Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true

Example 2:

     1   3   5   7
    10  11  16  20
    23  30  34  60

Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
Output: false

Constraints:

    m == matrix.length
    n == matrix[i].length
    1 <= m, n <= 100
    -10^4 <= matrix[i][j], target <= 10^4

 */

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int lines = matrix.length;
        int columns = matrix[0].length;
        int count = lines * columns;
        int left = 0;
        int right = count - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int line = mid / columns;
            int column = mid % columns;
            int value = matrix[line][column];
            if (target < value) {
                right = mid - 1;
                continue;
            }
            if (target > value) {
                left = mid + 1;
                continue;
            }
            return true;
        }
        return false;
    }
}
