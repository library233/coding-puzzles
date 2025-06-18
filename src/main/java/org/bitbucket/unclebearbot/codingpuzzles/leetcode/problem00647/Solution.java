package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem00647;

/*

https://leetcode.com/problems/palindromic-substrings

647. Palindromic Substrings
(Medium)

Given a string s, return the number of palindromic substrings in it.

A string is a palindrome when it reads the same backward as forward.

A substring is a contiguous sequence of characters within the string.

Example 1:

Input: s = "abc"
Output: 3
Explanation: Three palindromic strings: "a", "b", "c".

Example 2:

Input: s = "aaa"
Output: 6
Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".

Constraints:

    1 <= s.length <= 1000
    s consists of lowercase English letters.

 */

import java.util.stream.IntStream;

class Solution {
    public int countSubstrings(String s) {
        return IntStream.range(0, s.length()).map(i -> count(s, i)).sum();
    }

    private int count(String s, int center) {
        return countAroundOdd(s, center) + countAroundEven(s, center);
    }

    private int countAroundOdd(String s, int center) {
        return countAround(s, center, center);
    }

    private int countAroundEven(String s, int center) {
        return countAround(s, center, center + 1);
    }

    private int countAround(String s, int left, int right) {
        int length = s.length();
        int count = 0;
        while (left >= 0 && right < length && s.charAt(left) == s.charAt(right)) {
            ++count;
            --left;
            ++right;
        }
        return count;
    }
}
