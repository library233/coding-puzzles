package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._0._7._9;

/*

https://leetcode.com/problems/word-search

79. Word Search
(Medium)

Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.

Example 1:

    (A)->(B)->(C)   E
               V
     S    F   (C)   S
               V
     A   (D)<-(E)   E

Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true

Example 2:

    A    B    C    E

    S    F    C   (S)
                   V
    A    D   (E)<-(E)

Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
Output: true

Example 3:

    A    B    C    E

    S    F    C    S

    A    D    E    E

Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
Output: false

Constraints:

    m == board.length
    n = board[i].length
    1 <= m, n <= 6
    1 <= word.length <= 15
    board and word consists of only lowercase and uppercase English letters.

Follow up: Could you use search pruning to make your solution faster with a larger board?

 */

import java.util.stream.IntStream;

class Solution {
    public boolean exist(char[][] board, String word) {
        return IntStream.range(0, board.length).anyMatch(line -> IntStream.range(0, board[0].length).anyMatch(column -> isFound(line, column, 0, board, word)));
    }

    private boolean isFound(int line, int column, int index, char[][] board, String word) {
        if (index == word.length()) {
            return true;
        }
        if (line < 0 || line >= board.length || column < 0 || column >= board[0].length) {
            return false;
        }
        char temp = board[line][column];
        if (temp != word.charAt(index)) {
            return false;
        }
        board[line][column] = '\0';
        boolean found = isFound(line - 1, column, index + 1, board, word)
                        || isFound(line + 1, column, index + 1, board, word)
                        || isFound(line, column - 1, index + 1, board, word)
                        || isFound(line, column + 1, index + 1, board, word);
        board[line][column] = temp;
        return found;
    }
}
