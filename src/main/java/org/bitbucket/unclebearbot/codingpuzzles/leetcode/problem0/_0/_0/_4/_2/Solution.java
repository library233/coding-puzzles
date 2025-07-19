package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._0._4._2;

/*

https://leetcode.com/problems/trapping-rain-water

42. Trapping Rain Water
(Hard)

Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

Example 1:

           |
       |~~~||~|
     |~||~||||||
    -+-++-++++++

Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.

Example 2:

         |
    |~~~~|
    |~~|~|
    ||~|||
    ||~|||
    ++-+++

Input: height = [4,2,0,3,2,5]
Output: 9

Constraints:

    n == height.length
    1 <= n <= 2 * 10^4
    0 <= height[i] <= 10^5

 */

class Solution {
    public int trap(int[] height) {
        int result = 0;
        int left = 0;
        int right = height.length - 1;
        int maxHeightFromLeft = -1;
        int maxHeightFromRight = -1;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] < maxHeightFromLeft) {
                    result += maxHeightFromLeft - height[left];
                } else {
                    maxHeightFromLeft = height[left];
                }
                ++left;
            } else {
                if (height[right] < maxHeightFromRight) {
                    result += maxHeightFromRight - height[right];
                } else {
                    maxHeightFromRight = height[right];
                }
                --right;
            }
        }
        return result;
    }
}
