package org.bitbucket.unclebearbot.codingpuzzles.codility.lesson007.task03;

import org.bitbucket.unclebearbot.utils.Assertions;

import java.util.ArrayDeque;
import java.util.Deque;

/*

https://app.codility.com/programmers/lessons/7-stacks_and_queues/nesting

# Nesting
# Determine whether a given string of parentheses (single type) is properly nested.

A string S consisting of N characters is called properly nested if:
    S is empty;
    S has the form "(U)" where U is a properly nested string;
    S has the form "VW" where V and W are properly nested strings.

For example, string "(()(())())" is properly nested but string "())" isn't.

Write a function:
    class Solution { public int solution(String S); }
that, given a string S consisting of N characters, returns 1 if string S is properly nested and 0 otherwise.

For example, given S = "(()(())())", the function should return 1 and given S = "())", the function should return 0, as explained above.

Write an efficient algorithm for the following assumptions:
    N is an integer within the range [0..1,000,000];

 */

public class Solution {
    public static void main(String[] args) {
        test(new Solution());
        System.out.println(Solution.class);
    }

    public int solution(String S) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : S.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return 0;
                }
                stack.pop();
            }
        }
        return stack.isEmpty() ? 1 : 0;
    }

    public static void test(Solution solution) {
        Assertions.equalObjects(solution.solution("(()(())())"), 1);
        Assertions.equalObjects(solution.solution("())"), 0);
        Assertions.equalObjects(solution.solution(""), 1);
        Assertions.equalObjects(solution.solution("()"), 1);
        Assertions.equalObjects(solution.solution("(()(()))"), 1);
        Assertions.equalObjects(solution.solution("(()))("), 0);
    }
}
