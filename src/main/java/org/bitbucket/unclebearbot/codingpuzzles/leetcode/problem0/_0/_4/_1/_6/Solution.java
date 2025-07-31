package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._4._1._6;

/*

https://leetcode.com/problems/partition-equal-subset-sum

416. Partition Equal Subset Sum
(Medium)

Given an integer array nums, return true if you can partition the array into two subsets such that the sum of the elements in both subsets is equal or false otherwise.

Example 1:

Input: nums = [1,5,11,5]
Output: true
Explanation: The array can be partitioned as [1, 5, 5] and [11].

Example 2:

Input: nums = [1,2,3,5]
Output: false
Explanation: The array cannot be partitioned into equal sum subsets.

Constraints:

    1 <= nums.length <= 200
    1 <= nums[i] <= 100

 */

import java.util.Arrays;

class Solution {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        boolean[] canSumTo = new boolean[target + 1];
        canSumTo[0] = true;
        for (int number : nums) {
            for (int milestone = target; milestone >= number; --milestone) {
                boolean canUseCurrentNumber = canSumTo[milestone - number];
                canSumTo[milestone] = canSumTo[milestone] || canUseCurrentNumber;
            }
        }
        return canSumTo[target];
    }
}
