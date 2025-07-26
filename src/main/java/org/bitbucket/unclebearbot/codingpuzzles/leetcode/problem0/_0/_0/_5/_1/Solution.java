package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._0._5._1;

/*

https://leetcode.com/problems/n-queens

51. N-Queens
(Hard)

The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.

Example 1:

    . Q . .    . . Q .
    . . . Q    Q . . .
    Q . . .    . . . Q
    . . Q .    . Q . .

Input: n = 4
Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above

Example 2:

Input: n = 1
Output: [["Q"]]

Constraints:

    1 <= n <= 9

 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        IntStream.range(0, n).forEach(i -> Arrays.fill(board[i], '.'));
        List<List<String>> results = new ArrayList<>();
        placeQueen(0, board, results);
        return results;
    }

    private void placeQueen(int line, char[][] board, List<List<String>> results) {
        if (line == board.length) {
            List<String> result = Arrays.stream(board).map(String::new).collect(Collectors.toList());
            results.add(result);
            return;
        }
        for (int column = 0; column < board.length; ++column) {
            if (isValidPlace(line, column, board)) {
                board[line][column] = 'Q';
                placeQueen(line + 1, board, results);
                board[line][column] = '.';
            }
        }
    }

    private boolean isValidPlace(int line, int column, char[][] board) {
        for (int i = 0; i < line; ++i) {
            if (board[i][column] == 'Q') {
                return false;
            }
        }
        for (int i = line - 1, j = column - 1; i >= 0 && j >= 0; --i, --j) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        for (int i = line - 1, j = column + 1; i >= 0 && j < board.length; --i, ++j) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }
}
