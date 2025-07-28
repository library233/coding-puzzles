package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._1._3._7;

/*

https://leetcode.com/problems/single-number-ii

137. Single Number II
(Medium)

Given an integer array nums where every element appears three times except for one, which appears exactly once. Find the single element and return it.

You must implement a solution with a linear runtime complexity and use only constant extra space.

Example 1:

Input: nums = [2,2,3,2]
Output: 3

Example 2:

Input: nums = [0,1,0,1,0,1,99]
Output: 99

Constraints:

    1 <= nums.length <= 3 * 10^4
    -2^31 <= nums[i] <= 2^31 - 1
    Each element in nums appears exactly three times except for one element which appears once.

 */

class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < 32; ++i) {
            int sum = 0;
            for (int num : nums) {
                int bit = (num >>> i) & 1;
                sum += bit;
            }
            int mod = sum % 3;
            result |= mod << i;
        }
        return result;
    }
}
