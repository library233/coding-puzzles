package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._4._1._5;

/*

https://leetcode.com/problems/add-strings

415. Add Strings
(Easy)

Given two non-negative integers, num1 and num2 represented as string, return the sum of num1 and num2 as a string.

You must solve the problem without using any built-in library for handling large integers (such as BigInteger). You must also not convert the inputs to integers directly.

Example 1:

Input: num1 = "11", num2 = "123"
Output: "134"

Example 2:

Input: num1 = "456", num2 = "77"
Output: "533"

Example 3:

Input: num1 = "0", num2 = "0"
Output: "0"

Constraints:

    1 <= num1.length, num2.length <= 10^4
    num1 and num2 consist of only digits.
    num1 and num2 don't have any leading zeros except for the zero itself.

 */

class Solution {
    public String addStrings(String num1, String num2) {
        int length1 = num1.length();
        int length2 = num2.length();
        int i1 = length1 - 1;
        int i2 = length2 - 1;
        int resultMaxLength = Math.max(length1, length2) + 1;
        char[] result = new char[resultMaxLength];
        int digitSum = 0;
        for (int i = resultMaxLength - 1; i > 0; --i) {
            if (i1 >= 0) {
                digitSum += num1.charAt(i1--) - '0';
            }
            if (i2 >= 0) {
                digitSum += num2.charAt(i2--) - '0';
            }
            result[i] = (char) (digitSum % 10 + '0');
            digitSum /= 10;
        }
        if (digitSum > 0) {
            result[0] = '1';
            return new String(result);
        }
        return new String(result, 1, resultMaxLength - 1);
    }
}
