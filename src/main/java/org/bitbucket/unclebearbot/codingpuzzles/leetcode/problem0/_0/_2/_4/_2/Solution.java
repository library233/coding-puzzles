package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._2._4._2;

/*

https://leetcode.com/problems/valid-anagram

242. Valid Anagram
(Easy)

Given two strings s and t, return true if t is an anagram of s, and false otherwise.

Example 1:

Input: s = "anagram", t = "nagaram"

Output: true

Example 2:

Input: s = "rat", t = "car"

Output: false

Constraints:

    1 <= s.length, t.length <= 5 * 10^4
    s and t consist of lowercase English letters.

Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?

 */

import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.codePointCount(0, s.length()) != t.codePointCount(0, t.length())) {
            return false;
        }
        Map<Integer, Integer> unicodeAppearances = new HashMap<>();
        for (int unicode : s.codePoints().toArray()) {
            unicodeAppearances.put(unicode, unicodeAppearances.getOrDefault(unicode, 0) + 1);
        }
        for (int unicode : t.codePoints().toArray()) {
            int appearances = unicodeAppearances.getOrDefault(unicode, 0);
            if (appearances == 0) {
                return false;
            }
            unicodeAppearances.put(unicode, appearances - 1);
        }
        return true;
    }
}
