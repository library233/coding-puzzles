package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem00076;

/*

https://leetcode.com/problems/minimum-window-substring

76. Minimum Window Substring
(Hard)

Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".

The testcases will be generated such that the answer is unique.

Example 1:

Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.

Example 2:

Input: s = "a", t = "a"
Output: "a"
Explanation: The entire string s is the minimum window.

Example 3:

Input: s = "a", t = "aa"
Output: ""
Explanation: Both 'a's from t must be included in the window.
Since the largest window of s only has one 'a', return empty string.

Constraints:

    m == s.length
    n == t.length
    1 <= m, n <= 10^5
    s and t consist of uppercase and lowercase English letters.

Follow up: Could you find an algorithm that runs in O(m + n) time?

 */

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class Solution {
    public String minWindow(String s, String t) {
        int sourceLength = s.length();
        int targetLength = t.length();
        if (sourceLength < targetLength) {
            return "";
        }
        Map<Character, Integer> targetCharAppearances = new HashMap<>();
        for (char c : t.toCharArray()) {
            accumulate(targetCharAppearances, c);
        }
        int targetCharUniqueCount = targetCharAppearances.size();
        Map<Character, Integer> sourceCharAppearances = new HashMap<>();
        int completelyCollectedCharUniqueCount = 0;
        int resultLength = Integer.MAX_VALUE;
        int resultBeginIndex = 0;
        int leftIndex = 0;
        int rightIndex = 0;
        while (rightIndex < sourceLength) {
            char rightChar = s.charAt(rightIndex);
            accumulate(sourceCharAppearances, rightChar);
            if (targetCharAppearances.containsKey(rightChar) && isValueEqual(sourceCharAppearances, targetCharAppearances, rightChar)) {
                ++completelyCollectedCharUniqueCount;
            }
            while (completelyCollectedCharUniqueCount == targetCharUniqueCount && leftIndex <= rightIndex) {
                char leftChar = s.charAt(leftIndex);
                int length = rightIndex - leftIndex + 1;
                if (length < resultLength) {
                    resultLength = length;
                    resultBeginIndex = leftIndex;
                }
                deduct(sourceCharAppearances, leftChar);
                if (targetCharAppearances.containsKey(leftChar) && isValueLess(sourceCharAppearances, targetCharAppearances, leftChar)) {
                    --completelyCollectedCharUniqueCount;
                }
                ++leftIndex;
            }
            ++rightIndex;
        }
        if (resultLength == Integer.MAX_VALUE) {
            return "";
        }
        return s.substring(resultBeginIndex, resultBeginIndex + resultLength);
    }

    private void accumulate(Map<Character, Integer> chars, char c) {
        adjustValue(chars, c, 1);
    }

    private void deduct(Map<Character, Integer> chars, char c) {
        adjustValue(chars, c, -1);
    }

    private void adjustValue(Map<Character, Integer> map, char key, int delta) {
        map.put(key, map.getOrDefault(key, 0) + delta);
    }

    private boolean isValueEqual(Map<Character, Integer> a, Map<Character, Integer> b, char key) {
        return Objects.equals(a.get(key), b.get(key));
    }

    private boolean isValueLess(Map<Character, Integer> a, Map<Character, Integer> b, char key) {
        return a.get(key) < b.get(key);
    }
}
