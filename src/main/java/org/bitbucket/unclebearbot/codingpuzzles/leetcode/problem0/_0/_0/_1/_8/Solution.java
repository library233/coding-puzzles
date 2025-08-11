package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._0._1._8;

/*

https://leetcode.com/problems/4sum

18. 4Sum
(Medium)

Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:

    0 <= a, b, c, d < n
    a, b, c, and d are distinct.
    nums[a] + nums[b] + nums[c] + nums[d] == target

You may return the answer in any order.

Example 1:

Input: nums = [1,0,-1,0,-2,2], target = 0
Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]

Example 2:

Input: nums = [2,2,2,2,2], target = 8
Output: [[2,2,2,2]]

Constraints:

    1 <= nums.length <= 200
    -10^9 <= nums[i] <= 10^9
    -10^9 <= target <= 10^9

 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int index1 = 0; index1 < nums.length - 3; ++index1) {
            if (index1 > 0 && nums[index1] == nums[index1 - 1]) {
                continue;
            }
            for (int index2 = index1 + 1; index2 < nums.length - 2; ++index2) {
                if (index2 > index1 + 1 && nums[index2] == nums[index2 - 1]) {
                    continue;
                }
                int index3 = index2 + 1;
                int index4 = nums.length - 1;
                while (index3 < index4) {
                    long sum = (long) nums[index1] + nums[index2] + nums[index3] + nums[index4];
                    if (sum < target) {
                        ++index3;
                        continue;
                    }
                    if (sum > target) {
                        --index4;
                        continue;
                    }
                    result.add(Arrays.asList(nums[index1], nums[index2], nums[index3], nums[index4]));
                    do {
                        ++index3;
                    } while (index3 < index4 && nums[index3] == nums[index3 - 1]);
                    do {
                        --index4;
                    } while (index3 < index4 && nums[index4] == nums[index4 + 1]);
                }
            }
        }
        return result;
    }
}
