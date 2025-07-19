package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._1._2._5;

/*

https://leetcode.com/problems/valid-palindrome

125. Valid Palindrome
(Easy)

A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.

Example 1:

Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.

Example 2:

Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.

Example 3:

Input: s = " "
Output: true
Explanation: s is an empty string "" after removing non-alphanumeric characters.
Since an empty string reads the same forward and backward, it is a palindrome.

Constraints:

    1 <= s.length <= 2 * 10^5
    s consists only of printable ASCII characters.

 */

import java.util.Objects;

class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left <= right) {
            while (left <= right && !isAlphanumeric(s.charAt(left))) {
                ++left;
            }
            while (left <= right && !isAlphanumeric(s.charAt(right))) {
                --right;
            }
            if (left <= right && !isSameIgnoringCase(s.charAt(left), s.charAt(right))) {
                return false;
            }
            ++left;
            --right;
        }
        return true;
    }

    private boolean isAlphanumeric(char c) {
        if (c >= '0' && c <= '9') {
            return true;
        }
        if (c >= 'a' && c <= 'z') {
            return true;
        }
        if (c >= 'A' && c <= 'Z') {
            return true;
        }
        return false;
    }

    private boolean isSameIgnoringCase(char a, char b) {
        if (a == b) {
            return true;
        }
        return Objects.equals(String.valueOf(a).toUpperCase(), String.valueOf(b).toUpperCase());
    }
}
