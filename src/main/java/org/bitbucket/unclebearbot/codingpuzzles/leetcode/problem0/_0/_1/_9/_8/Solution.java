package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._1._9._8;

/*

https://leetcode.com/problems/house-robber

198. House Robber
(Medium)

You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

Example 1:

Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.

Example 2:

Input: nums = [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
Total amount you can rob = 2 + 9 + 1 = 12.

Constraints:

    1 <= nums.length <= 100
    0 <= nums[i] <= 400

 */

class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int bestAtPrevious2 = 0;
        int bestAtPrevious1 = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            int takingCurrent = bestAtPrevious2 + nums[i];
            int better = Math.max(takingCurrent, bestAtPrevious1);
            bestAtPrevious2 = bestAtPrevious1;
            bestAtPrevious1 = better;
        }
        return bestAtPrevious1;
    }
}
