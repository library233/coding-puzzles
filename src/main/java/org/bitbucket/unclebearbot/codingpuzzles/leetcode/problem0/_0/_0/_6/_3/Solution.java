package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._0._6._3;

/*

https://leetcode.com/problems/unique-paths-ii

63. Unique Paths II
(Medium)

You are given an m x n integer array grid. There is a robot initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.

An obstacle and space are marked as 1 or 0 respectively in grid. A path that the robot takes cannot include any square that is an obstacle.

Return the number of possible unique paths that the robot can take to reach the bottom-right corner.

The testcases are generated so that the answer will be less than or equal to 2 * 109.

Example 1:

    |#| | |
    | |X| |
    | | |#|

Input: obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
Output: 2
Explanation: There is one obstacle in the middle of the 3x3 grid above.
There are two ways to reach the bottom-right corner:
1. Right -> Right -> Down -> Down
2. Down -> Down -> Right -> Right

Example 2:

    |#|X|
    | |#|

Input: obstacleGrid = [[0,1],[0,0]]
Output: 1

Constraints:

    m == obstacleGrid.length
    n == obstacleGrid[i].length
    1 <= m, n <= 100
    obstacleGrid[i][j] is 0 or 1.

 */

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int lines = obstacleGrid.length;
        int columns = obstacleGrid[0].length;
        if (obstacleGrid[0][0] != 0 || obstacleGrid[lines - 1][columns - 1] != 0) {
            return 0;
        }
        int[][] paths = new int[lines][columns];
        paths[0][0] = 1;
        for (int line = 0; line < lines; ++line) {
            if (obstacleGrid[line][0] != 0) {
                break;
            }
            paths[line][0] = 1;
        }
        for (int column = 1; column < columns; ++column) {
            if (obstacleGrid[0][column] != 0) {
                break;
            }
            paths[0][column] = 1;
        }
        for (int line = 1; line < lines; ++line) {
            for (int column = 1; column < columns; ++column) {
                if (obstacleGrid[line][column] == 0) {
                    paths[line][column] = paths[line - 1][column] + paths[line][column - 1];
                }
            }
        }
        return paths[lines - 1][columns - 1];
    }
}
