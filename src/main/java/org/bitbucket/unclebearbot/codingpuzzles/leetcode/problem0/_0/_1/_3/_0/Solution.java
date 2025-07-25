package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._1._3._0;

/*

https://leetcode.com/problems/surrounded-regions

130. Surrounded Regions
(Medium)

You are given an m x n matrix board containing letters 'X' and 'O', capture regions that are surrounded:

    Connect: A cell is connected to adjacent cells horizontally or vertically.
    Region: To form a region connect every 'O' cell.
    Surround: The region is surrounded with 'X' cells if you can connect the region with 'X' cells and none of the region cells are on the edge of the board.

To capture a surrounded region, replace all 'O's with 'X's in-place within the original board. You do not need to return anything.

Example 1:

    X X X X          X X X X
    X O O X          X X X X
    X X O X    ->    X X X X
    X O X X          X O X X

Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]

Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]

Explanation:

In the above diagram, the bottom region is not captured because it is on the edge of the board and cannot be surrounded.

Example 2:

Input: board = [["X"]]

Output: [["X"]]

Constraints:

    m == board.length
    n == board[i].length
    1 <= m, n <= 200
    board[i][j] is 'X' or 'O'.

 */

import java.util.stream.IntStream;

class Solution {
    private int[] ancestors;

    public void solve(char[][] board) {
        int lines = board.length;
        int columns = board[0].length;
        int outside = lines * columns;
        ancestors = IntStream.rangeClosed(0, outside).toArray();
        for (int line = 0; line < lines; ++line) {
            for (int column = 0; column < columns; ++column) {
                if (board[line][column] == 'O') {
                    int index = index(line, column, columns);
                    if (line == 0 || line == lines - 1 || column == 0 || column == columns - 1) {
                        union(index, outside);
                    }
                    if (line > 0 && board[line - 1][column] == 'O') {
                        int adjacency = index(line - 1, column, columns);
                        union(index, adjacency);
                    }
                    if (line < lines - 1 && board[line + 1][column] == 'O') {
                        int adjacency = index(line + 1, column, columns);
                        union(index, adjacency);
                    }
                    if (column > 0 && board[line][column - 1] == 'O') {
                        int adjacency = index(line, column - 1, columns);
                        union(index, adjacency);
                    }
                    if (column < columns - 1 && board[line][column + 1] == 'O') {
                        int adjacency = index(line, column + 1, columns);
                        union(index, adjacency);
                    }
                }
            }
        }
        for (int line = 0; line < lines; ++line) {
            for (int column = 0; column < columns; ++column) {
                if (board[line][column] == 'O') {
                    int index = index(line, column, columns);
                    if (find(index) != find(outside)) {
                        board[line][column] = 'X';
                    }
                }
            }
        }
    }

    private int index(int line, int column, int columns) {
        return line * columns + column;
    }

    private void union(int element1, int element2) {
        int ancestor1 = find(element1);
        int ancestor2 = find(element2);
        if (ancestor1 != ancestor2) {
            ancestors[ancestor1] = ancestor2;
        }
    }

    private int find(int element) {
        if (ancestors[element] != element) {
            int ancestor = find(ancestors[element]);
            ancestors[element] = ancestor;
        }
        return ancestors[element];
    }
}
