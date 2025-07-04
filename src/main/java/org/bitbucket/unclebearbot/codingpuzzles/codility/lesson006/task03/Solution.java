package org.bitbucket.unclebearbot.codingpuzzles.codility.lesson006.task03;

import org.bitbucket.unclebearbot.utils.Assertions;

import java.util.Arrays;

/*

https://app.codility.com/programmers/lessons/6-sorting/triangle

# Triangle
# Determine whether a triangle can be built from a given set of edges.

An array A consisting of N integers is given.
A triplet (P, Q, R) is triangular if 0 ≤ P < Q < R < N and:
    A[P] + A[Q] > A[R],
    A[Q] + A[R] > A[P],
    A[R] + A[P] > A[Q].

For example, consider array A such that:
    A[0] = 10    A[1] = 2    A[2] = 5
    A[3] = 1     A[4] = 8    A[5] = 20

Triplet (0, 2, 4) is triangular.

Write a function:
    class Solution { public int solution(int[] A); }
that, given an array A consisting of N integers, returns 1 if there exists a triangular triplet for this array and returns 0 otherwise.

For example, given array A such that:
    A[0] = 10    A[1] = 2    A[2] = 5
    A[3] = 1     A[4] = 8    A[5] = 20
the function should return 1, as explained above.
Given array A such that:
    A[0] = 10    A[1] = 50    A[2] = 5
    A[3] = 1
the function should return 0.

Write an efficient algorithm for the following assumptions:
    N is an integer within the range [0..100,000];
    each element of array A is an integer within the range [−2,147,483,648..2,147,483,647].

 */

public class Solution {
    public static void main(String[] args) {
        test(new Solution());
        System.out.println(Solution.class);
    }

    public int solution(int[] A) {
        if (A.length < 3) return 0;
        Arrays.sort(A);
        for (int i = 0; i < A.length - 2; ++i) {
            if ((long) A[i] + A[i + 1] > A[i + 2]) {
                return 1;
            }
        }
        return 0;
    }

    public static void test(Solution solution) {
        Assertions.equalObjects(solution.solution(new int[]{10, 2, 5, 1, 8, 20}), 1);
        Assertions.equalObjects(solution.solution(new int[]{10, 50, 5, 1}), 0);
        Assertions.equalObjects(solution.solution(new int[]{1, 1, 1}), 1);
        Assertions.equalObjects(solution.solution(new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE}), 1);
        Assertions.equalObjects(solution.solution(new int[]{-5, -4, -3, -2, -1}), 0);
        Assertions.equalObjects(solution.solution(new int[]{5, 10}), 0);
    }
}
