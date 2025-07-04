package org.bitbucket.unclebearbot.codingpuzzles.codility.lesson006.task02;

import org.bitbucket.unclebearbot.utils.Assertions;

import java.util.Arrays;

/*

https://app.codility.com/programmers/lessons/6-sorting/max_product_of_three

# MaxProductOfThree
# Maximize A[P] * A[Q] * A[R] for any triplet (P, Q, R).

A non-empty array A consisting of N integers is given.
The product of triplet (P, Q, R) equates to A[P] * A[Q] * A[R] (0 ≤ P < Q < R < N).

For example, array A such that:
    A[0] = -3
    A[1] = 1
    A[2] = 2
    A[3] = -2
    A[4] = 5
    A[5] = 6
contains the following example triplets:
    (0, 1, 2), product is −3 * 1 * 2 = −6
    (1, 2, 4), product is 1 * 2 * 5 = 10
    (2, 4, 5), product is 2 * 5 * 6 = 60

Your goal is to find the maximal product of any triplet.

Write a function:
    class Solution { public int solution(int[] A); }
that, given a non-empty array A, returns the value of the maximal product of any triplet.

For example, given array A such that:
    A[0] = -3
    A[1] = 1
    A[2] = 2
    A[3] = -2
    A[4] = 5
    A[5] = 6
the function should return 60, as the product of triplet (2, 4, 5) is maximal.

Write an efficient algorithm for the following assumptions:
    N is an integer within the range [3..100,000];
    each element of array A is an integer within the range [−1,000..1,000].

 */

public class Solution {
    public static void main(String[] args) {
        test(new Solution());
        System.out.println(Solution.class);
    }

    public int solution(int[] A) {
        Arrays.sort(A);
        return Math.max(A[A.length - 1] * A[A.length - 2] * A[A.length - 3], A[0] * A[1] * A[A.length - 1]);
    }

    public static void test(Solution solution) {
        Assertions.equalObjects(solution.solution(new int[]{-3, 1, 2, -2, 5, 6}), 60);
        Assertions.equalObjects(solution.solution(new int[]{-10, -10, 1, 3, 2}), 300);
        Assertions.equalObjects(solution.solution(new int[]{1, 2, 3}), 6);
        Assertions.equalObjects(solution.solution(new int[]{-5, -4, -3, -2, -1}), -6);
        Assertions.equalObjects(solution.solution(new int[]{10, 10, 10, 10}), 1000);
    }
}
