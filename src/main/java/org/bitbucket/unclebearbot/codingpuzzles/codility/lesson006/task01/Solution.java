package org.bitbucket.unclebearbot.codingpuzzles.codility.lesson006.task01;

import org.bitbucket.unclebearbot.codingpuzzles.utils.Assertions;

import java.util.Arrays;

/*

https://app.codility.com/programmers/lessons/6-sorting/distinct

# Distinct
# Compute number of distinct values in an array.

Write a function
    class Solution { public int solution(int[] A); }
that, given an array A consisting of N integers, returns the number of distinct values in array A.

For example, given array A consisting of six elements such that:
    A[0] = 2    A[1] = 1    A[2] = 1
    A[3] = 2    A[4] = 3    A[5] = 1
the function should return 3, because there are 3 distinct values appearing in array A, namely 1, 2 and 3.

Write an efficient algorithm for the following assumptions:
    N is an integer within the range [0..100,000];
    each element of array A is an integer within the range [−1,000,000..1,000,000].

 */

public class Solution {
    public static void main(String[] args) {
        test(new Solution());
    }

    public int solution(int[] A) {
        return (int) Arrays.stream(A).distinct().count();
    }

    public static void test(Solution solution) {
        Assertions.equalObjects(solution.solution(new int[]{2, 1, 1, 2, 3, 1}), 3);
        Assertions.equalObjects(solution.solution(new int[]{1, 2, 3, 4, 5, 6}), 6);
        Assertions.equalObjects(solution.solution(new int[]{1, 1, 1, 1, 1}), 1);
        Assertions.equalObjects(solution.solution(new int[]{}), 0);
        Assertions.equalObjects(solution.solution(new int[]{-1, -2, -3, -4, -5, -5, -4, -3, -2, -1}), 5);
        Assertions.equalObjects(solution.solution(new int[]{1000000, -1000000, 1000000, -1000000}), 2);
    }
}
