package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._0._2._2;

/*

https://leetcode.com/problems/generate-parentheses

22. Generate Parentheses
(Medium)

Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

Example 1:

Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]

Example 2:

Input: n = 1
Output: ["()"]

Constraints:

    1 <= n <= 8

 */

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        addValidStrings(result, new StringBuilder(), 0, 0, n);
        return result;
    }

    private void addValidStrings(List<String> result, StringBuilder current, int openCount, int closeCount, int pairCount) {
        if (current.length() == 2 * pairCount) {
            result.add(current.toString());
            return;
        }
        if (openCount < pairCount) {
            current.append('(');
            addValidStrings(result, current, openCount + 1, closeCount, pairCount);
            current.deleteCharAt(current.length() - 1);
        }
        if (closeCount < openCount) {
            current.append(')');
            addValidStrings(result, current, openCount, closeCount + 1, pairCount);
            current.deleteCharAt(current.length() - 1);
        }
    }
}
