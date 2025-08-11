package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._0._2._9;

/*

https://leetcode.com/problems/divide-two-integers

29. Divide Two Integers
(Medium)

Given two integers dividend and divisor, divide two integers without using multiplication, division, and mod operator.

The integer division should truncate toward zero, which means losing its fractional part. For example, 8.345 would be truncated to 8, and -2.7335 would be truncated to -2.

Return the quotient after dividing dividend by divisor.

Note: Assume we are dealing with an environment that could only store integers within the 32-bit signed integer range: [−231, 231 − 1]. For this problem, if the quotient is strictly greater than 231 - 1, then return 231 - 1, and if the quotient is strictly less than -231, then return -231.

Example 1:

Input: dividend = 10, divisor = 3
Output: 3
Explanation: 10/3 = 3.33333.. which is truncated to 3.

Example 2:

Input: dividend = 7, divisor = -3
Output: -2
Explanation: 7/-3 = -2.33333.. which is truncated to -2.

Constraints:

    -2^31 <= dividend, divisor <= 2^31 - 1
    divisor != 0

 */

class Solution {
    public int divide(int dividend, int divisor) {
        long result = 0;
        long a = dividend;
        long b = divisor;
        boolean negative = (a < 0) ^ (b < 0);
        a = Math.abs(a);
        b = Math.abs(b);
        while (a >= b) {
            long deduction = b;
            long times = 1;
            while (a >= deduction + deduction) {
                deduction += deduction;
                times += times;
            }
            a -= deduction;
            result += times;
        }
        if (negative) {
            result = -result;
        }
        if (result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (result < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int) result;
    }
}
