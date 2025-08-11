package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._0._1._0;

/*

https://leetcode.com/problems/regular-expression-matching

10. Regular Expression Matching
(Hard)

Given an input string s and a pattern p, implement regular expression matching with support for '.' and '*' where:

    '.' Matches any single character.
    '*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

Example 1:

Input: s = "aa", p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".

Example 2:

Input: s = "aa", p = "a*"
Output: true
Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".

Example 3:

Input: s = "ab", p = ".*"
Output: true
Explanation: ".*" means "zero or more (*) of any character (.)".

Constraints:

    1 <= s.length <= 20
    1 <= p.length <= 20
    s contains only lowercase English letters.
    p contains only lowercase English letters, '.', and '*'.
    It is guaranteed for each appearance of the character '*', there will be a previous valid character to match.

 */

class Solution {
    public boolean isMatch(String s, String p) {
        int sLength = s.length();
        int pLength = p.length();
        boolean[][] dp = new boolean[sLength + 1][pLength + 1];
        dp[0][0] = true;
        for (int pPrefixLength = 2; pPrefixLength <= pLength; ++pPrefixLength) {
            if (p.charAt(pPrefixLength - 1) == '*') {
                dp[0][pPrefixLength] = dp[0][pPrefixLength - 2];
            }
        }
        for (int sPrefixLength = 1; sPrefixLength <= sLength; ++sPrefixLength) {
            for (int pPrefixLength = 1; pPrefixLength <= pLength; ++pPrefixLength) {
                char pChar = p.charAt(pPrefixLength - 1);
                if (pChar == '*') {
                    boolean matchWithoutWildcard = dp[sPrefixLength][pPrefixLength - 2];
                    boolean matchWithWildcard = dp[sPrefixLength - 1][pPrefixLength] && isMatchAt(s, sPrefixLength - 1, p, pPrefixLength - 2);
                    dp[sPrefixLength][pPrefixLength] = matchWithoutWildcard || matchWithWildcard;
                } else {
                    boolean matchPrevious = dp[sPrefixLength - 1][pPrefixLength - 1];
                    boolean matchCurrent = isMatchAt(s, sPrefixLength - 1, p, pPrefixLength - 1);
                    dp[sPrefixLength][pPrefixLength] = matchPrevious && matchCurrent;
                }
            }
        }
        return dp[sLength][pLength];
    }

    private boolean isMatchAt(String s, int sIndex, String p, int pIndex) {
        char pChar = p.charAt(pIndex);
        if (pChar == '.') {
            return true;
        }
        char sChar = s.charAt(sIndex);
        return sChar == pChar;
    }
}
