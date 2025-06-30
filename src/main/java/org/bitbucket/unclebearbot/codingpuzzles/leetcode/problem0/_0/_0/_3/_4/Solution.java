package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._0._3._4;

/*

https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array

34. Find First and Last Position of Element in Sorted Array
(Medium)

Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]

Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]

Example 3:

Input: nums = [], target = 0
Output: [-1,-1]

Constraints:

    0 <= nums.length <= 10^5
    -10^9 <= nums[i] <= 10^9
    nums is a non-decreasing array.
    -10^9 <= target <= 10^9

 */

class Solution {
    public int[] searchRange(int[] nums, int target) {
        return new int[]{findBeginIndex(nums, target), findEndIndex(nums, target)};
    }

    private int findBeginIndex(int[] nums, int target) {
        return findBoundaryIndex(nums, target, true);
    }

    private int findEndIndex(int[] nums, int target) {
        return findBoundaryIndex(nums, target, false);
    }

    private int findBoundaryIndex(int[] nums, int target, boolean findingBeginIndex) {
        int result = -1;
        int leftIndex = 0;
        int rightIndex = nums.length - 1;
        while (leftIndex <= rightIndex) {
            int midIndex = (leftIndex + rightIndex) / 2;
            int num = nums[midIndex];
            if (num < target) {
                leftIndex = midIndex + 1;
            } else if (num > target) {
                rightIndex = midIndex - 1;
            } else {
                result = midIndex;
                if (findingBeginIndex) {
                    rightIndex = midIndex - 1;
                } else {
                    leftIndex = midIndex + 1;
                }
            }
        }
        return result;
    }
}
