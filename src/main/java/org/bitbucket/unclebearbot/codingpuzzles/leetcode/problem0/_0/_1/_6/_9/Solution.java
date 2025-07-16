package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._1._6._9;

/*

https://leetcode.com/problems/majority-element

169. Majority Element
(Easy)

Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

Example 1:

Input: nums = [3,2,3]
Output: 3

Example 2:

Input: nums = [2,2,1,1,1,2,2]
Output: 2

Constraints:

    n == nums.length
    1 <= n <= 5 * 10^4
    -10^9 <= nums[i] <= 10^9

Follow-up: Could you solve the problem in linear time and in O(1) space?

 */

class Solution {
    public int majorityElement(int[] nums) {
        int last = Integer.MIN_VALUE;
        int count = 0;
        for (int num : nums) {
            if (count == 0) {
                last = num;
                count = 1;
            } else if (num == last) {
                ++count;
            } else {
                --count;
            }
        }
        return last;
    }
}
