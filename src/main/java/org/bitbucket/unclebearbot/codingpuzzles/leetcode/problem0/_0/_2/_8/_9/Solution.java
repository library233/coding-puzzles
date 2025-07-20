package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._2._8._9;

/*

https://leetcode.com/problems/game-of-life

289. Game of Life
(Medium)

According to Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."

The board is made up of an m x n grid of cells, where each cell has an initial state: live (represented by a 1) or dead (represented by a 0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):

    Any live cell with fewer than two live neighbors dies as if caused by under-population.
    Any live cell with two or three live neighbors lives on to the next generation.
    Any live cell with more than three live neighbors dies, as if by over-population.
    Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.

The next state of the board is determined by applying the above rules simultaneously to every cell in the current state of the m x n grid board. In this process, births and deaths occur simultaneously.

Given the current state of the board, update the board to reflect its next state.

Note that you do not need to return anything.

Example 1:

    0 1 0          0 0 0
    0 0 1    ->    1 0 1
    1 1 1          0 1 1
    0 0 0          0 1 0

Input: board = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]
Output: [[0,0,0],[1,0,1],[0,1,1],[0,1,0]]

Example 2:

    1 1    ->    1 1
    1 0          1 1

Input: board = [[1,1],[1,0]]
Output: [[1,1],[1,1]]

Constraints:

    m == board.length
    n == board[i].length
    1 <= m, n <= 25
    board[i][j] is 0 or 1.

Follow up:

    Could you solve it in-place? Remember that the board needs to be updated simultaneously: You cannot update some cells first and then use their updated values to update other cells.
    In this question, we represent the board using a 2D array. In principle, the board is infinite, which would cause problems when the active area encroaches upon the border of the array (i.e., live cells reach the border). How would you address these problems?

 */

class Solution {
    private static final int DEAD = 0;
    private static final int LIVE = 1;
    private static final int FROM_LIVE_TO_DEAD = 2;
    private static final int FROM_DEAD_TO_LIVE = 3;

    public void gameOfLife(int[][] board) {
        for (int line = 0; line < board.length; ++line) {
            for (int column = 0; column < board[0].length; ++column) {
                int liveNeighbors = countLiveNeighbors(board, line, column);
                if (board[line][column] == LIVE) {
                    if (liveNeighbors < 2 || liveNeighbors > 3) {
                        board[line][column] = FROM_LIVE_TO_DEAD;
                    }
                } else {
                    if (liveNeighbors == 3) {
                        board[line][column] = FROM_DEAD_TO_LIVE;
                    }
                }
            }
        }
        for (int line = 0; line < board.length; ++line) {
            for (int column = 0; column < board[0].length; ++column) {
                if (board[line][column] == FROM_DEAD_TO_LIVE) {
                    board[line][column] = LIVE;
                } else if (board[line][column] == FROM_LIVE_TO_DEAD) {
                    board[line][column] = DEAD;
                }
            }
        }
    }

    private int countLiveNeighbors(int[][] board, int line, int column) {
        int count = 0;
        count += countLive(board, line - 1, column - 1);
        count += countLive(board, line - 1, column + 0);
        count += countLive(board, line - 1, column + 1);
        count += countLive(board, line + 0, column - 1);
        count += countLive(board, line + 0, column + 1);
        count += countLive(board, line + 1, column - 1);
        count += countLive(board, line + 1, column + 0);
        count += countLive(board, line + 1, column + 1);
        return count;
    }

    private int countLive(int[][] board, int line, int column) {
        if (line < 0 || line >= board.length) {
            return 0;
        }
        if (column < 0 || column >= board[0].length) {
            return 0;
        }
        if (board[line][column] == LIVE || board[line][column] == FROM_LIVE_TO_DEAD) {
            return 1;
        }
        return 0;
    }
}
