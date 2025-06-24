package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem00438;

/*

https://leetcode.com/problems/find-all-anagrams-in-a-string

438. Find All Anagrams in a String
(Medium)

Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.

Example 1:

Input: s = "cbaebabacd", p = "abc"
Output: [0,6]
Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".

Example 2:

Input: s = "abab", p = "ab"
Output: [0,1,2]
Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".

Constraints:

    1 <= s.length, p.length <= 3 * 10^4
    s and p consist of lowercase English letters.

 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int sourceLength = s.length();
        int targetLength = p.length();
        if (sourceLength < targetLength) {
            return Collections.emptyList();
        }
        int[] sourceAppearances = new int[26];
        int[] targetAppearances = new int[26];
        for (int i = 0; i < targetLength; ++i) {
            ++sourceAppearances[index(s.charAt(i))];
            ++targetAppearances[index(p.charAt(i))];
        }
        long matching = IntStream.range(0, 26).filter(i -> sourceAppearances[i] == targetAppearances[i]).count();
        List<Integer> result = new ArrayList<>();
        if (matching == 26) {
            result.add(0);
        }
        for (int i = targetLength; i < sourceLength; ++i) {
            int toAdd = index(s.charAt(i));
            int toRemove = index(s.charAt(i - targetLength));
            boolean equalBeforeAdd = isAppearanceEqual(sourceAppearances, targetAppearances, toAdd);
            ++sourceAppearances[toAdd];
            boolean equalAfterAdd = isAppearanceEqual(sourceAppearances, targetAppearances, toAdd);
            if (equalBeforeAdd && !equalAfterAdd) {
                --matching;
            } else if (!equalBeforeAdd && equalAfterAdd) {
                ++matching;
            }
            boolean equalBeforeRemove = isAppearanceEqual(sourceAppearances, targetAppearances, toRemove);
            --sourceAppearances[toRemove];
            boolean equalAfterRemove = isAppearanceEqual(sourceAppearances, targetAppearances, toRemove);
            if (equalBeforeRemove && !equalAfterRemove) {
                --matching;
            } else if (!equalBeforeRemove && equalAfterRemove) {
                ++matching;
            }
            if (matching == 26) {
                result.add(i + 1 - targetLength);
            }
        }
        return result;
    }

    private int index(char c) {
        return c - 'a';
    }

    private boolean isAppearanceEqual(int[] sourceAppearances, int[] targetAppearances, int index) {
        return sourceAppearances[index] == targetAppearances[index];
    }
}
