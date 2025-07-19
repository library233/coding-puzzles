package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._2._0._9;

/*

https://leetcode.com/problems/minimum-size-subarray-sum

209. Minimum Size Subarray Sum
(Medium)

Given an array of positive integers nums and a positive integer target, return the minimal length of a

whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.

Example 1:

Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.

Example 2:

Input: target = 4, nums = [1,4,4]
Output: 1

Example 3:

Input: target = 11, nums = [1,1,1,1,1,1,1,1]
Output: 0

Constraints:

    1 <= target <= 10^9
    1 <= nums.length <= 10^5
    1 <= nums[i] <= 10^4

Follow up: If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log(n)).

 */

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;
        while (right < nums.length) {
            sum += nums[right];
            while (sum >= target) {
                int length = right - left + 1;
                minLength = Math.min(minLength, length);
                sum -= nums[left];
                ++left;
            }
            ++right;
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
