package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._2._0._5;

/*

https://leetcode.com/problems/isomorphic-strings

205. Isomorphic Strings
(Medium)

Given two strings s and t, determine if they are isomorphic.

Two strings s and t are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.

Example 1:

Input: s = "egg", t = "add"

Output: true

Explanation:

The strings s and t can be made identical by:

    Mapping 'e' to 'a'.
    Mapping 'g' to 'd'.

Example 2:

Input: s = "foo", t = "bar"

Output: false

Explanation:

The strings s and t can not be made identical as 'o' needs to be mapped to both 'a' and 'r'.

Example 3:

Input: s = "paper", t = "title"

Output: true

Constraints:

    1 <= s.length <= 5 * 10^4
    t.length == s.length
    s and t consist of any valid ascii character.

 */

import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> sDict = new HashMap<>();
        Map<Character, Character> tDict = new HashMap<>();
        for (int i = 0; i < s.length(); ++i) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            if (!sDict.containsKey(sChar) && !tDict.containsKey(tChar)) {
                sDict.put(sChar, tChar);
                tDict.put(tChar, sChar);
                continue;
            }
            if (sDict.containsKey(sChar) && tDict.containsKey(tChar)) {
                if (sDict.get(sChar) != tChar) {
                    return false;
                }
                if (tDict.get(tChar) != sChar) {
                    return false;
                }
                continue;
            }
            return false;
        }
        return true;
    }
}
