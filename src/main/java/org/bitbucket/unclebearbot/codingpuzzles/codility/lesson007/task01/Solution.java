package org.bitbucket.unclebearbot.codingpuzzles.codility.lesson007.task01;

import org.bitbucket.unclebearbot.utils.Assertions;

/*

https://app.codility.com/programmers/lessons/7-stacks_and_queues/brackets

# Brackets
# Determine whether a given string of parentheses (multiple types) is properly nested.

A string S consisting of N characters is considered to be properly nested if any of the following conditions is true:
    S is empty;
    S has the form "(U)" or "[U]" or "{U}" where U is a properly nested string;
    S has the form "VW" where V and W are properly nested strings.

For example, the string "{[()()]}" is properly nested but "([)()]" is not.

Write a function:
    class Solution { public int solution(String S); }
that, given a string S consisting of N characters, returns 1 if S is properly nested and 0 otherwise.

For example, given S = "{[()()]}", the function should return 1 and given S = "([)()]", the function should return 0, as explained above.

Write an efficient algorithm for the following assumptions:
    N is an integer within the range [0..200,000];
    string S is made only of the following characters: '(', '{', '[', ']', '}' and/or ')'.

 */

public class Solution {
    public static void main(String[] args) {
        test(new Solution());
        System.out.println(Solution.class);
    }

    public int solution(String S) {
        char[] stack = new char[S.length()];
        int top = -1;
        for (int i = 0; i < S.length(); ++i) {
            char c = S.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack[++top] = c;
            } else {
                if (top == -1) return 0;
                char last = stack[top--];
                if ((c == ')' && last != '(') ||
                    (c == ']' && last != '[') ||
                    (c == '}' && last != '{')) {
                    return 0;
                }
            }
        }
        return top == -1 ? 1 : 0;
    }

    public static void test(Solution solution) {
        Assertions.equalObjects(solution.solution("{[()()]}"), 1);
        Assertions.equalObjects(solution.solution("([)()]"), 0);
        Assertions.equalObjects(solution.solution("{[()]}"), 1);
        Assertions.equalObjects(solution.solution("((()))"), 1);
        Assertions.equalObjects(solution.solution("["), 0);
    }
}
