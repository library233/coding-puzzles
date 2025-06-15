package org.bitbucket.unclebearbot.codingpuzzles.codility.lesson015.task01;

import org.bitbucket.unclebearbot.utils.Assertions;

/*

https://app.codility.com/programmers/lessons/15-caterpillar_method/abs_distinct

# AbsDistinct
# Compute number of distinct absolute values of sorted array elements.

A non-empty array A consisting of N numbers is given.
The array is sorted in non-decreasing order.
The absolute distinct count of this array is the number of distinct absolute values among the elements of the array.

For example, consider array A such that:
    A[0] = -5
    A[1] = -3
    A[2] = -1
    A[3] =  0
    A[4] =  3
    A[5] =  6

The absolute distinct count of this array is 5, because there are 5 distinct absolute values among the elements of this array, namely 0, 1, 3, 5 and 6.

Write a function:
    class Solution { public int solution(int[] A); }
that, given a non-empty array A consisting of N numbers, returns absolute distinct count of array A.

For example, given array A such that:
    A[0] = -5
    A[1] = -3
    A[2] = -1
    A[3] =  0
    A[4] =  3
    A[5] =  6
the function should return 5, as explained above.

Write an efficient algorithm for the following assumptions:
    N is an integer within the range [1..100,000];
    each element of array A is an integer within the range [−2,147,483,648..2,147,483,647];
    array A is sorted in non-decreasing order.

 */

public class Solution {
    public static void main(String[] args) {
        test(new Solution());
        System.out.println(Solution.class);
    }

    public int solution(int[] A) {
        int n = A.length;
        int count = 0;
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int absLeft = Math.abs(A[left]), absRight = Math.abs(A[right]);
            if (absLeft == absRight) {
                ++count;
                while (left <= right && Math.abs(A[left]) == absLeft) {
                    ++left;
                }
                while (left <= right && Math.abs(A[right]) == absRight) {
                    --right;
                }
            } else if (absLeft < absRight) {
                ++count;
                while (left <= right && Math.abs(A[right]) == absRight) {
                    --right;
                }
            } else {
                ++count;
                while (left <= right && Math.abs(A[left]) == absLeft) {
                    ++left;
                }
            }
        }
        return count;
    }

    public static void test(Solution solution) {
        Assertions.equalObjects(solution.solution(new int[]{-5, -3, -1, 0, 3, 6}), 5);
        Assertions.equalObjects(solution.solution(new int[]{-3, -2, 2, 3}), 2);
        Assertions.equalObjects(solution.solution(new int[]{-1, -1, 0, 1, 1}), 2);
        Assertions.equalObjects(solution.solution(new int[]{-10, -10, -5, 0, 5, 10}), 3);
        Assertions.equalObjects(solution.solution(new int[]{1, 2, 3, 4, 5}), 5);
    }
}
