package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._0._0._5;

/*

https://leetcode.com/problems/longest-palindromic-substring

5. Longest Palindromic Substring
(Medium)

Given a string s, return the longest palindromic substring in s.

Example 1:

Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.

Example 2:

Input: s = "cbbd"
Output: "bb"

Constraints:

    1 <= s.length <= 1000
    s consist of only digits and English letters.

 */

class Solution {
    public String longestPalindrome(String s) {
        int maxLength = 0;
        int beginIndexOfMaxLength = 0;
        int length = s.length();
        for (int i = 0; i < length; ++i) {
            int maxLengthOfCurrentIndex = measure(s, i);
            if (maxLengthOfCurrentIndex > maxLength) {
                maxLength = maxLengthOfCurrentIndex;
                beginIndexOfMaxLength = i - (maxLength - 1) / 2;
            }
        }
        return s.substring(beginIndexOfMaxLength, beginIndexOfMaxLength + maxLength);
    }

    private int measure(String s, int center) {
        return Math.max(measureAroundOdd(s, center), measureAroundEven(s, center));
    }

    private int measureAroundOdd(String s, int center) {
        return measureAround(s, center, center);
    }

    private int measureAroundEven(String s, int center) {
        return measureAround(s, center, center + 1);
    }

    private int measureAround(String s, int left, int right) {
        int length = s.length();
        while (left >= 0 && right < length && s.charAt(left) == s.charAt(right)) {
            --left;
            ++right;
        }
        return right - left - 1;
    }
}
