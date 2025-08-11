package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._1._1._5;

/*

https://leetcode.com/problems/distinct-subsequences

115. Distinct Subsequences
(Hard)

Given two strings s and t, return the number of distinct subsequences of s which equals t.

The test cases are generated so that the answer fits on a 32-bit signed integer.

Example 1:

Input: s = "rabbbit", t = "rabbit"
Output: 3
Explanation:
As shown below, there are 3 ways you can generate "rabbit" from s.
rabbbit
rabbbit
rabbbit

Example 2:

Input: s = "babgbag", t = "bag"
Output: 5
Explanation:
As shown below, there are 5 ways you can generate "bag" from s.
babgbag
babgbag
babgbag
babgbag
babgbag

Constraints:

    1 <= s.length, t.length <= 1000
    s and t consist of English letters.

 */

import java.util.stream.IntStream;

class Solution {
    public int numDistinct(String s, String t) {
        int sLength = s.length();
        int tLength = t.length();
        int[][] dp = new int[sLength + 1][tLength + 1];
        IntStream.rangeClosed(0, sLength).forEach(sPrefixLength -> dp[sPrefixLength][0] = 1);
        for (int sPrefixLength = 1; sPrefixLength <= sLength; ++sPrefixLength) {
            for (int tPrefixLength = 1; tPrefixLength <= tLength; ++tPrefixLength) {
                dp[sPrefixLength][tPrefixLength] = dp[sPrefixLength - 1][tPrefixLength];
                if (s.charAt(sPrefixLength - 1) == t.charAt(tPrefixLength - 1)) {
                    dp[sPrefixLength][tPrefixLength] += dp[sPrefixLength - 1][tPrefixLength - 1];
                }
            }
        }
        return dp[sLength][tLength];
    }
}
