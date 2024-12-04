package org.bitbucket.unclebearbot.codingpuzzles.codility.lesson005.task02;

import org.bitbucket.unclebearbot.codingpuzzles.utils.Assertion;

/*

https://app.codility.com/programmers/lessons/5-prefix_sums/count_div

Write a function:
    class Solution { public int solution(int A, int B, int K); }
that, given three integers A, B and K, returns the number of integers within the range [A..B] that are divisible by K, i.e.:
    { i : A ≤ i ≤ B, i mod K = 0 }

For example, for A = 6, B = 11 and K = 2, your function should return 3, because there are three numbers divisible by 2 within the range [6..11], namely 6, 8 and 10.

Write an efficient algorithm for the following assumptions:
    A and B are integers within the range [0..2,000,000,000];
    K is an integer within the range [1..2,000,000,000];
    A ≤ B.

 */

public class Solution {
    public static void main(String[] args) {
        test(new Solution());
    }

    public int solution(int A, int B, int K) {
        int divisibleByKAndLessThanOrEqualToB = B / K;
        int divisibleByKAndLessThanA = A == 0 ? -1 : (A - 1) / K;
        return divisibleByKAndLessThanOrEqualToB - divisibleByKAndLessThanA;
    }

    public static void test(Solution solution) {
        Assertion.equalObjects(solution.solution(20, 30, 10), 2);
        Assertion.equalObjects(solution.solution(20, 30, 20), 1);
        Assertion.equalObjects(solution.solution(20, 30, 30), 1);
        Assertion.equalObjects(solution.solution(20, 30, 40), 0);
        Assertion.equalObjects(solution.solution(0, 1, 2000000000), 1);
        Assertion.equalObjects(solution.solution(0, 2000000000, 1), 2000000001);
    }
}
