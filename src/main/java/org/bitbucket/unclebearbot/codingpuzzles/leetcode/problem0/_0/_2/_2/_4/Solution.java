package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._2._2._4;

/*

https://leetcode.com/problems/basic-calculator

224. Basic Calculator
(Hard)

Given a string s representing a valid expression, implement a basic calculator to evaluate it, and return the result of the evaluation.

Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().

Example 1:

Input: s = "1 + 1"
Output: 2

Example 2:

Input: s = " 2-1 + 2 "
Output: 3

Example 3:

Input: s = "(1+(4+5+2)-3)+(6+8)"
Output: 23

Constraints:

    1 <= s.length <= 3 * 10^5
    s consists of digits, '+', '-', '(', ')', and ' '.
    s represents a valid expression.
    '+' is not used as a unary operation (i.e., "+1" and "+(2 + 3)" is invalid).
    '-' could be used as a unary operation (i.e., "-1" and "-(2 + 3)" is valid).
    There will be no two consecutive operators in the input.
    Every number and running calculation will fit in a signed 32-bit integer.

 */

import java.util.Stack;

class Solution {
    public int calculate(String s) {
        int accumulated = 0;
        Stack<Integer> signs = new Stack<>();
        int sign = 1;
        signs.push(sign);
        int number = 0;
        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                int digit = c - '0';
                number = 10 * number + digit;
                continue;
            }
            if (c == '+' || c == '-') {
                accumulated += sign * number;
                sign = (c == '+' ? 1 : -1) * signs.peek();
                number = 0;
                continue;
            }
            switch (c) {
                case '(':
                    signs.push(sign);
                    break;
                case ')':
                    signs.pop();
                    break;
                default:
                    break;
            }
        }
        return accumulated + sign * number;
    }
}
