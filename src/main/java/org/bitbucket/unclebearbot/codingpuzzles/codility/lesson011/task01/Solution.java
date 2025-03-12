package org.bitbucket.unclebearbot.codingpuzzles.codility.lesson011.task01;

import org.bitbucket.unclebearbot.codingpuzzles.utils.Assertions;

/*

https://app.codility.com/programmers/lessons/11-sieve_of_eratosthenes/count_non_divisible

# CountNonDivisible
# Calculate the number of elements of an array that are not divisors of each element.

You are given an array A consisting of N integers.

For each number A[i] such that 0 ≤ i < N, we want to count the number of elements of the array that are not the divisors of A[i].
We say that these elements are non-divisors.

For example, consider integer N = 5 and array A such that:
    A[0] = 3
    A[1] = 1
    A[2] = 2
    A[3] = 3
    A[4] = 6

For the following elements:
    A[0] = 3, the non-divisors are: 2, 6,
    A[1] = 1, the non-divisors are: 3, 2, 3, 6,
    A[2] = 2, the non-divisors are: 3, 3, 6,
    A[3] = 3, the non-divisors are: 2, 6,
    A[4] = 6, there aren't any non-divisors.

Write a function:
    class Solution { public int[] solution(int[] A); }
that, given an array A consisting of N integers, returns a sequence of integers representing the amount of non-divisors.

Result array should be returned as an array of integers.

For example, given:
    A[0] = 3
    A[1] = 1
    A[2] = 2
    A[3] = 3
    A[4] = 6
the function should return [2, 4, 3, 2, 0], as explained above.

Write an efficient algorithm for the following assumptions:
    N is an integer within the range [1..50,000];
    each element of array A is an integer within the range [1..2 * N].

 */

public class Solution {
    public static void main(String[] args) {
        test(new Solution());
    }

    public int[] solution(int[] A) {
        int n = A.length;
        int[] nonDivisorCounts = new int[n];
        for (int i = 0; i < n; ++i) {
            int count = 0;
            for (int j = 0; j < n; ++j) {
                if (A[i] % A[j] != 0) {
                    ++count;
                }
            }
            nonDivisorCounts[i] = count;
        }
        return nonDivisorCounts;
    }

    public static void test(Solution solution) {
        Assertions.equalArrays(solution.solution(new int[]{3, 1, 2, 3, 6}), new int[]{2, 4, 3, 2, 0});
        Assertions.equalArrays(solution.solution(new int[]{6, 6}), new int[]{0, 0});
        Assertions.equalArrays(solution.solution(new int[]{1}), new int[]{0});
        Assertions.equalArrays(solution.solution(new int[]{2, 2, 2}), new int[]{0, 0, 0});
        Assertions.equalArrays(solution.solution(new int[]{3, 3, 3}), new int[]{0, 0, 0});
        Assertions.equalArrays(solution.solution(new int[]{6, 6, 6}), new int[]{0, 0, 0});
        Assertions.equalArrays(solution.solution(new int[]{4, 4, 4, 4, 4}), new int[]{0, 0, 0, 0, 0});
    }
}
