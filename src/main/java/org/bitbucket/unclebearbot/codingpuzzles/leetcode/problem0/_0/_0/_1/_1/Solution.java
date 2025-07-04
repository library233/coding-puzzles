package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._0._1._1;

/*

https://leetcode.com/problems/container-with-most-water

11. Container With Most Water
(Medium)

You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

Find two lines that together with the x-axis form a container, such that the container contains the most water.

Return the maximum amount of water a container can store.

Notice that you may not slant the container.

Example 1:

      ^
     9|
     8|         |________________________|__________
     7|         |                        |         |
     6|         |    |                   |         |
     5|         |    |         |         |         |
     4|         |    |         |    |    |         |
     3|         |    |         |    |    |    |    |
     2|         |    |    |    |    |    |    |    |
     1|    |    |    |    |    |    |    |    |    |
    --+----+----+----+----+----+----+----+----+----+--->
     0|    1    2    3    4    5    6    7    8    9

Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.

Example 2:

Input: height = [1,1]
Output: 1

Constraints:

    n == height.length
    2 <= n <= 10^5
    0 <= height[i] <= 10^4

 */

class Solution {
    public int maxArea(int[] height) {
        int leftIndex = 0;
        int rightIndex = height.length - 1;
        int maxArea = 0;
        while (leftIndex < rightIndex) {
            int leftHeight = height[leftIndex];
            int rightHeight = height[rightIndex];
            int area = (rightIndex - leftIndex) * Math.min(leftHeight, rightHeight);
            if (area > maxArea) {
                maxArea = area;
            }
            if (leftHeight < rightHeight) {
                ++leftIndex;
            } else {
                --rightIndex;
            }
        }
        return maxArea;
    }
}
