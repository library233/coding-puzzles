package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._2._5._8;

/*

https://leetcode.com/problems/add-digits

258. Add Digits
(Easy)

Given an integer num, repeatedly add all its digits until the result has only one digit, and return it.

Example 1:

Input: num = 38
Output: 2
Explanation: The process is
38 --> 3 + 8 --> 11
11 --> 1 + 1 --> 2
Since 2 has only one digit, return it.

Example 2:

Input: num = 0
Output: 0

Constraints:

    0 <= num <= 2^31 - 1

Follow up: Could you do it without any loop/recursion in O(1) runtime?

 */

class Solution {
    public int addDigits(int num) {
        if (num == 0) {
            return 0;
        }
        return (num - 1) % 9 + 1;
    }
}
