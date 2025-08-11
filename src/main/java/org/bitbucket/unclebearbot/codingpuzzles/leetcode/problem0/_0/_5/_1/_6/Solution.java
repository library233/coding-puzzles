package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._5._1._6;

/*

https://leetcode.com/problems/longest-palindromic-subsequence

516. Longest Palindromic Subsequence
(Medium)

Given a string s, find the longest palindromic subsequence's length in s.

A subsequence is a sequence that can be derived from another sequence by deleting some or no elements without changing the order of the remaining elements.

Example 1:

Input: s = "bbbab"
Output: 4
Explanation: One possible longest palindromic subsequence is "bbbb".

Example 2:

Input: s = "cbbd"
Output: 2
Explanation: One possible longest palindromic subsequence is "bb".

Constraints:

    1 <= s.length <= 1000
    s consists only of lowercase English letters.

 */

class Solution {
    public int longestPalindromeSubseq(String s) {
        int length = s.length();
        int[][] dp = new int[length][length];
        for (int left = length - 1; left >= 0; --left) {
            dp[left][left] = 1;
            char leftChar = s.charAt(left);
            for (int right = left + 1; right < length; ++right) {
                char rightChar = s.charAt(right);
                if (leftChar == rightChar) {
                    dp[left][right] = dp[left + 1][right - 1] + 2;
                } else {
                    dp[left][right] = Math.max(dp[left + 1][right], dp[left][right - 1]);
                }
            }
        }
        return dp[0][length - 1];
    }
}
