package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._1._0._7._1;

/*

https://leetcode.com/problems/greatest-common-divisor-of-strings

1071. Greatest Common Divisor of Strings
(Easy)

For two strings s and t, we say "t divides s" if and only if s = t + t + t + ... + t + t (i.e., t is concatenated with itself one or more times).

Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2.

Example 1:

Input: str1 = "ABCABC", str2 = "ABC"
Output: "ABC"

Example 2:

Input: str1 = "ABABAB", str2 = "ABAB"
Output: "AB"

Example 3:

Input: str1 = "LEET", str2 = "CODE"
Output: ""

Constraints:

    1 <= str1.length, str2.length <= 1000
    str1 and str2 consist of English uppercase letters.

 */

import java.util.Objects;

class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if (!Objects.equals(str1 + str2, str2 + str1)) {
            return "";
        }
        int gcdLength = greatestCommonDivisor(str1.length(), str2.length());
        return str1.substring(0, gcdLength);
    }

    private int greatestCommonDivisor(int a, int b) {
        while (a != 0) {
            int mod = b % a;
            b = a;
            a = mod;
        }
        return b;
    }
}
