package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem00032;

/*

https://leetcode.com/problems/longest-valid-parentheses

32. Longest Valid Parentheses
(Hard)

Given a string containing just the characters '(' and ')', return the length of the longest valid (well-formed) parentheses substring.

Example 1:

Input: s = "(()"
Output: 2
Explanation: The longest valid parentheses substring is "()".

Example 2:

Input: s = ")()())"
Output: 4
Explanation: The longest valid parentheses substring is "()()".

Example 3:

Input: s = ""
Output: 0

Constraints:

    0 <= s.length <= 3 * 10^4
    s[i] is '(', or ')'.

 */

import java.util.Stack;

class Solution {
    public int longestValidParentheses(String s) {
        int maxLength = 0;
        Stack<Integer> remainingOpenParenthesesAndLastBoundary = new Stack<>();
        remainingOpenParenthesesAndLastBoundary.push(-1);
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '(') {
                remainingOpenParenthesesAndLastBoundary.push(i);
            } else {
                remainingOpenParenthesesAndLastBoundary.pop();
                if (remainingOpenParenthesesAndLastBoundary.isEmpty()) {
                    remainingOpenParenthesesAndLastBoundary.push(i);
                } else {
                    int length = i - remainingOpenParenthesesAndLastBoundary.peek();
                    if (length > maxLength) {
                        maxLength = length;
                    }
                }
            }
        }
        return maxLength;
    }
}
