package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._0._6._7;

/*

https://leetcode.com/problems/add-binary

67. Add Binary
(Easy)

Given two binary strings a and b, return their sum as a binary string.

Example 1:

Input: a = "11", b = "1"
Output: "100"

Example 2:

Input: a = "1010", b = "1011"
Output: "10101"

Constraints:

    1 <= a.length, b.length <= 10^4
    a and b consist only of '0' or '1' characters.
    Each string does not contain leading zeros except for the zero itself.

 */

class Solution {
    public String addBinary(String a, String b) {
        StringBuilder reversed = new StringBuilder();
        int aIndex = a.length() - 1;
        int bIndex = b.length() - 1;
        int carry = 0;
        while (aIndex >= 0 || bIndex >= 0 || carry > 0) {
            if (aIndex >= 0) {
                carry += a.charAt(aIndex--) == '0' ? 0 : 1;
            }
            if (bIndex >= 0) {
                carry += b.charAt(bIndex--) == '0' ? 0 : 1;
            }
            reversed.append(carry % 2);
            carry /= 2;
        }
        return reversed.reverse().toString();
    }
}
