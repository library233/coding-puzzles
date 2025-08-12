package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._0._4._4;

/*

https://leetcode.com/problems/wildcard-matching

44. Wildcard Matching
(Hard)

Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*' where:

    '?' Matches any single character.
    '*' Matches any sequence of characters (including the empty sequence).

The matching should cover the entire input string (not partial).

Example 1:

Input: s = "aa", p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".

Example 2:

Input: s = "aa", p = "*"
Output: true
Explanation: '*' matches any sequence.

Example 3:

Input: s = "cb", p = "?a"
Output: false
Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.

Constraints:

    0 <= s.length, p.length <= 2000
    s contains only lowercase English letters.
    p contains only lowercase English letters, '?' or '*'.

 */

class Solution {
    public boolean isMatch(String s, String p) {
        int sLength = s.length();
        int pLength = p.length();
        boolean[][] dp = new boolean[sLength + 1][pLength + 1];
        dp[0][0] = true;
        for (int pPrefixLength = 1; pPrefixLength <= pLength; ++pPrefixLength) {
            if (p.charAt(pPrefixLength - 1) == '*') {
                dp[0][pPrefixLength] = dp[0][pPrefixLength - 1];
            }
        }
        for (int sPrefixLength = 1; sPrefixLength <= sLength; ++sPrefixLength) {
            for (int pPrefixLength = 1; pPrefixLength <= pLength; ++pPrefixLength) {
                char pChar = p.charAt(pPrefixLength - 1);
                if (pChar == '*') {
                    boolean matchWithoutWildcard = dp[sPrefixLength][pPrefixLength - 1];
                    boolean matchWithWildcard = dp[sPrefixLength - 1][pPrefixLength];
                    dp[sPrefixLength][pPrefixLength] = matchWithoutWildcard || matchWithWildcard;
                } else if (pChar == '?' || pChar == s.charAt(sPrefixLength - 1)) {
                    dp[sPrefixLength][pPrefixLength] = dp[sPrefixLength - 1][pPrefixLength - 1];
                }
            }
        }
        return dp[sLength][pLength];
    }
}
