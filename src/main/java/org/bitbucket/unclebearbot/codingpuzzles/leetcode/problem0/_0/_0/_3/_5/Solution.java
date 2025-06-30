package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._0._3._5;

/*

https://leetcode.com/problems/search-insert-position

35. Search Insert Position
(Easy)

Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You must write an algorithm with O(log n) runtime complexity.

Example 1:

Input: nums = [1,3,5,6], target = 5
Output: 2

Example 2:

Input: nums = [1,3,5,6], target = 2
Output: 1

Example 3:

Input: nums = [1,3,5,6], target = 7
Output: 4

Constraints:

    1 <= nums.length <= 10^4
    -10^4 <= nums[i] <= 10^4
    nums contains distinct values sorted in ascending order.
    -10^4 <= target <= 10^4

 */

class Solution {
    public int searchInsert(int[] nums, int target) {
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
                return midIndex;
            }
        }
        return leftIndex;
    }
}
