package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._0._6._2;

/*

https://leetcode.com/problems/unique-paths

62. Unique Paths
(Medium)

There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.

Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.

The test cases are generated so that the answer will be less than or equal to 2 * 109.

Example 1:

    |#| | | | | | |
    | | | | | | | |
    | | | | | | |#|

Input: m = 3, n = 7
Output: 28

Example 2:

    |#| |
    | | |
    | |#|

Input: m = 3, n = 2
Output: 3
Explanation: From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Down -> Down
2. Down -> Down -> Right
3. Down -> Right -> Down

Constraints:

    1 <= m, n <= 100

 */

class Solution {
    public int uniquePaths(int m, int n) {
        int[][] paths = new int[m][n];
        for (int line = 0; line < m; ++line) {
            paths[line][0] = 1;
        }
        for (int column = 1; column < n; ++column) {
            paths[0][column] = 1;
        }
        for (int line = 1; line < m; ++line) {
            for (int column = 1; column < n; ++column) {
                paths[line][column] = paths[line][column - 1] + paths[line - 1][column];
            }
        }
        return paths[m - 1][n - 1];
    }
}
