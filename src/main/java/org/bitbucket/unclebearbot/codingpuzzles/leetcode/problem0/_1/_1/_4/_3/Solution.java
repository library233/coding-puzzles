package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._1._1._4._3;

/*

https://leetcode.com/problems/longest-common-subsequence

1143. Longest Common Subsequence
(Medium)

Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.

A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.

    For example, "ace" is a subsequence of "abcde".

A common subsequence of two strings is a subsequence that is common to both strings.

Example 1:

Input: text1 = "abcde", text2 = "ace"
Output: 3
Explanation: The longest common subsequence is "ace" and its length is 3.

Example 2:

Input: text1 = "abc", text2 = "abc"
Output: 3
Explanation: The longest common subsequence is "abc" and its length is 3.

Example 3:

Input: text1 = "abc", text2 = "def"
Output: 0
Explanation: There is no such common subsequence, so the result is 0.

Constraints:

    1 <= text1.length, text2.length <= 1000
    text1 and text2 consist of only lowercase English characters.

 */

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for (int prefixLength1 = 1; prefixLength1 <= text1.length(); ++prefixLength1) {
            for (int prefixLength2 = 1; prefixLength2 <= text2.length(); ++prefixLength2) {
                if (text1.charAt(prefixLength1 - 1) == text2.charAt(prefixLength2 - 1)) {
                    dp[prefixLength1][prefixLength2] = dp[prefixLength1 - 1][prefixLength2 - 1] + 1;
                } else {
                    int resultTakingCurrentCharFrom1 = dp[prefixLength1][prefixLength2 - 1];
                    int resultTakingCurrentCharFrom2 = dp[prefixLength1 - 1][prefixLength2];
                    dp[prefixLength1][prefixLength2] = Math.max(resultTakingCurrentCharFrom1, resultTakingCurrentCharFrom2);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }
}
