package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._7._0._9;

/*

https://leetcode.com/problems/to-lower-case

709. To Lower Case
(Easy)

Given a string s, return the string after replacing every uppercase letter with the same lowercase letter.

Example 1:

Input: s = "Hello"
Output: "hello"

Example 2:

Input: s = "here"
Output: "here"

Example 3:

Input: s = "LOVELY"
Output: "lovely"

Constraints:

    1 <= s.length <= 100
    s consists of printable ASCII characters.

 */

class Solution {
    public String toLowerCase(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; ++i) {
            chars[i] = toLowerCase(chars[i]);
        }
        return new String(chars);
    }

    private char toLowerCase(char c) {
        if (c < 'A' || c > 'Z') {
            return c;
        }
        return (char) (c - 'A' + 'a');
    }
}
