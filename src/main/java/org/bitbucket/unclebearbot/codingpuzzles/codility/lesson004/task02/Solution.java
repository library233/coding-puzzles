package org.bitbucket.unclebearbot.codingpuzzles.codility.lesson004.task02;

import org.bitbucket.unclebearbot.codingpuzzles.utils.Assertion;

import java.util.HashSet;
import java.util.Set;

/*

https://app.codility.com/programmers/lessons/4-counting_elements/perm_check

A non-empty array A consisting of N integers is given.

A permutation is a sequence containing each element from 1 to N once, and only once.

For example, array A such that:
    A[0] = 4
    A[1] = 1
    A[2] = 3
    A[3] = 2
is a permutation, but array A such that:
    A[0] = 4
    A[1] = 1
    A[2] = 3
is not a permutation, because value 2 is missing.

The goal is to check whether array A is a permutation.

Write a function:
    class Solution { public int solution(int[] A); }
that, given an array A, returns 1 if array A is a permutation and 0 if it is not.

For example, given array A such that:
    A[0] = 4
    A[1] = 1
    A[2] = 3
    A[3] = 2
the function should return 1.

Given array A such that:
    A[0] = 4
    A[1] = 1
    A[2] = 3
the function should return 0.

Write an efficient algorithm for the following assumptions:
    N is an integer within the range [1..100,000];
    each element of array A is an integer within the range [1..1,000,000,000].

 */

public abstract class Solution {
    public static void main(String[] args) {
        test(new Solution01());
        test(new Solution02());
    }

    public abstract int solution(int[] A);

    public static class Solution01 extends Solution {
        @Override
        public int solution(int[] A) {
            Set<Integer> appeared = new HashSet<>();
            int length = A.length;
            for (int number : A) {
                if (number < 1 || number > length || appeared.contains(number)) {
                    return 0;
                }
                appeared.add(number);
            }
            return 1;
        }
    }

    public static class Solution02 extends Solution {
        @Override
        public int solution(int[] A) {
            int length = A.length;
            long expectedSum = (long) length * (length + 1) / 2;
            long actualSum = 0;
            int max = 0;
            for (int value : A) {
                actualSum += value;
                max = Math.max(max, value);
            }
            if (max == length && actualSum == expectedSum) {
                return 1;
            }
            return 0;
        }
    }

    public static void test(Solution solution) {
        Assertion.equalObjects(solution.solution(new int[]{1, 2, 3, 4}), 1);
        Assertion.equalObjects(solution.solution(new int[]{4, 1, 3, 2}), 1);
        Assertion.equalObjects(solution.solution(new int[]{1, 2, 4}), 0);
        Assertion.equalObjects(solution.solution(new int[]{1, 2, 1, 2}), 0);
        Assertion.equalObjects(solution.solution(new int[]{1}), 1);
        Assertion.equalObjects(solution.solution(new int[]{2}), 0);
    }
}
