package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._1._1._8;

/*

https://leetcode.com/problems/pascals-triangle

118. Pascal's Triangle
(Medium)

Given an integer numRows, return the first numRows of Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:

Example 1:

            1
           / \
          1   1
         / \ / \
        1   2   1
       / \ / \ / \
      1   3   3   1
     / \ / \ / \ / \
    1   4   6   4   1

Input: numRows = 5
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]

Example 2:

Input: numRows = 1
Output: [[1]]

Constraints:

    1 <= numRows <= 30

 */

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numRows; ++i) {
            List<Integer> layer = new ArrayList<>();
            for (int j = 0; j <= i; ++j) {
                if (j == 0 || j == i) {
                    layer.add(1);
                    continue;
                }
                List<Integer> top = result.get(i - 1);
                int left = top.get(j - 1);
                int right = top.get(j);
                layer.add(left + right);
            }
            result.add(layer);
        }
        return result;
    }
}
