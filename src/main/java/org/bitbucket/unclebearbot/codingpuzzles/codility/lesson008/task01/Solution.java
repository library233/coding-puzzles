package org.bitbucket.unclebearbot.codingpuzzles.codility.lesson008.task01;

import org.bitbucket.unclebearbot.utils.Assertions;

/*

https://app.codility.com/programmers/lessons/8-leader/dominator

# Dominator
# Find an index of an array such that its value occurs at more than half of indices in the array.

An array A consisting of N integers is given.
The dominator of array A is the value that occurs in more than half of the elements of A.

For example, consider array A such that
    A[0] = 3    A[1] = 4    A[2] =  3
    A[3] = 2    A[4] = 3    A[5] = -1
    A[6] = 3    A[7] = 3

The dominator of A is 3 because it occurs in 5 out of 8 elements of A (namely in those with indices 0, 2, 4, 6 and 7) and 5 is more than a half of 8.

Write a function
    class Solution { public int solution(int[] A); }
that, given an array A consisting of N integers, returns index of any element of array A in which the dominator of A occurs.
The function should return −1 if array A does not have a dominator.

For example, given array A such that
    A[0] = 3    A[1] = 4    A[2] =  3
    A[3] = 2    A[4] = 3    A[5] = -1
    A[6] = 3    A[7] = 3
the function may return 0, 2, 4, 6 or 7, as explained above.

Write an efficient algorithm for the following assumptions:
    N is an integer within the range [0..100,000];
    each element of array A is an integer within the range [−2,147,483,648..2,147,483,647].

 */

public class Solution {
    public static void main(String[] args) {
        test(new Solution());
        System.out.println(Solution.class);
    }

    public int solution(int[] A) {
        int size = 0, candidate = 0;
        for (int value : A) {
            if (size == 0) {
                candidate = value;
                ++size;
            } else if (value == candidate) {
                ++size;
            } else {
                --size;
            }
        }
        int count = 0, index = -1;
        for (int i = 0; i < A.length; ++i) {
            if (A[i] == candidate) {
                ++count;
                if (index == -1) {
                    index = i;
                }
            }
        }
        return count > A.length / 2 ? index : -1;
    }

    public static void test(Solution solution) {
        Assertions.equalObjects(solution.solution(new int[]{3, 4, 3, 2, 3, -1, 3, 3}), 0);
        Assertions.equalObjects(solution.solution(new int[]{1, 2, 3, 4, 5}), -1);
        Assertions.equalObjects(solution.solution(new int[]{2, 2, 2, 2, 2}), 0);
        Assertions.equalObjects(solution.solution(new int[]{1, 1, 1, 2, 2, 2, 1}), 0);
        Assertions.equalObjects(solution.solution(new int[]{1}), 0);
    }
}
