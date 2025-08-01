package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._8._9._6;

/*

https://leetcode.com/problems/monotonic-array

896. Monotonic Array
(Easy)

An array is monotonic if it is either monotone increasing or monotone decreasing.

An array nums is monotone increasing if for all i <= j, nums[i] <= nums[j]. An array nums is monotone decreasing if for all i <= j, nums[i] >= nums[j].

Given an integer array nums, return true if the given array is monotonic, or false otherwise.

Example 1:

Input: nums = [1,2,2,3]
Output: true

Example 2:

Input: nums = [6,5,4,4]
Output: true

Example 3:

Input: nums = [1,3,2]
Output: false

Constraints:

    1 <= nums.length <= 10^5
    -10^5 <= nums[i] <= 10^5

 */

import java.util.stream.IntStream;

class Solution {
    public boolean isMonotonic(int[] nums) {
        if (nums.length < 3) {
            return true;
        }
        int sign = nums[nums.length - 1] >= nums[0] ? 1 : -1;
        return IntStream.range(1, nums.length).allMatch(i -> sign * (nums[i] - nums[i - 1]) >= 0);
    }
}
