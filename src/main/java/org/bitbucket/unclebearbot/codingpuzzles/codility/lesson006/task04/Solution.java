package org.bitbucket.unclebearbot.codingpuzzles.codility.lesson006.task04;

import org.bitbucket.unclebearbot.codingpuzzles.utils.Assertions;

import java.util.Arrays;

/*

https://app.codility.com/programmers/lessons/6-sorting/number_of_disc_intersections

# NumberOfDiscIntersections
# Compute the number of intersections in a sequence of discs.

We draw N discs on a plane.
The discs are numbered from 0 to N − 1.
An array A of N non-negative integers, specifying the radiuses of the discs, is given.
The J-th disc is drawn with its center at (J, 0) and radius A[J].

We say that the J-th disc and K-th disc intersect if J ≠ K and the J-th and K-th discs have at least one common point (assuming that the discs contain their borders).

The figure below shows discs drawn for N = 6 and A as follows:
    A[0] = 1
    A[1] = 5
    A[2] = 2
    A[3] = 1
    A[4] = 4
    A[5] = 0

[figure-01.png]

There are eleven (unordered) pairs of discs that intersect, namely:
    discs 1 and 4 intersect, and both intersect with all the other discs;
    disc 2 also intersects with discs 0 and 3.

Write a function:
    class Solution { public int solution(int[] A); }
that, given an array A describing N discs as explained above, returns the number of (unordered) pairs of intersecting discs.
The function should return −1 if the number of intersecting pairs exceeds 10,000,000.

Given array A shown above, the function should return 11, as explained above.

Write an efficient algorithm for the following assumptions:
    N is an integer within the range [0..100,000];
    each element of array A is an integer within the range [0..2,147,483,647].

 */

public class Solution {
    public static void main(String[] args) {
        test(new Solution());
    }

    public int solution(int[] A) {
        int length = A.length;
        long[] left = new long[length];
        long[] right = new long[length];
        for (int i = 0; i < length; i++) {
            left[i] = (long) i - A[i];
            right[i] = (long) i + A[i];
        }
        Arrays.sort(left);
        Arrays.sort(right);
        int circles = 0, intersections = 0;
        int j = 0;
        for (int i = 0; i < length; i++) {
            while (j < length && left[j] <= right[i]) {
                intersections += circles;
                circles++;
                if (intersections > 10000000) return -1;
                j++;
            }
            circles--;
        }
        return intersections;
    }

    public static void test(Solution solution) {
        Assertions.equalObjects(solution.solution(new int[]{1, 5, 2, 1, 4, 0}), 11);
        Assertions.equalObjects(solution.solution(new int[]{1, 1, 1}), 3);
        Assertions.equalObjects(solution.solution(new int[]{0, 0, 0}), 0);
        Assertions.equalObjects(solution.solution(new int[]{0, 1, 0, 1}), 4);
        Assertions.equalObjects(solution.solution(new int[]{10, 10, 10, 10}), 6);
    }
}
