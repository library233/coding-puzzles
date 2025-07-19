package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._0._2._8;

/*

https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string

28. Find the Index of the First Occurrence in a String
(Easy)

Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Example 1:

Input: haystack = "sadbutsad", needle = "sad"
Output: 0
Explanation: "sad" occurs at index 0 and 6.
The first occurrence is at index 0, so we return 0.

Example 2:

Input: haystack = "leetcode", needle = "leeto"
Output: -1
Explanation: "leeto" did not occur in "leetcode", so we return -1.

Constraints:

    1 <= haystack.length, needle.length <= 10^4
    haystack and needle consist of only lowercase English characters.

 */

class Solution {
    public int strStr(String haystack, String needle) {
        for (int i = 0; i <= haystack.length() - needle.length(); ++i) {
            int j = 0;
            while (j < needle.length()) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
                ++j;
            }
            if (j == needle.length()) {
                return i;
            }
        }
        return -1;
    }
}
