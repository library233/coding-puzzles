package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._1._6._7._9;

/*

https://leetcode.com/problems/max-number-of-k-sum-pairs

1679. Max Number of K-Sum Pairs
(Medium)

You are given an integer array nums and an integer k.

In one operation, you can pick two numbers from the array whose sum equals k and remove them from the array.

Return the maximum number of operations you can perform on the array.

Example 1:

Input: nums = [1,2,3,4], k = 5
Output: 2
Explanation: Starting with nums = [1,2,3,4]:
- Remove numbers 1 and 4, then nums = [2,3]
- Remove numbers 2 and 3, then nums = []
There are no more pairs that sum up to 5, hence a total of 2 operations.

Example 2:

Input: nums = [3,1,3,4,3], k = 6
Output: 1
Explanation: Starting with nums = [3,1,3,4,3]:
- Remove the first two 3's, then nums = [1,4,3]
There are no more pairs that sum up to 6, hence a total of 1 operation.

Constraints:

    1 <= nums.length <= 10^5
    1 <= nums[i] <= 10^9
    1 <= k <= 10^9

 */

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> stock = new HashMap<>();
        int result = 0;
        for (int num : nums) {
            int complement = k - num;
            int complementCount = stock.getOrDefault(complement, 0);
            if (complementCount > 0) {
                ++result;
                stock.put(complement, complementCount - 1);
            } else {
                int numCount = stock.getOrDefault(num, 0);
                stock.put(num, numCount + 1);
            }
        }
        return result;
    }
}
