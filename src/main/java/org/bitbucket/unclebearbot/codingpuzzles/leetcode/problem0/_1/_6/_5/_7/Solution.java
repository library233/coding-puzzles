package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._1._6._5._7;

/*

https://leetcode.com/problems/determine-if-two-strings-are-close

1657. Determine if Two Strings Are Close
(Medium)

Two strings are considered close if you can attain one from the other using the following operations:

    Operation 1: Swap any two existing characters.
        For example, abcde -> aecdb
    Operation 2: Transform every occurrence of one existing character into another existing character, and do the same with the other character.
        For example, aacabb -> bbcbaa (all a's turn into b's, and all b's turn into a's)

You can use the operations on either string as many times as necessary.

Given two strings, word1 and word2, return true if word1 and word2 are close, and false otherwise.

Example 1:

Input: word1 = "abc", word2 = "bca"
Output: true
Explanation: You can attain word2 from word1 in 2 operations.
Apply Operation 1: "abc" -> "acb"
Apply Operation 1: "acb" -> "bca"

Example 2:

Input: word1 = "a", word2 = "aa"
Output: false
Explanation: It is impossible to attain word2 from word1, or vice versa, in any number of operations.

Example 3:

Input: word1 = "cabbba", word2 = "abbccc"
Output: true
Explanation: You can attain word2 from word1 in 3 operations.
Apply Operation 1: "cabbba" -> "caabbb"
Apply Operation 2: "caabbb" -> "baaccc"
Apply Operation 2: "baaccc" -> "abbccc"

Constraints:

    1 <= word1.length, word2.length <= 10^5
    word1 and word2 contain only lowercase English letters.

 */

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

class Solution {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        Map<Character, Integer> charsToCounts1 = buildCharFreq(word1);
        Map<Character, Integer> charsToCounts2 = buildCharFreq(word2);
        if (!Objects.equals(charsToCounts1.keySet(), charsToCounts2.keySet())) {
            return false;
        }
        List<Integer> sortedCounts1 = charsToCounts1.values().stream().sorted().collect(Collectors.toList());
        List<Integer> sortedCounts2 = charsToCounts2.values().stream().sorted().collect(Collectors.toList());
        return Objects.equals(sortedCounts1, sortedCounts2);
    }

    private Map<Character, Integer> buildCharFreq(String word) {
        Map<Character, Integer> result = new HashMap<>();
        for (char c : word.toCharArray()) {
            result.put(c, result.getOrDefault(c, 0) + 1);
        }
        return result;
    }
}
