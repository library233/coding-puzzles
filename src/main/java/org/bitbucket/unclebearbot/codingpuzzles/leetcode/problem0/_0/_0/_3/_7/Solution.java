package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._0._3._7;

/*

https://leetcode.com/problems/sudoku-solver

37. Sudoku Solver
(Hard)

Write a program to solve a Sudoku puzzle by filling the empty cells.

A sudoku solution must satisfy all of the following rules:

    Each of the digits 1-9 must occur exactly once in each row.
    Each of the digits 1-9 must occur exactly once in each column.
    Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.

The '.' character indicates empty cells.

Example 1:

    +-----------+-----------+-----------+
    | 5   3   . | .   7   . | .   .   . |
    | 6   .   . | 1   9   5 | .   .   . |
    | .   9   8 | .   .   . | .   6   . |
    +-----------+-----------+-----------+
    | 8   .   . | .   6   . | .   .   3 |
    | 4   .   . | 8   .   3 | .   .   1 |
    | 7   .   . | .   2   . | .   .   6 |
    +-----------+-----------+-----------+
    | .   6   . | .   .   . | 2   8   . |
    | .   .   . | 4   1   9 | .   .   5 |
    | .   .   . | .   8   . | .   7   9 |
    +-----------+-----------+-----------+

Input: board = [["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]
Output: [["5","3","4","6","7","8","9","1","2"],["6","7","2","1","9","5","3","4","8"],["1","9","8","3","4","2","5","6","7"],["8","5","9","7","6","1","4","2","3"],["4","2","6","8","5","3","7","9","1"],["7","1","3","9","2","4","8","5","6"],["9","6","1","5","3","7","2","8","4"],["2","8","7","4","1","9","6","3","5"],["3","4","5","2","8","6","1","7","9"]]
Explanation: The input board is shown above and the only valid solution is shown below:

    +-----------+-----------+-----------+
    | 5   3   4 | 6   7   8 | 9   1   2 |
    | 6   7   2 | 1   9   5 | 3   4   8 |
    | 1   9   8 | 3   4   2 | 5   6   7 |
    +-----------+-----------+-----------+
    | 8   5   9 | 7   6   1 | 4   2   3 |
    | 4   2   6 | 8   5   3 | 7   9   1 |
    | 7   1   3 | 9   2   4 | 8   5   6 |
    +-----------+-----------+-----------+
    | 9   6   1 | 5   3   7 | 2   8   4 |
    | 2   8   7 | 4   1   9 | 6   3   5 |
    | 3   4   5 | 2   8   6 | 1   7   9 |
    +-----------+-----------+-----------+

Constraints:

    board.length == 9
    board[i].length == 9
    board[i][j] is a digit or '.'.
    It is guaranteed that the input board has only one solution.

 */

class Solution {
    public void solveSudoku(char[][] board) {
        fill(board, 0);
    }

    private boolean fill(char[][] board, int index) {
        if (index == 81) {
            return true;
        }
        int line = index / 9;
        int column = index % 9;
        if (board[line][column] != '.') {
            return fill(board, index + 1);
        }
        for (char number = '1'; number <= '9'; ++number) {
            if (canFill(board, line, column, number)) {
                board[line][column] = number;
                if (fill(board, index + 1)) {
                    return true;
                }
                board[line][column] = '.';
            }
        }
        return false;
    }

    private boolean canFill(char[][] board, int line, int column, char number) {
        for (int i = 0; i < 9; ++i) {
            if (board[line][i] == number) {
                return false;
            }
            if (board[i][column] == number) {
                return false;
            }
            int boxLine = (line / 3) * 3 + i / 3;
            int boxColumn = (column / 3) * 3 + i % 3;
            if (board[boxLine][boxColumn] == number) {
                return false;
            }
        }
        return true;
    }
}
