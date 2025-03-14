package org.bitbucket.unclebearbot.codingpuzzles.codility.lesson009.task02;

import org.bitbucket.unclebearbot.codingpuzzles.utils.Assertions;

/*

https://app.codility.com/programmers/lessons/9-maximum_slice_problem/max_slice_sum

# MaxSliceSum
# Find a maximum sum of a compact subsequence of array elements.

A non-empty array A consisting of N integers is given.
A pair of integers (P, Q), such that 0 ≤ P ≤ Q < N, is called a slice of array A.
The sum of a slice (P, Q) is the total of A[P] + A[P+1] + ... + A[Q].

Write a function:
    class Solution { public int solution(int[] A); }
that, given an array A consisting of N integers, returns the maximum sum of any slice of A.

For example, given array A such that:
    A[0] = 3  A[1] = 2  A[2] = -6
    A[3] = 4  A[4] = 0
the function should return 5 because:
    (3, 4) is a slice of A that has sum 4,
    (2, 2) is a slice of A that has sum −6,
    (0, 1) is a slice of A that has sum 5,
    no other slice of A has sum greater than (0, 1).

Write an efficient algorithm for the following assumptions:
    N is an integer within the range [1..1,000,000];
    each element of array A is an integer within the range [−1,000,000..1,000,000];
    the result will be an integer within the range [−2,147,483,648..2,147,483,647].

 */

public class Solution {
    public static void main(String[] args) {
        test(new Solution());
        System.out.println(Solution.class);
    }

    public int solution(int[] A) {
        int result = Integer.MIN_VALUE;
        int currentMax = 0;
        for (int j : A) {
            currentMax += j;
            if (currentMax > result) {
                result = currentMax;
            }
            if (currentMax < 0) {
                currentMax = 0;
            }
        }
        if (result == Integer.MIN_VALUE) {
            result = 0;
        }
        if (A.length == 0) return 0;
        result = Integer.MIN_VALUE;
        currentMax = 0;
        for (int j : A) {
            currentMax += j;
            if (currentMax > result) {
                result = currentMax;
            }
            if (currentMax < 0) {
                currentMax = 0;
            }
        }
        return result;
    }

    public static void test(Solution solution) {
        Assertions.equalObjects(solution.solution(new int[]{3, 2, -6, 4, 0}), 5);
        Assertions.equalObjects(solution.solution(new int[]{-1, -2, -3}), -1);
        Assertions.equalObjects(solution.solution(new int[]{1}), 1);
        Assertions.equalObjects(solution.solution(new int[]{0}), 0);
        Assertions.equalObjects(solution.solution(new int[]{-5}), -5);
        Assertions.equalObjects(solution.solution(new int[]{1, -5, 2}), 2);
        Assertions.equalObjects(solution.solution(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}), 6);
    }
}
