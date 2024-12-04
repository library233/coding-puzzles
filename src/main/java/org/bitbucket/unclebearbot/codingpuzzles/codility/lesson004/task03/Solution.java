package org.bitbucket.unclebearbot.codingpuzzles.codility.lesson004.task03;

import org.bitbucket.unclebearbot.codingpuzzles.utils.Assertion;

/*

https://app.codility.com/programmers/lessons/4-counting_elements/max_counters

You are given N counters, initially set to 0, and you have two possible operations on them:
    increase(X) − counter X is increased by 1,
    max counter − all counters are set to the maximum value of any counter.

A non-empty array A of M integers is given.
This array represents consecutive operations:
    if A[K] = X, such that 1 ≤ X ≤ N, then operation K is increase(X),
    if A[K] = N + 1 then operation K is max counter.

For example, given integer N = 5 and array A such that:
    A[0] = 3
    A[1] = 4
    A[2] = 4
    A[3] = 6
    A[4] = 1
    A[5] = 4
    A[6] = 4
the values of the counters after each consecutive operation will be:
    (0, 0, 1, 0, 0)
    (0, 0, 1, 1, 0)
    (0, 0, 1, 2, 0)
    (2, 2, 2, 2, 2)
    (3, 2, 2, 2, 2)
    (3, 2, 2, 3, 2)
    (3, 2, 2, 4, 2)

The goal is to calculate the value of every counter after all operations.

Write a function:
    class Solution { public int[] solution(int N, int[] A); }
that, given an integer N and a non-empty array A consisting of M integers, returns a sequence of integers representing the values of the counters.

Result array should be returned as an array of integers.

For example, given:
    A[0] = 3
    A[1] = 4
    A[2] = 4
    A[3] = 6
    A[4] = 1
    A[5] = 4
    A[6] = 4
the function should return [3, 2, 2, 4, 2], as explained above.

Write an efficient algorithm for the following assumptions:
    N and M are integers within the range [1..100,000];
    each element of array A is an integer within the range [1..N + 1].

 */

public class Solution {
    public static void main(String[] args) {
        test(new Solution());
    }

    public int[] solution(int N, int[] A) {
        int[] counters = new int[N];
        int tentativeHighWaterMark = 0;
        int effectiveHighWaterMark = 0;
        for (int operation : A) {
            if (operation >= 1 && operation <= N) {
                int index = operation - 1;
                counters[index] = Math.max(counters[index], effectiveHighWaterMark);
                ++counters[index];
                tentativeHighWaterMark = Math.max(tentativeHighWaterMark, counters[index]);
            } else if (operation == N + 1) {
                effectiveHighWaterMark = tentativeHighWaterMark;
            }
        }
        for (int i = 0; i < N; ++i) {
            counters[i] = Math.max(counters[i], effectiveHighWaterMark);
        }
        return counters;
    }

    public static void test(Solution solution) {
        Assertion.equalArrays(solution.solution(5, new int[]{3, 4, 4, 6, 1, 4, 4}), new int[]{3, 2, 2, 4, 2});
        Assertion.equalArrays(solution.solution(1, new int[]{1, 2, 1, 2, 1}), new int[]{3});
        Assertion.equalArrays(solution.solution(3, new int[]{4, 4, 4}), new int[]{0, 0, 0});
        Assertion.equalArrays(solution.solution(2, new int[]{1, 2, 1, 2, 3}), new int[]{2, 2});
    }
}
