package org.bitbucket.unclebearbot.codingpuzzles.codility.lesson015.task02;

import org.bitbucket.unclebearbot.codingpuzzles.utils.Assertions;

/*

https://app.codility.com/programmers/lessons/15-caterpillar_method/count_distinct_slices

# CountDistinctSlices
# Count the number of distinct slices (containing only unique numbers).

An integer M and a non-empty array A consisting of N non-negative integers are given.
All integers in array A are less than or equal to M.

A pair of integers (P, Q), such that 0 ≤ P ≤ Q < N, is called a slice of array A.
The slice consists of the elements A[P], A[P + 1], ..., A[Q].
A distinct slice is a slice consisting of only unique numbers.
That is, no individual number occurs more than once in the slice.

For example, consider integer M = 6 and array A such that:
    A[0] = 3
    A[1] = 4
    A[2] = 5
    A[3] = 5
    A[4] = 2

There are exactly nine distinct slices: (0, 0), (0, 1), (0, 2), (1, 1), (1, 2), (2, 2), (3, 3), (3, 4) and (4, 4).

The goal is to calculate the number of distinct slices.

Write a function:
    class Solution { public int solution(int M, int[] A); }
that, given an integer M and a non-empty array A consisting of N integers, returns the number of distinct slices.

If the number of distinct slices is greater than 1,000,000,000, the function should return 1,000,000,000.

For example, given integer M = 6 and array A such that:
    A[0] = 3
    A[1] = 4
    A[2] = 5
    A[3] = 5
    A[4] = 2
the function should return 9, as explained above.

Write an efficient algorithm for the following assumptions:
    N is an integer within the range [1..100,000];
    M is an integer within the range [0..100,000];
    each element of array A is an integer within the range [0..M].

 */

public class Solution {
    public static void main(String[] args) {
        test(new Solution());
        System.out.println(Solution.class);
    }

    public int solution(int M, int[] A) {
        int n = A.length, result = 0, i = 0, j = 0;
        int[] occ = new int[M + 1];
        while (j < n) {
            if (occ[A[j]] == 0) {
                occ[A[j]] = 1;
                result += (j - i + 1);
                if (result >= 1000000000) return 1000000000;
                ++j;
            } else {
                occ[A[i]] = 0;
                ++i;
            }
        }
        return result;
    }

    public static void test(Solution solution) {
        Assertions.equalObjects(solution.solution(6, new int[]{3, 4, 5, 5, 2}), 9);
        Assertions.equalObjects(solution.solution(5, new int[]{1, 2, 3, 4, 5}), 15);
        Assertions.equalObjects(solution.solution(10, new int[]{1, 1, 1, 1, 1}), 5);
        Assertions.equalObjects(solution.solution(0, new int[]{0}), 1);
    }
}
