package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._1._2._8;

/*

https://leetcode.com/problems/longest-consecutive-sequence

128. Longest Consecutive Sequence
(Medium)

Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.

Example 1:

Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.

Example 2:

Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9

Example 3:

Input: nums = [1,0,1,2]
Output: 3

Constraints:

    0 <= nums.length <= 10^5
    -10^9 <= nums[i] <= 10^9

 */

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numbers = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        int maxLength = 0;
        for (int number : numbers) {
            if (!numbers.contains(number - 1)) {
                int length = 1;
                while (numbers.contains(++number)) {
                    ++length;
                }
                maxLength = Math.max(maxLength, length);
            }
        }
        return maxLength;
    }
}
