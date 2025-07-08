package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._1._4._9._3;

/*

https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element

1493. Longest Subarray of 1's After Deleting One Element
(Medium)

Given a binary array nums, you should delete one element from it.

Return the size of the longest non-empty subarray containing only 1's in the resulting array. Return 0 if there is no such subarray.

Example 1:

Input: nums = [1,1,0,1]
Output: 3
Explanation: After deleting the number in position 2, [1,1,1] contains 3 numbers with value of 1's.

Example 2:

Input: nums = [0,1,1,1,0,1,1,0,1]
Output: 5
Explanation: After deleting the number in position 4, [0,1,1,1,1,1,0,1] longest subarray with value of 1's is [1,1,1,1,1].

Example 3:

Input: nums = [1,1,1]
Output: 2
Explanation: You must delete one element.

Constraints:

    1 <= nums.length <= 10^5
    nums[i] is either 0 or 1.

 */

class Solution {
    public int longestSubarray(int[] nums) {
        int maxLengthAfterDeletion = 0;
        int deleted = 0;
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            if (nums[right] == 0) {
                ++deleted;
            }
            while (deleted > 1) {
                if (nums[left] == 0) {
                    --deleted;
                }
                ++left;
            }
            int length = right - left + 1;
            int lengthAfterDeletion = length - 1;
            if (lengthAfterDeletion > maxLengthAfterDeletion) {
                maxLengthAfterDeletion = lengthAfterDeletion;
            }
            ++right;
        }
        return maxLengthAfterDeletion;
    }
}
