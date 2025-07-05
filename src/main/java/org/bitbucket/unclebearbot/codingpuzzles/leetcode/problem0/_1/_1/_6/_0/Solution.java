package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._1._1._6._0;

/*

https://leetcode.com/problems/find-words-that-can-be-formed-by-characters

1160. Find Words That Can Be Formed by Characters
(Easy)

You are given an array of strings words and a string chars.

A string is good if it can be formed by characters from chars (each character can only be used once for each word in words).

Return the sum of lengths of all good strings in words.

Example 1:

Input: words = ["cat","bt","hat","tree"], chars = "atach"
Output: 6
Explanation: The strings that can be formed are "cat" and "hat" so the answer is 3 + 3 = 6.

Example 2:

Input: words = ["hello","world","leetcode"], chars = "welldonehoneyr"
Output: 10
Explanation: The strings that can be formed are "hello" and "world" so the answer is 5 + 5 = 10.

Constraints:

    1 <= words.length <= 1000
    1 <= words[i].length, chars.length <= 100
    words[i] and chars consist of lowercase English letters.

 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int countCharacters(String[] words, String chars) {
        Map<Character, Integer> clipboard = buildCharFreq(chars);
        return Arrays.stream(words).filter(word -> isEnough(clipboard, buildCharFreq(word))).mapToInt(String::length).sum();
    }

    private Map<Character, Integer> buildCharFreq(String string) {
        Map<Character, Integer> result = new HashMap<>();
        for (char c : string.toCharArray()) {
            result.put(c, result.getOrDefault(c, 0) + 1);
        }
        return result;
    }

    private boolean isEnough(Map<Character, Integer> clipboard, Map<Character, Integer> requirement) {
        return requirement.entrySet().stream().allMatch(charFreq -> clipboard.getOrDefault(charFreq.getKey(), 0) >= charFreq.getValue());
    }
}
