package org.bitbucket.unclebearbot.codingpuzzles.codility.lesson009.task03;

import org.bitbucket.unclebearbot.utils.Assertions;

/*

https://app.codility.com/programmers/lessons/9-maximum_slice_problem/max_double_slice_sum

# MaxDoubleSliceSum
# Find the maximal sum of any double slice.

A non-empty array A consisting of N integers is given.

A triplet (X, Y, Z), such that 0 ≤ X < Y < Z < N, is called a double slice.

The sum of double slice (X, Y, Z) is the total of A[X + 1] + A[X + 2] + ... + A[Y − 1] + A[Y + 1] + A[Y + 2] + ... + A[Z − 1].

For example, array A such that:
    A[0] = 3
    A[1] = 2
    A[2] = 6
    A[3] = -1
    A[4] = 4
    A[5] = 5
    A[6] = -1
    A[7] = 2
contains the following example double slices:
    double slice (0, 3, 6), sum is 2 + 6 + 4 + 5 = 17,
    double slice (0, 3, 7), sum is 2 + 6 + 4 + 5 − 1 = 16,
    double slice (3, 4, 5), sum is 0.

The goal is to find the maximal sum of any double slice.

Write a function:
    class Solution { public int solution(int[] A); }
that, given a non-empty array A consisting of N integers, returns the maximal sum of any double slice.

For example, given:
    A[0] = 3
    A[1] = 2
    A[2] = 6
    A[3] = -1
    A[4] = 4
    A[5] = 5
    A[6] = -1
    A[7] = 2
the function should return 17, because no double slice of array A has a sum of greater than 17.

Write an efficient algorithm for the following assumptions:
    N is an integer within the range [3..100,000];
    each element of array A is an integer within the range [−10,000..10,000].

 */

public class Solution {
    public static void main(String[] args) {
        test(new Solution());
        System.out.println(Solution.class);
    }

    public int solution(int[] A) {
        int n = A.length;
        if (n < 3) {
            return 0;
        }
        int[] leftMaxSlice = new int[n];
        int[] rightMaxSlice = new int[n];
        int maxEndingHere = 0;
        int maxSoFar = Integer.MIN_VALUE;
        for (int i = 0; i < n; ++i) {
            maxEndingHere = Math.max(A[i], maxEndingHere + A[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
            leftMaxSlice[i] = maxSoFar;
        }
        maxSoFar = Integer.MIN_VALUE;
        maxEndingHere = 0;
        for (int i = n - 1; i >= 0; --i) {
            maxEndingHere = Math.max(A[i], maxEndingHere + A[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
            rightMaxSlice[i] = maxSoFar;
        }
        int maxDoubleSliceSum = 0;
        for (int y = 1; y < n - 1; ++y) {
            int leftSum = (y > 1) ? leftMaxSlice[y - 2] : 0;
            int rightSum = (y < n - 2) ? rightMaxSlice[y + 1] : 0;
            maxDoubleSliceSum = Math.max(maxDoubleSliceSum, leftSum + rightSum);
        }
        return maxDoubleSliceSum;
    }

    public static void test(Solution solution) {
        Assertions.equalObjects(solution.solution(new int[]{3, 2, 6, -1, 4, 5, -1, 2}), 17);
        Assertions.equalObjects(solution.solution(new int[]{5, 0, 1, 0, 5}), 10);
        Assertions.equalObjects(solution.solution(new int[]{-8, 10, -9, -7, -3, 2, -3, -5, 1, -6}), 12);
        Assertions.equalObjects(solution.solution(new int[]{}), 0);
        Assertions.equalObjects(solution.solution(new int[]{1, 2, 3}), 0);
        Assertions.equalObjects(solution.solution(new int[]{-5, -4, -3, -2, -1}), 0);
    }
}
