package org.bitbucket.unclebearbot.codingpuzzles.codility.lesson002.task01;

import org.bitbucket.unclebearbot.codingpuzzles.utils.Assertions;

/*

https://app.codility.com/programmers/lessons/2-arrays/cyclic_rotation

# CyclicRotation
# Rotate an array to the right by a given number of steps.

An array A consisting of N integers is given.
Rotation of the array means that each element is shifted right by one index, and the last element of the array is moved to the first place.
For example, the rotation of array A = [3, 8, 9, 7, 6] is [6, 3, 8, 9, 7] (elements are shifted right by one index and 6 is moved to the first place).

The goal is to rotate array A K times; that is, each element of A will be shifted to the right K times.

Write a function:
    class Solution { public int[] solution(int[] A, int K); }
that, given an array A consisting of N integers and an integer K, returns the array A rotated K times.

For example, given
    A = [3, 8, 9, 7, 6]
    K = 3
the function should return [9, 7, 6, 3, 8].
Three rotations were made:
    [3, 8, 9, 7, 6] -> [6, 3, 8, 9, 7]
    [6, 3, 8, 9, 7] -> [7, 6, 3, 8, 9]
    [7, 6, 3, 8, 9] -> [9, 7, 6, 3, 8]

For another example, given
    A = [0, 0, 0]
    K = 1
the function should return [0, 0, 0].

Given
    A = [1, 2, 3, 4]
    K = 4
the function should return [1, 2, 3, 4].

Assume that:
    N and K are integers within the range [0..100];
    each element of array A is an integer within the range [−1,000..1,000].

In your solution, focus on correctness.
The performance of your solution will not be the focus of the assessment.

 */

public class Solution {
    public static void main(String[] args) {
        test(new Solution());
    }

    public int[] solution(int[] A, int K) {
        if (A == null || A.length <= 1) {
            return A;
        }
        int length = A.length;
        int offset = K % length;
        if (offset == 0) {
            return A;
        }
        int[] rotated = new int[length];
        for (int i = 0; i < length; ++i) {
            rotated[(i + offset) % length] = A[i];
        }
        return rotated;
    }

    public static void test(Solution solution) {
        Assertions.equalArrays(solution.solution(new int[]{1, 2, 3, 4}, 1), new int[]{4, 1, 2, 3});
        Assertions.equalArrays(solution.solution(new int[]{1, 2, 3, 4}, 2), new int[]{3, 4, 1, 2});
        Assertions.equalArrays(solution.solution(new int[]{1, 2, 3, 4}, 3), new int[]{2, 3, 4, 1});
        Assertions.equalArrays(solution.solution(new int[]{1, 2, 3, 4}, 4), new int[]{1, 2, 3, 4});
        Assertions.equalArrays(solution.solution(new int[]{1, 2, 3, 4}, 5), new int[]{4, 1, 2, 3});
        Assertions.equalArrays(solution.solution(new int[]{1, 2, 3, 4}, 111), new int[]{2, 3, 4, 1});
        Assertions.equalArrays(solution.solution(new int[]{}, 1), new int[]{});
        Assertions.equalArrays(solution.solution(new int[]{1}, 1), new int[]{1});
    }
}
