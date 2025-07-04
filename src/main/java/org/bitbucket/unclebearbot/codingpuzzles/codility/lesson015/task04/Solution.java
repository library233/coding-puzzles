package org.bitbucket.unclebearbot.codingpuzzles.codility.lesson015.task04;

import org.bitbucket.unclebearbot.utils.Assertions;

import java.util.Arrays;

/*

https://app.codility.com/programmers/lessons/15-caterpillar_method/min_abs_sum_of_two

# MinAbsSumOfTwo
# Find the minimal absolute value of a sum of two elements.

Let A be a non-empty array consisting of N integers.

The abs sum of two for a pair of indices (P, Q) is the absolute value |A[P] + A[Q]|, for 0 ≤ P ≤ Q < N.

For example, the following array A:
    A[0] =  1
    A[1] =  4
    A[2] = -3
has pairs of indices (0, 0), (0, 1), (0, 2), (1, 1), (1, 2), (2, 2).
The abs sum of two for the pair (0, 0) is A[0] + A[0] = |1 + 1| = 2.
The abs sum of two for the pair (0, 1) is A[0] + A[1] = |1 + 4| = 5.
The abs sum of two for the pair (0, 2) is A[0] + A[2] = |1 + (−3)| = 2.
The abs sum of two for the pair (1, 1) is A[1] + A[1] = |4 + 4| = 8.
The abs sum of two for the pair (1, 2) is A[1] + A[2] = |4 + (−3)| = 1.
The abs sum of two for the pair (2, 2) is A[2] + A[2] = |(−3) + (−3)| = 6.

Write a function:
    class Solution { public int solution(int[] A); }
that, given a non-empty array A consisting of N integers, returns the minimal abs sum of two for any pair of indices in this array.

For example, given the following array A:
    A[0] =  1
    A[1] =  4
    A[2] = -3
the function should return 1, as explained above.

Given array A:
    A[0] = -8
    A[1] =  4
    A[2] =  5
    A[3] =-10
    A[4] =  3
the function should return |(−8) + 5| = 3.

Write an efficient algorithm for the following assumptions:
    N is an integer within the range [1..100,000];
    each element of array A is an integer within the range [−1,000,000,000..1,000,000,000].

 */

public class Solution {
    public static void main(String[] args) {
        test(new Solution());
        System.out.println(Solution.class);
    }

    public int solution(int[] A) {
        int n = A.length;
        int candidate = Integer.MAX_VALUE;
        int[] clone = A.clone();
        Arrays.sort(clone);
        for (int i = 0; i < n; ++i) {
            int temp = Math.abs(clone[i] + clone[i]);
            if (temp < candidate) {
                candidate = temp;
            }
        }
        int left = 0;
        int right = n - 1;
        while (left < right) {
            int sum = clone[left] + clone[right];
            int absSum = Math.abs(sum);
            if (absSum < candidate) {
                candidate = absSum;
            }
            if (sum < 0) {
                ++left;
            } else {
                --right;
            }
        }
        return candidate;
    }

    public static void test(Solution solution) {
        Assertions.equalObjects(solution.solution(new int[]{1, 4, -3}), 1);
        Assertions.equalObjects(solution.solution(new int[]{-8, 4, 5, -10, 3}), 3);
        Assertions.equalObjects(solution.solution(new int[]{1, 1}), 2);
        Assertions.equalObjects(solution.solution(new int[]{1, 2, 3}), 2);
        Assertions.equalObjects(solution.solution(new int[]{-1, 0, 1}), 0);
        Assertions.equalObjects(solution.solution(new int[]{-5, -3, -1, 0, 3, 6}), 0);
    }
}
