package org.bitbucket.unclebearbot.codingpuzzles.codility.lesson010.task01;

import org.bitbucket.unclebearbot.utils.Assertions;

/*

https://app.codility.com/programmers/lessons/10-prime_and_composite_numbers/count_factors

# CountFactors
# Count factors of given number n.

A positive integer D is a factor of a positive integer N if there exists an integer M such that N = D * M.

For example, 6 is a factor of 24, because M = 4 satisfies the above condition (24 = 6 * 4).

Write a function:
    class Solution { public int solution(int N); }
that, given a positive integer N, returns the number of its factors.

For example, given N = 24, the function should return 8, because 24 has 8 factors, namely 1, 2, 3, 4, 6, 8, 12, 24.
There are no other factors of 24.

Write an efficient algorithm for the following assumptions:
    N is an integer within the range [1..2,147,483,647].

 */

public class Solution {
    public static void main(String[] args) {
        test(new Solution());
        System.out.println(Solution.class);
    }

    public int solution(int N) {
        int count = 0;
        for (int i = 1; i * i <= N; ++i) {
            if (N % i == 0) {
                if (i * i == N) {
                    ++count;
                } else {
                    count += 2;
                }
            }
        }
        return count;
    }

    public static void test(Solution solution) {
        Assertions.equalObjects(solution.solution(24), 8);
        Assertions.equalObjects(solution.solution(1), 1);
        Assertions.equalObjects(solution.solution(2), 2);
        Assertions.equalObjects(solution.solution(10), 4);
        Assertions.equalObjects(solution.solution(16), 5);
        Assertions.equalObjects(solution.solution(25), 3);
    }
}
