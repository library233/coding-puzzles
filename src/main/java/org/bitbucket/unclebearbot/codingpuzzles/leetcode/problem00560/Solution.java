package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem00560;

/*

https://leetcode.com/problems/subarray-sum-equals-k

560. Subarray Sum Equals K
(Medium)

Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.

A subarray is a contiguous non-empty sequence of elements within an array.

Example 1:

Input: nums = [1,1,1], k = 2
Output: 2

Example 2:

Input: nums = [1,2,3], k = 3
Output: 2

Constraints:

    1 <= nums.length <= 2 * 10^4
    -1000 <= nums[i] <= 1000
    -10^7 <= k <= 10^7

 */

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int subarraySum(int[] nums, int k) {
        int result = 0;
        Map<Integer, Integer> sumAppearances = new HashMap<>();
        sumAppearances.put(0, 1);
        int sumTillCurrent = 0;
        for (int num : nums) {
            sumTillCurrent += num;
            int expectedComplement = sumTillCurrent - k;
            int expectedComplementAppearances = sumAppearances.getOrDefault(expectedComplement, 0);
            result += expectedComplementAppearances;
            int sumTillCurrentAppearances = sumAppearances.getOrDefault(sumTillCurrent, 0);
            sumAppearances.put(sumTillCurrent, sumTillCurrentAppearances + 1);
        }
        return result;
    }
}
