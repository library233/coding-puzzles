package org.bitbucket.unclebearbot.codingpuzzles.codility.lesson017.task02;

import org.bitbucket.unclebearbot.codingpuzzles.utils.Assertions;

import java.util.BitSet;

/*

https://app.codility.com/programmers/lessons/17-dynamic_programming/min_abs_sum

# MinAbsSum
# Given array of integers, find the lowest absolute sum of elements.

For a given array A of N integers and a sequence S of N integers from the set {−1, 1}, we define val(A, S) as follows:
    val(A, S) = |sum{ A[i]*S[i] for i = 0..N−1 }|
(Assume that the sum of zero elements equals zero.)

For a given array A, we are looking for such a sequence S that minimizes val(A,S).

Write a function:
    class Solution { public int solution(int[] A); }
that, given an array A of N integers, computes the minimum value of val(A,S) from all possible values of val(A,S) for all possible sequences S of N integers from the set {−1, 1}.

For example, given array:
    A[0] =  1
    A[1] =  5
    A[2] =  2
    A[3] = -2
your function should return 0, since for S = [−1, 1, −1, 1], val(A, S) = 0, which is the minimum possible value.

Write an efficient algorithm for the following assumptions:
    N is an integer within the range [0..20,000];
    each element of array A is an integer within the range [−100..100].

 */

public class Solution {
    public static void main(String[] args) {
        test(new Solution());
        System.out.println(Solution.class);
    }

    public int solution(int[] A) {
        int total = 0;
        for (int a : A) {
            total += Math.abs(a);
        }
        BitSet possible = new BitSet(total + 1);
        possible.set(0);
        for (int a : A) {
            int x = Math.abs(a);
            BitSet shifted = new BitSet(total + 1);
            for (int i = possible.nextSetBit(0); i >= 0; i = possible.nextSetBit(i + 1)) {
                if (i + x <= total) shifted.set(i + x);
            }
            possible.or(shifted);
        }
        int result = total;
        for (int i = 0; i <= total / 2; ++i) {
            if (possible.get(i)) result = Math.min(result, total - 2 * i);
        }
        return result;
    }

    public static void test(Solution solution) {
        Assertions.equalObjects(solution.solution(new int[]{1, 5, 2, -2}), 0);
        Assertions.equalObjects(solution.solution(new int[]{1, 2, 3}), 0);
        Assertions.equalObjects(solution.solution(new int[]{3, 3, 3}), 3);
        Assertions.equalObjects(solution.solution(new int[]{1, 1, 2, 2}), 0);
        Assertions.equalObjects(solution.solution(new int[]{}), 0);
    }
}
