package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._6._7._8;

/*

https://leetcode.com/problems/valid-parenthesis-string

678. Valid Parenthesis String
(Medium)

Given a string s containing only three types of characters: '(', ')' and '*', return true if s is valid.

The following rules define a valid string:

    Any left parenthesis '(' must have a corresponding right parenthesis ')'.
    Any right parenthesis ')' must have a corresponding left parenthesis '('.
    Left parenthesis '(' must go before the corresponding right parenthesis ')'.
    '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string "".

Example 1:

Input: s = "()"
Output: true

Example 2:

Input: s = "(*)"
Output: true

Example 3:

Input: s = "(*))"
Output: true

Constraints:

    1 <= s.length <= 100
    s[i] is '(', ')' or '*'.

 */

import java.util.Stack;

class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> opens = new Stack<>();
        Stack<Integer> wildcards = new Stack<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; ++i) {
            char c = chars[i];
            if (c == '(') {
                opens.push(i);
            } else if (c == ')') {
                if (!opens.isEmpty()) {
                    opens.pop();
                } else if (!wildcards.isEmpty()) {
                    wildcards.pop();
                } else {
                    return false;
                }
            } else {
                wildcards.push(i);
            }
        }
        if (opens.size() > wildcards.size()) {
            return false;
        }
        while (!opens.isEmpty()) {
            if (opens.pop() > wildcards.pop()) {
                return false;
            }
        }
        return true;
    }
}
