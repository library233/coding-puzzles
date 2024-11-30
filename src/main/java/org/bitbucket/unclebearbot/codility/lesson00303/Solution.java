package org.bitbucket.unclebearbot.codility.lesson00303;

import org.bitbucket.unclebearbot.codility.utils.Assertion;

import java.util.Arrays;

/*

https://app.codility.com/programmers/lessons/3-time_complexity/tape_equilibrium

A non-empty array A consisting of N integers is given.
Array A represents numbers on a tape.

Any integer P, such that 0 < P < N, splits this tape into two non-empty parts: A[0], A[1], ..., A[P − 1] and A[P], A[P + 1], ..., A[N − 1].

The difference between the two parts is the value of: |(A[0] + A[1] + ... + A[P − 1]) − (A[P] + A[P + 1] + ... + A[N − 1])|

In other words, it is the absolute difference between the sum of the first part and the sum of the second part.

For example, consider array A such that:
    A[0] = 3
    A[1] = 1
    A[2] = 2
    A[3] = 4
    A[4] = 3

We can split this tape in four places:
    P = 1, difference = |3 − 10| = 7
    P = 2, difference = |4 − 9| = 5
    P = 3, difference = |6 − 7| = 1
    P = 4, difference = |10 − 3| = 7

Write a function:
    class Solution { public int solution(int[] A); }
that, given a non-empty array A of N integers, returns the minimal difference that can be achieved.

For example, given:
    A[0] = 3
    A[1] = 1
    A[2] = 2
    A[3] = 4
    A[4] = 3
the function should return 1, as explained above.

Write an efficient algorithm for the following assumptions:
    N is an integer within the range [2..100,000];
    each element of array A is an integer within the range [−1,000..1,000].

 */

public class Solution {
    public static void main(String[] args) {
        test(new Solution());
    }

    public int solution(int[] A) {
        int totalSum = Arrays.stream(A).sum();
        int leftSum = 0;
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < A.length - 1; i++) {
            leftSum += A[i];
            minDiff = Math.min(minDiff, Math.abs(leftSum - (totalSum - leftSum)));
        }
        return minDiff;
    }

    public static void test(Solution solution) {
        Assertion.equalObjects(solution.solution(new int[]{1, 1}), 0);
        Assertion.equalObjects(solution.solution(new int[]{5, 6}), 1);
        Assertion.equalObjects(solution.solution(new int[]{1, 2, 3, 4, 10}), 0);
        Assertion.equalObjects(solution.solution(new int[]{3, 1, 2, 4, 3}), 1);
        Assertion.equalObjects(solution.solution(new int[]{-1000, 1000}), 2000);
    }
}
