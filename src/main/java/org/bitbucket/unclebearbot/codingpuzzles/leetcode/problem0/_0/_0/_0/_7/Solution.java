package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._0._0._7;

/*

https://leetcode.com/problems/reverse-integer

7. Reverse Integer
(Medium)

Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.

Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

Example 1:

Input: x = 123
Output: 321

Example 2:

Input: x = -123
Output: -321

Example 3:

Input: x = 120
Output: 21

Constraints:

    -2^31 <= x <= 2^31 - 1

 */

class Solution {
    private static final int MAX_VALUE_PREFIX = Integer.MAX_VALUE / 10;
    private static final int MIN_VALUE_PREFIX = Integer.MIN_VALUE / 10;
    private static final int MAX_VALUE_LAST_DIGIT = Integer.MAX_VALUE % 10;
    private static final int MIN_VALUE_LAST_DIGIT = Integer.MIN_VALUE % 10;

    public int reverse(int x) {
        int result = 0;
        while (x != 0) {
            int lastDigit = x % 10;
            if (result > MAX_VALUE_PREFIX) {
                return 0;
            }
            if (result < MIN_VALUE_PREFIX) {
                return 0;
            }
            if (result == MAX_VALUE_PREFIX && lastDigit > MAX_VALUE_LAST_DIGIT) {
                return 0;
            }
            if (result == MIN_VALUE_PREFIX && lastDigit < MIN_VALUE_LAST_DIGIT) {
                return 0;
            }
            result *= 10;
            result += lastDigit;
            x /= 10;
        }
        return result;
    }
}
