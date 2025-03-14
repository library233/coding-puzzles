package org.bitbucket.unclebearbot.codingpuzzles.codility.lesson015.task03;

import org.bitbucket.unclebearbot.codingpuzzles.utils.Assertions;

import java.util.Arrays;

/*

https://app.codility.com/programmers/lessons/15-caterpillar_method/count_triangles

# CountTriangles
# Count the number of triangles that can be built from a given set of edges.

An array A consisting of N integers is given.
A triplet (P, Q, R) is triangular if it is possible to build a triangle with sides of lengths A[P], A[Q] and A[R].
In other words, triplet (P, Q, R) is triangular if 0 ≤ P < Q < R < N and:
    A[P] + A[Q] > A[R],
    A[Q] + A[R] > A[P],
    A[R] + A[P] > A[Q].

For example, consider array A such that:
    A[0] = 10    A[1] = 2    A[2] = 5
    A[3] = 1     A[4] = 8    A[5] = 12

There are four triangular triplets that can be constructed from elements of this array, namely (0, 2, 4), (0, 2, 5), (0, 4, 5), and (2, 4, 5).

Write a function:
    class Solution { public int solution(int[] A); }
that, given an array A consisting of N integers, returns the number of triangular triplets in this array.

For example, given array A such that:
    A[0] = 10    A[1] = 2    A[2] = 5
    A[3] = 1     A[4] = 8    A[5] = 12
the function should return 4, as explained above.

Write an efficient algorithm for the following assumptions:
    N is an integer within the range [0..1,000];
    each element of array A is an integer within the range [1..1,000,000,000].

 */

public class Solution {
    public static void main(String[] args) {
        test(new Solution());
        System.out.println(Solution.class);
    }

    public int solution(int[] A) {
        int n = A.length;
        if (n < 3) return 0;
        Arrays.sort(A);
        int count = 0;
        for (int r = n - 1; r >= 2; --r) {
            int i = 0, j = r - 1;
            while (i < j) {
                if (A[i] + A[j] > A[r]) {
                    count += (j - i);
                    --j;
                } else {
                    ++i;
                }
            }
        }
        return count;
    }

    public static void test(Solution solution) {
        Assertions.equalObjects(solution.solution(new int[]{10, 2, 5, 1, 8, 12}), 4);
        Assertions.equalObjects(solution.solution(new int[]{10, 2, 2, 1}), 1);
        Assertions.equalObjects(solution.solution(new int[]{1, 2, 3, 4, 5}), 3);
        Assertions.equalObjects(solution.solution(new int[]{10, 10, 10}), 1);
    }
}
