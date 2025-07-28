package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._0._0._4;

/*

https://leetcode.com/problems/median-of-two-sorted-arrays

4. Median of Two Sorted Arrays
(Hard)

Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

The overall run time complexity should be O(log (m+n)).

Example 1:

Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.

Example 2:

Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.

Constraints:

    nums1.length == m
    nums2.length == n
    0 <= m <= 1000
    0 <= n <= 1000
    1 <= m + n <= 2000
    -10^6 <= nums1[i], nums2[i] <= 10^6

 */

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            int[] temp = nums2;
            nums2 = nums1;
            nums1 = temp;
        }
        int length1 = nums1.length;
        int length2 = nums2.length;
        int total = length1 + length2;
        int left1 = 0;
        int right1 = length1;
        while (left1 <= right1) {
            int breakpoint1 = (left1 + right1) / 2;
            int valueBeforeBreakpoint1 = breakpoint1 == 0 ? Integer.MIN_VALUE : nums1[breakpoint1 - 1];
            int valueAfterBreakpoint1 = breakpoint1 == length1 ? Integer.MAX_VALUE : nums1[breakpoint1];
            int breakpoint2 = (total + 1) / 2 - breakpoint1;
            int valueBeforeBreakpoint2 = breakpoint2 == 0 ? Integer.MIN_VALUE : nums2[breakpoint2 - 1];
            int valueAfterBreakpoint2 = breakpoint2 == length2 ? Integer.MAX_VALUE : nums2[breakpoint2];
            if (valueBeforeBreakpoint1 > valueAfterBreakpoint2) {
                right1 = breakpoint1 - 1;
                continue;
            }
            if (valueBeforeBreakpoint2 > valueAfterBreakpoint1) {
                left1 = breakpoint1 + 1;
                continue;
            }
            int before = Math.max(valueBeforeBreakpoint1, valueBeforeBreakpoint2);
            if (total % 2 == 1) {
                return before;
            }
            int after = Math.min(valueAfterBreakpoint1, valueAfterBreakpoint2);
            return (before + after) / 2.0;
        }
        throw new IllegalArgumentException();
    }
}
