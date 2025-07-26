package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._0._5._2;

/*

https://leetcode.com/problems/n-queens-ii

52. N-Queens II
(Hard)

The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

Given an integer n, return the number of distinct solutions to the n-queens puzzle.

Example 1:

    . Q . .    . . Q .
    . . . Q    Q . . .
    Q . . .    . . . Q
    . . Q .    . Q . .

Input: n = 4
Output: 2
Explanation: There are two distinct solutions to the 4-queens puzzle as shown.

Example 2:

Input: n = 1
Output: 1

Constraints:

    1 <= n <= 9

 */

import java.util.HashSet;
import java.util.Set;

class Solution {
    private final Set<Integer> columnConflicts = new HashSet<>();
    private final Set<Integer> principalDiagonalConflicts = new HashSet<>();
    private final Set<Integer> auxiliaryDiagonalConflicts = new HashSet<>();
    private int size;
    private int count;

    public int totalNQueens(int n) {
        count = 0;
        size = n;
        placeQueen(0);
        return count;
    }

    private void placeQueen(int line) {
        if (line == size) {
            ++count;
            return;
        }
        for (int column = 0; column < size; ++column) {
            if (columnConflicts.contains(column)) {
                continue;
            }
            int principalDiagonal = line - column;
            if (principalDiagonalConflicts.contains(principalDiagonal)) {
                continue;
            }
            int auxiliaryDiagonal = line + column;
            if (auxiliaryDiagonalConflicts.contains(auxiliaryDiagonal)) {
                continue;
            }
            columnConflicts.add(column);
            principalDiagonalConflicts.add(principalDiagonal);
            auxiliaryDiagonalConflicts.add(auxiliaryDiagonal);
            placeQueen(line + 1);
            columnConflicts.remove(column);
            principalDiagonalConflicts.remove(principalDiagonal);
            auxiliaryDiagonalConflicts.remove(auxiliaryDiagonal);
        }
    }
}
