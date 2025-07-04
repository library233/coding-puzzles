package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._0._1._5;

/*

https://leetcode.com/problems/3sum

15. 3Sum
(Medium)

Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.

Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation:
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.

Example 2:

Input: nums = [0,1,1]
Output: []
Explanation: The only possible triplet does not sum up to 0.

Example 3:

Input: nums = [0,0,0]
Output: [[0,0,0]]
Explanation: The only possible triplet sums up to 0.

Constraints:

    3 <= nums.length <= 3000
    -10^5 <= nums[i] <= 10^5

 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int length = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < length - 2; ++i) {
            int a = nums[i];
            if (i > 0 && a == nums[i - 1]) {
                continue;
            }
            int j = i + 1;
            int k = length - 1;
            while (j < k) {
                int b = nums[j];
                int c = nums[k];
                int sum = a + b + c;
                if (sum < 0) {
                    ++j;
                } else if (sum > 0) {
                    --k;
                } else {
                    result.add(Arrays.asList(a, b, c));
                    do {
                        ++j;
                    }
                    while (j < k && nums[j] == nums[j - 1]);
                    do {
                        --k;
                    }
                    while (j < k && nums[k] == nums[k + 1]);
                }
            }
        }
        return result;
    }
}
