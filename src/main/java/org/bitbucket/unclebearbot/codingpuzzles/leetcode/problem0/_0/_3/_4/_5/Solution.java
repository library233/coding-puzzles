package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._3._4._5;

/*

https://leetcode.com/problems/reverse-vowels-of-a-string

345. Reverse Vowels of a String
(Easy)

Given a string s, reverse only all the vowels in the string and return it.

The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.

Example 1:

Input: s = "IceCreAm"

Output: "AceCreIm"

Explanation:

The vowels in s are ['I', 'e', 'e', 'A']. On reversing the vowels, s becomes "AceCreIm".

Example 2:

Input: s = "leetcode"

Output: "leotcede"

Constraints:

    1 <= s.length <= 3 * 10^5
    s consist of printable ASCII characters.

 */

import java.util.HashSet;
import java.util.Set;

class Solution {
    private final Set<Character> vowels;

    Solution() {
        vowels = new HashSet<>();
        for (char c : new char[]{'a', 'e', 'i', 'o', 'u'}) {
            vowels.add(c);
            vowels.add((char) (c - 32));
        }
    }

    public String reverseVowels(String s) {
        if (s.length() < 2) {
            return s;
        }
        char[] chars = s.toCharArray();
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            while (left < right && !isVowel(chars[left])) {
                ++left;
            }
            while (left < right && !isVowel(chars[right])) {
                --right;
            }
            if (left < right) {
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                ++left;
                --right;
            }
        }
        return new String(chars);
    }

    private boolean isVowel(char c) {
        return vowels.contains(c);
    }
}
