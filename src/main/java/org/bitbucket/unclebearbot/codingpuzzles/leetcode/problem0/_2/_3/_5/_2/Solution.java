package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._2._3._5._2;

/*

https://leetcode.com/problems/equal-row-and-column-pairs

2352. Equal Row and Column Pairs
(Medium)

Given a 0-indexed n x n integer matrix grid, return the number of pairs (ri, cj) such that row ri and column cj are equal.

A row and column pair is considered equal if they contain the same elements in the same order (i.e., an equal array).

Example 1:

    |3|2|1|
    |1|7|6|
    |2|7|7|

Input: grid = [[3,2,1],[1,7,6],[2,7,7]]
Output: 1
Explanation: There is 1 equal row and column pair:
- (Row 2, Column 1): [2,7,7]

Example 2:

    |3|1|2|2|
    |1|4|4|5|
    |2|4|2|2|
    |2|4|2|2|

Input: grid = [[3,1,2,2],[1,4,4,5],[2,4,2,2],[2,4,2,2]]
Output: 3
Explanation: There are 3 equal row and column pairs:
- (Row 0, Column 0): [3,1,2,2]
- (Row 2, Column 2): [2,4,2,2]
- (Row 3, Column 2): [2,4,2,2]

Constraints:

    n == grid.length == grid[i].length
    1 <= n <= 200
    1 <= grid[i][j] <= 10^5

 */

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {
    public int equalPairs(int[][] grid) {
        int length = grid.length;
        List<LinkedList<Integer>> lines = IntStream.range(0, length).mapToObj(i -> new LinkedList<Integer>()).collect(Collectors.toList());
        List<LinkedList<Integer>> columns = IntStream.range(0, length).mapToObj(i -> new LinkedList<Integer>()).collect(Collectors.toList());
        for (int line = 0; line < length; ++line) {
            for (int column = 0; column < length; ++column) {
                lines.get(line).add(column, grid[line][column]);
                columns.get(column).add(line, grid[line][column]);
            }
        }
        return (int) lines.stream().mapToLong(line -> columns.stream().filter(column -> Objects.equals(line, column)).count()).sum();
    }
}
