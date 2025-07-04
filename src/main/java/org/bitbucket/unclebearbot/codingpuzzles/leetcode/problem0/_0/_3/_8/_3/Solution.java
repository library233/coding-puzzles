package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._3._8._3;

/*

https://leetcode.com/problems/ransom-note

383. Ransom Note
(Easy)

Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.

Each letter in magazine can only be used once in ransomNote.

Example 1:

Input: ransomNote = "a", magazine = "b"
Output: false

Example 2:

Input: ransomNote = "aa", magazine = "ab"
Output: false

Example 3:

Input: ransomNote = "aa", magazine = "aab"
Output: true

Constraints:

    1 <= ransomNote.length, magazine.length <= 10^5
    ransomNote and magazine consist of lowercase English letters.

 */

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (magazine.length() < ransomNote.length()) {
            return false;
        }
        int[] clipboard = new int[26];
        for (char cut : magazine.toCharArray()) {
            ++clipboard[index(cut)];
        }
        for (char paste : ransomNote.toCharArray()) {
            if (--clipboard[index(paste)] < 0) {
                return false;
            }
        }
        return true;
    }

    private int index(char c) {
        return c - 'a';
    }
}
