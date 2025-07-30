package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._1._3._1;

/*

https://leetcode.com/problems/palindrome-partitioning

131. Palindrome Partitioning
(Medium)

Given a string s, partition s such that every of the partition is a palindrome. Return all possible palindrome partitioning of s.

Example 1:

Input: s = "aab"
Output: [["a","a","b"],["aa","b"]]

Example 2:

Input: s = "a"
Output: [["a"]]

Constraints:

    1 <= s.length <= 16
    s contains only lowercase English letters.

 */

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        addPalindromes(result, new ArrayList<>(), 0, s.toCharArray());
        return result;
    }

    private void addPalindromes(List<List<String>> result, List<String> current, int beginIndex, char[] chars) {
        if (beginIndex == chars.length) {
            result.add(new ArrayList<>(current));
        }
        for (int endIndex = beginIndex; endIndex < chars.length; ++endIndex) {
            if (isPalindrome(chars, beginIndex, endIndex)) {
                current.add(new String(chars, beginIndex, endIndex + 1 - beginIndex));
                addPalindromes(result, current, endIndex + 1, chars);
                current.remove(current.size() - 1);
            }
        }
    }

    private boolean isPalindrome(char[] chars, int beginIndex, int endIndex) {
        while (beginIndex <= endIndex) {
            if (chars[beginIndex] != chars[endIndex]) {
                return false;
            }
            ++beginIndex;
            --endIndex;
        }
        return true;
    }
}
