package org.bitbucket.unclebearbot.codingpuzzles.codility.lesson003.task02;

import org.bitbucket.unclebearbot.utils.Assertions;

import java.util.Arrays;
import java.util.stream.IntStream;

/*

https://app.codility.com/programmers/lessons/3-time_complexity/perm_missing_elem

# PermMissingElem
# Find the missing element in a given permutation.

An array A consisting of N different integers is given.
The array contains integers in the range [1..(N + 1)], which means that exactly one element is missing.

Your goal is to find that missing element.

Write a function:
    class Solution { public int solution(int[] A); }
that, given an array A, returns the value of the missing element.

For example, given array A such that:
    A[0] = 2
    A[1] = 3
    A[2] = 1
    A[3] = 5
the function should return 4, as it is the missing element.

Write an efficient algorithm for the following assumptions:
    N is an integer within the range [0..100,000];
    the elements of A are all distinct;
    each element of array A is an integer within the range [1..(N + 1)].

 */

public abstract class Solution {
    public static void main(String[] args) {
        test(new Solution01());
        System.out.println(Solution01.class);
        test(new Solution02());
        System.out.println(Solution02.class);
    }

    public abstract int solution(int[] A);

    public static class Solution01 extends Solution {
        @Override
        public int solution(int[] A) {
            long expectedSum = (long) (A.length + 1) * (A.length + 2) / 2;
            long actualSum = Arrays.stream(A).asLongStream().sum();
            return (int) (expectedSum - actualSum);
        }
    }

    public static class Solution02 extends Solution {
        @Override
        public int solution(int[] A) {
            int expectedXor = IntStream.rangeClosed(1, A.length + 1).reduce(0, (a, b) -> a ^ b);
            int actualXor = Arrays.stream(A).reduce(0, (a, b) -> a ^ b);
            return expectedXor ^ actualXor;
        }
    }

    public static void test(Solution solution) {
        Assertions.equalObjects(solution.solution(new int[]{}), 1);
        Assertions.equalObjects(solution.solution(new int[]{1}), 2);
        Assertions.equalObjects(solution.solution(new int[]{2}), 1);
        Assertions.equalObjects(solution.solution(new int[]{2, 3, 1, 5}), 4);
        Assertions.equalObjects(solution.solution(new int[]{2, 3, 4, 1, 5}), 6);
        int[] ints = new int[100000];
        for (int i = 1; i <= ints.length; ++i) {
            ints[i - 1] = i < 23333 ? i : i + 1;
        }
        Assertions.equalObjects(solution.solution(ints), 23333);
    }
}
