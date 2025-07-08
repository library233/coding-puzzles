package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._8._6._2;

/*

https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k

862. Shortest Subarray with Sum at Least K
(Hard)

Given an integer array nums and an integer k, return the length of the shortest non-empty subarray of nums with a sum of at least k. If there is no such subarray, return -1.

A subarray is a contiguous part of an array.

Example 1:

Input: nums = [1], k = 1
Output: 1

Example 2:

Input: nums = [1,2], k = 4
Output: -1

Example 3:

Input: nums = [2,-1,2], k = 3
Output: 3

Constraints:

    1 <= nums.length <= 10^5
    -10^5 <= nums[i] <= 10^5
    1 <= k <= 10^9

 */

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.stream.IntStream;

class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int minLength = Integer.MAX_VALUE;
        long[] prefixSum = new long[nums.length + 1];
        IntStream.range(0, nums.length).forEach(i -> prefixSum[i + 1] = prefixSum[i] + nums[i]);
        Deque<Integer> unprocessed = new ArrayDeque<>();
        for (int i = 0; i <= nums.length; ++i) {
            while (!unprocessed.isEmpty()) {
                long sum = prefixSum[i] - prefixSum[unprocessed.peekFirst()];
                if (sum >= k) {
                    int length = i - unprocessed.pollFirst();
                    if (length < minLength) {
                        minLength = length;
                    }
                } else {
                    break;
                }
            }
            while (!unprocessed.isEmpty()) {
                long previousPrefixSumInLargerLength = prefixSum[unprocessed.peekLast()];
                boolean useful = previousPrefixSumInLargerLength < prefixSum[i];
                if (!useful) {
                    unprocessed.pollLast();
                } else {
                    break;
                }
            }
            unprocessed.offerLast(i);
        }
        return minLength == Integer.MAX_VALUE ? -1 : minLength;
    }
}
