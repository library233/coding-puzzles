package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._9._9._4;

/*

https://leetcode.com/problems/rotting-oranges

994. Rotting Oranges
(Medium)

You are given an m x n grid where each cell can have one of three values:

    0 representing an empty cell,
    1 representing a fresh orange, or
    2 representing a rotten orange.

Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.

Example 1:

    |2|1|1|    |2|2|1|    |2|2|2|    |2|2|2|    |2|2|2|
    |1|1| |    |2|1| |    |2|2| |    |2|2| |    |2|2| |
    | |1|1|    | |1|1|    | |1|1|    | |2|1|    | |2|2|
     min=0      min=1      min=2      min=3      min=4

Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
Output: 4

Example 2:

    |2|1|1|    |2|2|1|    |2|2|2|    |2|2|2|    |2|2|2|
    | |1|1|    | |1|1|    | |2|1|    | |2|2|    | |2|2|
    |1| |1|    |1| |1|    |1| |1|    |1| |1|    |1| |2|
     min=0      min=1      min=2      min=3      min=4+

Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.

Example 3:

    | |2|
    min=0

Input: grid = [[0,2]]
Output: 0
Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.

Constraints:

    m == grid.length
    n == grid[i].length
    1 <= m, n <= 10
    grid[i][j] is 0, 1, or 2.

 */

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int orangesRotting(int[][] grid) {
        int lines = grid.length;
        int columns = grid[0].length;
        int fresh = 0;
        Queue<int[]> rotted = new LinkedList<>();
        for (int line = 0; line < lines; ++line) {
            for (int column = 0; column < columns; ++column) {
                switch (grid[line][column]) {
                    case 1:
                        ++fresh;
                        break;
                    case 2:
                        rotted.offer(new int[]{line, column});
                        break;
                    default:
                        break;
                }
            }
        }
        int[] north = new int[]{-1, 0};
        int[] east = new int[]{0, 1};
        int[] south = new int[]{1, 0};
        int[] west = new int[]{0, -1};
        int[][] directions = new int[][]{north, east, south, west};
        int minutes = 0;
        while (!rotted.isEmpty()) {
            int rottedInLastMinute = rotted.size();
            boolean effectiveMinute = false;
            for (int i = 0; i < rottedInLastMinute; ++i) {
                int[] current = rotted.poll();
                for (int[] direction : directions) {
                    int infectingLine = current[0] + direction[0];
                    int infectingColumn = current[1] + direction[1];
                    if (infectingLine < 0 || infectingLine >= lines || infectingColumn < 0 || infectingColumn >= columns) {
                        continue;
                    }
                    if (grid[infectingLine][infectingColumn] != 1) {
                        continue;
                    }
                    --fresh;
                    rotted.offer(new int[]{infectingLine, infectingColumn});
                    grid[infectingLine][infectingColumn] = 2;
                    effectiveMinute = true;
                }
            }
            if (effectiveMinute) {
                ++minutes;
            }
        }
        return fresh == 0 ? minutes : -1;
    }
}
