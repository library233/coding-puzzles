package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._1._5._1;

/*

https://leetcode.com/problems/reverse-words-in-a-string

151. Reverse Words in a String
(Medium)

Given an input string s, reverse the order of the words.

A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.

Return a string of the words in reverse order concatenated by a single space.

Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.

Example 1:

Input: s = "the sky is blue"
Output: "blue is sky the"

Example 2:

Input: s = "  hello world  "
Output: "world hello"
Explanation: Your reversed string should not contain leading or trailing spaces.

Example 3:

Input: s = "a good   example"
Output: "example good a"
Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.

Constraints:

    1 <= s.length <= 10^4
    s contains English letters (upper-case and lower-case), digits, and spaces ' '.
    There is at least one word in s.

Follow-up: If the string data type is mutable in your language, can you solve it in-place with O(1) extra space?

 */

class Solution {
    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int squeezedLength = squeeze(chars);
        reverse(chars, 0, squeezedLength - 1);
        for (int wordBeginIndex = 0, wordEndIndex = 0; wordEndIndex <= squeezedLength; ++wordEndIndex) {
            if (wordEndIndex < squeezedLength && !isSpace(chars[wordEndIndex])) {
                continue;
            }
            reverse(chars, wordBeginIndex, wordEndIndex - 1);
            wordBeginIndex = wordEndIndex + 1;
        }
        return new String(chars, 0, squeezedLength);
    }

    private int squeeze(char[] chars) {
        int left = 0;
        while (left < chars.length) {
            if (!isSpace(chars[left])) {
                break;
            }
            ++left;
        }
        int right = chars.length - 1;
        while (right >= 0) {
            if (!isSpace(chars[right])) {
                break;
            }
            --right;
        }
        int effective = 0;
        boolean inSpace = false;
        for (int i = left; i <= right; ++i) {
            if (isSpace(chars[i])) {
                inSpace = true;
                continue;
            }
            if (inSpace) {
                chars[effective] = ' ';
                inSpace = false;
                ++effective;
            }
            if (effective != i) {
                chars[effective] = chars[i];
            }
            ++effective;
        }
        return effective;
    }

    private void reverse(char[] chars, int beginIndex, int endIndex) {
        while (beginIndex < endIndex) {
            char temp = chars[beginIndex];
            chars[beginIndex] = chars[endIndex];
            chars[endIndex] = temp;
            ++beginIndex;
            --endIndex;
        }
    }

    private boolean isSpace(char c) {
        return c == ' ';
    }
}
