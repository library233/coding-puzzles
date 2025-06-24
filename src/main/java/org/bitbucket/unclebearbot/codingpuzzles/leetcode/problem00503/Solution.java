package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem00503;

/*

https://leetcode.com/problems/next-greater-element-ii

503. Next Greater Element II
(Medium)

Given a circular integer array nums (i.e., the next element of nums[nums.length - 1] is nums[0]), return the next greater number for every element in nums.

The next greater number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, return -1 for this number.

Example 1:

Input: nums = [1,2,1]
Output: [2,-1,2]
Explanation: The first 1's next greater number is 2;
The number 2 can't find next greater number.
The second 1's next greater number needs to search circularly, which is also 2.

Example 2:

Input: nums = [1,2,3,4,3]
Output: [2,3,4,-1,4]

Constraints:

    1 <= nums.length <= 10^4
    -10^9 <= nums[i] <= 10^9

 */

import java.util.Arrays;
import java.util.Stack;
import java.util.stream.IntStream;

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];
        Arrays.fill(result, -1);
        Stack<Integer> unprocessed = new Stack<>();
        IntStream.range(0, length).forEach(i -> updateResultAndPushStack(result, i, nums, unprocessed));
        IntStream.range(0, length).forEach(i -> updateResult(result, i, nums, unprocessed));
        return result;
    }

    private void updateResultAndPushStack(int[] result, int i, int[] nums, Stack<Integer> unprocessed) {
        updateResult(result, i, nums, unprocessed);
        unprocessed.push(i);
    }

    private void updateResult(int[] result, int i, int[] nums, Stack<Integer> unprocessed) {
        int num = nums[i];
        while (!unprocessed.isEmpty()) {
            if (num > nums[unprocessed.peek()]) {
                result[unprocessed.pop()] = num;
            } else {
                break;
            }
        }
    }
}
