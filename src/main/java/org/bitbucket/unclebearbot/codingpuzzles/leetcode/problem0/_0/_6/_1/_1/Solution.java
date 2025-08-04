package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._6._1._1;

/*

https://leetcode.com/problems/valid-triangle-number

611. Valid Triangle Number
(Medium)

Given an integer array nums, return the number of triplets chosen from the array that can make triangles if we take them as side lengths of a triangle.

Example 1:

Input: nums = [2,2,3,4]
Output: 3
Explanation: Valid combinations are:
2,3,4 (using the first 2)
2,3,4 (using the second 2)
2,2,3

Example 2:

Input: nums = [4,2,3,4]
Output: 4

Constraints:

    1 <= nums.length <= 1000
    0 <= nums[i] <= 1000

 */

import java.util.Arrays;

class Solution {
    public int triangleNumber(int[] nums) {
        if (nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        int count = 0;
        for (int side3 = nums.length - 1; side3 >= 2; --side3) {
            int side2 = side3 - 1;
            int side1 = 0;
            while (side1 < side2) {
                if (nums[side2] + nums[side1] > nums[side3]) {
                    count += side2 - side1;
                    --side2;
                } else {
                    ++side1;
                }
            }
        }
        return count;
    }
}
