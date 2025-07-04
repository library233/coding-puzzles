package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._0._8._4;

/*

https://leetcode.com/problems/largest-rectangle-in-histogram

84. Largest Rectangle in Histogram
(Hard)

Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.

Example 1:

                  6                                6
              5 +---+                          5 +---+
            +---+   |                        #########
            |   |   |     3                  #########     3
      2     |   |   | 2 +---+          2     ######### 2 +---+
    +---+ 1 |   |   +---+   |        +---+ 1 #########---+   |
    |   +---+   |   |   |   |        |   +---#########   |   |
    +---+---+---+---+---+---+        +---+---#########---+---+
                                               (2*5)

Input: heights = [2,1,5,6,2,3]
Output: 10
Explanation: The above is a histogram where width of each bar is 1.
The largest rectangle is shown in the red area, which has an area = 10 units.

Example 2:

          4                4                4
        +---+            +---+            #####
      2 |   |          2 |   |          2 #####
    +---+   |        #########        +---#####
    |   |   |        #########        |   #####
    +---+---+        #########        +---#####
                       (2*2)              (1*4)

Input: heights = [2,4]
Output: 4

Constraints:

    1 <= heights.length <= 10^5
    0 <= heights[i] <= 10^4

 */

import java.util.Stack;

class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        int[] bars = new int[heights.length + 2];
        System.arraycopy(heights, 0, bars, 1, heights.length);
        Stack<Integer> uncovered = new Stack<>();
        uncovered.push(0);
        for (int rightBarIndex = 1; rightBarIndex < bars.length; ++rightBarIndex) {
            while (bars[rightBarIndex] < bars[uncovered.peek()]) {
                int height = bars[uncovered.pop()];
                int leftBoundaryIndex = uncovered.peek();
                int width = rightBarIndex - leftBoundaryIndex - 1;
                int area = width * height;
                if (area > maxArea) {
                    maxArea = area;
                }
            }
            uncovered.push(rightBarIndex);
        }
        return maxArea;
    }
}
