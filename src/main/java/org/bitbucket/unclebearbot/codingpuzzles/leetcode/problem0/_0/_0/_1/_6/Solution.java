package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._0._1._6;

/*

https://leetcode.com/problems/3sum-closest

16. 3Sum Closest
(Medium)

Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.

Return the sum of the three integers.

You may assume that each input would have exactly one solution.

Example 1:

Input: nums = [-1,2,1,-4], target = 1
Output: 2
Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

Example 2:

Input: nums = [0,0,0], target = 1
Output: 0
Explanation: The sum that is closest to the target is 0. (0 + 0 + 0 = 0).

Constraints:

    3 <= nums.length <= 500
    -1000 <= nums[i] <= 1000
    -10^4 <= target <= 10^4

 */

import java.util.Arrays;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[2];
        for (int index1 = 0; index1 < nums.length - 2; ++index1) {
            if (index1 > 0 && nums[index1] == nums[index1 - 1]) {
                continue;
            }
            int index2 = index1 + 1;
            int index3 = nums.length - 1;
            while (index2 < index3) {
                int sum = nums[index1] + nums[index2] + nums[index3];
                if (sum == target) {
                    return target;
                }
                if (Math.abs(target - sum) < Math.abs(target - result)) {
                    result = sum;
                }
                if (sum < target) {
                    ++index2;
                } else {
                    --index3;
                }
            }
        }
        return result;
    }
}
