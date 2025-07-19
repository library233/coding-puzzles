package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._0._5._8;

/*

https://leetcode.com/problems/length-of-last-word

58. Length of Last Word
(Easy)

Given a string s consisting of words and spaces, return the length of the last word in the string.

A word is a maximal
substring
consisting of non-space characters only.

Example 1:

Input: s = "Hello World"
Output: 5
Explanation: The last word is "World" with length 5.

Example 2:

Input: s = "   fly me   to   the moon  "
Output: 4
Explanation: The last word is "moon" with length 4.

Example 3:

Input: s = "luffy is still joyboy"
Output: 6
Explanation: The last word is "joyboy" with length 6.

Constraints:

    1 <= s.length <= 10^4
    s consists of only English letters and spaces ' '.
    There will be at least one word in s.

 */

class Solution {
    public int lengthOfLastWord(String s) {
        int count = 0;
        int i = s.length() - 1;
        while (i >= 0) {
            if (s.charAt(i) == ' ') {
                --i;
            } else {
                break;
            }
        }
        while (i >= 0) {
            if (s.charAt(i) != ' ') {
                --i;
                ++count;
            } else {
                break;
            }
        }
        return count;
    }
}
