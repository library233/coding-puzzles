package org.bitbucket.unclebearbot.codingpuzzles.codility.lesson005.task04;

import org.bitbucket.unclebearbot.codingpuzzles.utils.Assertions;

/*

https://app.codility.com/programmers/lessons/5-prefix_sums/min_avg_two_slice

# MinAvgTwoSlice
# Find the minimal average of any slice containing at least two elements.

A non-empty array A consisting of N integers is given.
A pair of integers (P, Q), such that 0 ≤ P < Q < N, is called a slice of array A (notice that the slice contains at least two elements).
The average of a slice (P, Q) is the sum of A[P] + A[P + 1] + ... + A[Q] divided by the length of the slice.
To be precise, the average equals (A[P] + A[P + 1] + ... + A[Q]) / (Q − P + 1).

For example, array A such that:
    A[0] = 4
    A[1] = 2
    A[2] = 2
    A[3] = 5
    A[4] = 1
    A[5] = 5
    A[6] = 8
contains the following example slices:
    slice (1, 2), whose average is (2 + 2) / 2 = 2;
    slice (3, 4), whose average is (5 + 1) / 2 = 3;
    slice (1, 4), whose average is (2 + 2 + 5 + 1) / 4 = 2.5.

The goal is to find the starting position of a slice whose average is minimal.

Write a function:
    class Solution { public int solution(int[] A); }
that, given a non-empty array A consisting of N integers, returns the starting position of the slice with the minimal average.
If there is more than one slice with a minimal average, you should return the smallest starting position of such a slice.

For example, given array A such that:
    A[0] = 4
    A[1] = 2
    A[2] = 2
    A[3] = 5
    A[4] = 1
    A[5] = 5
    A[6] = 8
the function should return 1, as explained above.

Write an efficient algorithm for the following assumptions:
    N is an integer within the range [2..100,000];
    each element of array A is an integer within the range [−10,000..10,000].

 */

public class Solution {
    public static void main(String[] args) {
        test(new Solution());
        System.out.println(Solution.class);
    }

    public int solution(int[] A) {
        int length = A.length;
        int result = 0;
        double avg1 = Double.MAX_VALUE;
        for (int i = 0; i < length - 1; ++i) {
            double avg2 = (A[i] + A[i + 1]) / 2.0;
            if (avg2 < avg1) {
                avg1 = avg2;
                result = i;
            }
            if (i < length - 2) {
                double avg3 = (A[i] + A[i + 1] + A[i + 2]) / 3.0;
                if (avg3 < avg1) {
                    avg1 = avg3;
                    result = i;
                }
            }
        }
        return result;
    }

    public static void test(Solution solution) {
        Assertions.equalObjects(solution.solution(new int[]{4, 2, 2, 5, 1, 5, 8}), 1);
        Assertions.equalObjects(solution.solution(new int[]{1, 1, 1, 1}), 0);
        Assertions.equalObjects(solution.solution(new int[]{-3, -5, -8, -4, -10}), 2);
        Assertions.equalObjects(solution.solution(new int[]{10, 10, 10, 10, -1, -10, -10, 1, 1}), 5);
        Assertions.equalObjects(solution.solution(new int[]{-10000, 10000}), 0);
    }
}
