package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._0._4._3;

/*

https://leetcode.com/problems/multiply-strings

43. Multiply Strings
(Medium)

Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.

Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.

Example 1:

Input: num1 = "2", num2 = "3"
Output: "6"

Example 2:

Input: num1 = "123", num2 = "456"
Output: "56088"

Constraints:

    1 <= num1.length, num2.length <= 200
    num1 and num2 consist of digits only.
    Both num1 and num2 do not contain any leading zero, except the number 0 itself.

 */

class Solution {
    public String multiply(String num1, String num2) {
        int length1 = num1.length();
        int length2 = num2.length();
        int[] product = new int[length1 + length2];
        for (int index1 = length1 - 1; index1 >= 0; --index1) {
            for (int index2 = length2 - 1; index2 >= 0; --index2) {
                int digit1 = (num1.charAt(index1) - '0');
                int digit2 = (num2.charAt(index2) - '0');
                int multiplied = digit1 * digit2;
                int carry = index1 + index2;
                int unit = carry + 1;
                multiplied += product[unit];
                product[carry] += multiplied / 10;
                product[unit] = multiplied % 10;
            }
        }
        int i = 0;
        while (i < product.length) {
            if (product[i] != 0) {
                break;
            }
            ++i;
        }
        if (i == product.length) {
            return "0";
        }
        StringBuilder result = new StringBuilder();
        while (i < product.length) {
            result.append(product[i]);
            ++i;
        }
        return result.toString();
    }
}
