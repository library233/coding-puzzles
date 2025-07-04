package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._0._0._3;

/*

https://leetcode.com/problems/longest-substring-without-repeating-characters

3. Longest Substring Without Repeating Characters
(Medium)

Given a string s, find the length of the longest substring without duplicate characters.

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

Constraints:

    0 <= s.length <= 5 * 10^4
    s consists of English letters, digits, symbols and spaces.

 */

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int beginIndex = 0;
        int[] minIndices = new int[128];
        for (int i = 0; i < s.length(); ++i) {
            int charAsInt = s.charAt(i);
            int minIndex = minIndices[charAsInt];
            if (minIndex > beginIndex) {
                beginIndex = minIndex;
            }
            int endIndex = i + 1;
            int length = endIndex - beginIndex;
            if (length > maxLength) {
                maxLength = length;
            }
            minIndices[charAsInt] = endIndex;
        }
        return maxLength;
    }
}
