package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._3._0._0;

/*

https://leetcode.com/problems/longest-increasing-subsequence

300. Longest Increasing Subsequence
(Medium)

Given an integer array nums, return the length of the longest strictly increasing subsequence.

Example 1:

Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.

Example 2:

Input: nums = [0,1,0,3,2,3]
Output: 4

Example 3:

Input: nums = [7,7,7,7,7,7,7]
Output: 1

Constraints:

    1 <= nums.length <= 2500
    -10^4 <= nums[i] <= 10^4

Follow up: Can you come up with an algorithm that runs in O(n log(n)) time complexity?

 */

import java.util.Arrays;

class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int maxLength = dp[0];
        for (int current = 1; current < nums.length; ++current) {
            for (int earlier = 0; earlier < current; ++earlier) {
                if (nums[current] > nums[earlier] && dp[current] < dp[earlier] + 1) {
                    dp[current] = dp[earlier] + 1;
                }
            }
            if (dp[current] > maxLength) {
                maxLength = dp[current];
            }
        }
        return maxLength;
    }
}
