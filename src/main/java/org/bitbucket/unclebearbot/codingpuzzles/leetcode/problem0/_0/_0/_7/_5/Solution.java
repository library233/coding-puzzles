package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._0._7._5;

/*

https://leetcode.com/problems/sort-colors

75. Sort Colors
(Medium)

Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

You must solve this problem without using the library's sort function.

Example 1:

Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]

Example 2:

Input: nums = [2,0,1]
Output: [0,1,2]

Constraints:

    n == nums.length
    1 <= n <= 300
    nums[i] is either 0, 1, or 2.

Follow up: Could you come up with a one-pass algorithm using only constant extra space?

 */

class Solution {
    public void sortColors(int[] nums) {
        int left = 0;
        int current = 0;
        int right = nums.length - 1;
        while (current <= right) {
            switch (nums[current]) {
                case 0:
                    swap(nums, current, left);
                    ++current;
                    ++left;
                    break;
                case 1:
                    ++current;
                    break;
                case 2:
                    swap(nums, current, right);
                    --right;
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        }
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
