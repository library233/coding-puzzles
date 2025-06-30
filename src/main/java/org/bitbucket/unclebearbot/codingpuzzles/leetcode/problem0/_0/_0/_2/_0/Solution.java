package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._0._2._0;

/*

https://leetcode.com/problems/valid-parentheses

20. Valid Parentheses
(Easy)

Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

    Open brackets must be closed by the same type of brackets.
    Open brackets must be closed in the correct order.
    Every close bracket has a corresponding open bracket of the same type.

Example 1:

Input: s = "()"

Output: true

Example 2:

Input: s = "()[]{}"

Output: true

Example 3:

Input: s = "(]"

Output: false

Example 4:

Input: s = "([])"

Output: true

Constraints:

    1 <= s.length <= 10^4
    s consists of parentheses only '()[]{}'.

 */

import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        for (char c : s.toCharArray()) {
            if (isOpen(c)) {
                stack.push(c);
                continue;
            }
            if (stack.isEmpty()) {
                return false;
            }
            if (!isPair(stack.pop(), c)) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    private boolean isOpen(char c) {
        if (c == '(') {
            return true;
        }
        if (c == '[') {
            return true;
        }
        if (c == '{') {
            return true;
        }
        return false;
    }

    private boolean isPair(char left, char right) {
        if (left == '(' && right == ')') {
            return true;
        }
        if (left == '[' && right == ']') {
            return true;
        }
        if (left == '{' && right == '}') {
            return true;
        }
        return false;
    }
}
