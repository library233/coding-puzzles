package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._0._3._0;

/*

https://leetcode.com/problems/substring-with-concatenation-of-all-words

30. Substring with Concatenation of All Words
(Hard)

You are given a string s and an array of strings words. All the strings of words are of the same length.

A concatenated string is a string that exactly contains all the strings of any permutation of words concatenated.

    For example, if words = ["ab","cd","ef"], then "abcdef", "abefcd", "cdabef", "cdefab", "efabcd", and "efcdab" are all concatenated strings. "acdbef" is not a concatenated string because it is not the concatenation of any permutation of words.

Return an array of the starting indices of all the concatenated substrings in s. You can return the answer in any order.

Example 1:

Input: s = "barfoothefoobarman", words = ["foo","bar"]

Output: [0,9]

Explanation:

The substring starting at 0 is "barfoo". It is the concatenation of ["bar","foo"] which is a permutation of words.
The substring starting at 9 is "foobar". It is the concatenation of ["foo","bar"] which is a permutation of words.

Example 2:

Input: s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]

Output: []

Explanation:

There is no concatenated substring.

Example 3:

Input: s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]

Output: [6,9,12]

Explanation:

The substring starting at 6 is "foobarthe". It is the concatenation of ["foo","bar","the"].
The substring starting at 9 is "barthefoo". It is the concatenation of ["bar","the","foo"].
The substring starting at 12 is "thefoobar". It is the concatenation of ["the","foo","bar"].

Constraints:

    1 <= s.length <= 10^4
    1 <= words.length <= 5000
    1 <= words[i].length <= 30
    s and words[i] consist of lowercase English letters.

 */

import java.util.*;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        int stringLength = s.length();
        int wordCount = words.length;
        int wordLength = words[0].length();
        int substringLength = wordCount * wordLength;
        if (stringLength < substringLength) {
            return Collections.emptyList();
        }
        List<Integer> result = new ArrayList<>();
        Map<String, Integer> freq = new HashMap<>();
        for (String word : words) {
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }
        for (int offset = 0; offset < wordLength; ++offset) {
            int left = offset;
            int right = offset;
            Map<String, Integer> collected = new HashMap<>();
            while (right + wordLength <= stringLength) {
                String word = s.substring(right, right + wordLength);
                right += wordLength;
                if (!freq.containsKey(word)) {
                    collected.clear();
                    left = right;
                    continue;
                }
                collected.put(word, collected.getOrDefault(word, 0) + 1);
                while (collected.get(word) > freq.get(word)) {
                    String leftWord = s.substring(left, left + wordLength);
                    collected.put(leftWord, collected.get(leftWord) - 1);
                    left += wordLength;
                }
                if (collected.values().stream().reduce(Integer::sum).orElse(0) == wordCount) {
                    result.add(left);
                    String leftWord = s.substring(left, left + wordLength);
                    collected.put(leftWord, collected.get(leftWord) - 1);
                    left += wordLength;
                }
            }
        }
        return result;
    }
}
