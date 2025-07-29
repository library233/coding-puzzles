package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._1._2._0;

/*

https://leetcode.com/problems/triangle

120. Triangle
(Medium)

Given a triangle array, return the minimum path sum from top to bottom.

For each step, you may move to an adjacent number of the row below. More formally, if you are on index i on the current row, you may move to either index i or index i + 1 on the next row.

Example 1:

Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
Output: 11
Explanation: The triangle looks like:

    (2)
     |
    (3)    4
        \
     6    (5)    7
           |
     4    (1)    8     3

The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined above).

Example 2:

Input: triangle = [[-10]]
Output: -10

Constraints:

    1 <= triangle.length <= 200
    triangle[0].length == 1
    triangle[i].length == triangle[i - 1].length + 1
    -10^4 <= triangle[i][j] <= 10^4

Follow up: Could you do this using only O(n) extra space, where n is the total number of rows in the triangle?

 */

import java.util.List;

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int height = triangle.size();
        int[] sums = new int[height + 1];
        for (int layer = height - 1; layer >= 0; --layer) {
            List<Integer> numbers = triangle.get(layer);
            int length = numbers.size();
            for (int index = 0; index < length; ++index) {
                int number = numbers.get(index);
                int min = Math.min(sums[index], sums[index + 1]);
                sums[index] = number + min;
            }
        }
        return sums[0];
    }
}
