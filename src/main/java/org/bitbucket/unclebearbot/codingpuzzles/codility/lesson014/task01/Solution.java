package org.bitbucket.unclebearbot.codingpuzzles.codility.lesson014.task01;

import org.bitbucket.unclebearbot.codingpuzzles.utils.Assertions;

/*

https://app.codility.com/programmers/lessons/14-binary_search_algorithm/min_max_division

# MinMaxDivision
# Divide array A into K blocks and minimize the largest sum of any block.

You are given integers K, M and a non-empty array A consisting of N integers.
Every element of the array is not greater than M.

You should divide this array into K blocks of consecutive elements.
The size of the block is any integer between 0 and N.
Every element of the array should belong to some block.

The sum of the block from X to Y equals A[X] + A[X + 1] + ... + A[Y].
The sum of empty block equals 0.

The large sum is the maximal sum of any block.

For example, you are given integers K = 3, M = 5 and array A such that:
    A[0] = 2
    A[1] = 1
    A[2] = 5
    A[3] = 1
    A[4] = 2
    A[5] = 2
    A[6] = 2

The array can be divided, for example, into the following blocks:
    [2, 1, 5, 1, 2, 2, 2], [], [] with a large sum of 15;
    [2], [1, 5, 1, 2], [2, 2] with a large sum of 9;
    [2, 1, 5], [], [1, 2, 2, 2] with a large sum of 8;
    [2, 1], [5, 1], [2, 2, 2] with a large sum of 6.

The goal is to minimize the large sum.
In the above example, 6 is the minimal large sum.

Write a function:
    class Solution { public int solution(int K, int M, int[] A); }
that, given integers K, M and a non-empty array A consisting of N integers, returns the minimal large sum.

For example, given K = 3, M = 5 and array A such that:
    A[0] = 2
    A[1] = 1
    A[2] = 5
    A[3] = 1
    A[4] = 2
    A[5] = 2
    A[6] = 2
the function should return 6, as explained above.

Write an efficient algorithm for the following assumptions:
    N and K are integers within the range [1..100,000];
    M is an integer within the range [0..10,000];
    each element of array A is an integer within the range [0..M].

 */

public class Solution {
    public static void main(String[] args) {
        test(new Solution());
        System.out.println(Solution.class);
    }

    public int solution(int K, int M, int[] A) {
        int n = A.length, low = 0, high = 0;
        for (int k : A) {
            high += k;
            if (k > low) low = k;
        }
        int result = high;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int blocks = 1, sum = 0;
            for (int j : A) {
                if (sum + j > mid) {
                    ++blocks;
                    sum = j;
                } else {
                    sum += j;
                }
            }
            if (blocks <= K) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return result;
    }

    public static void test(Solution solution) {
        Assertions.equalObjects(solution.solution(3, 5, new int[]{2, 1, 5, 1, 2, 2, 2}), 6);
        Assertions.equalObjects(solution.solution(1, 5, new int[]{2, 1, 5, 1, 2, 2, 2}), 15);
        Assertions.equalObjects(solution.solution(3, 5, new int[]{0, 0, 0, 0}), 0);
        Assertions.equalObjects(solution.solution(2, 5, new int[]{1, 1, 1, 1, 1}), 3);
        Assertions.equalObjects(solution.solution(3, 10, new int[]{7, 2, 5, 10, 8}), 14);
    }
}
