package org.bitbucket.unclebearbot.codingpuzzles.codility.lesson014.task02;

import org.bitbucket.unclebearbot.utils.Assertions;

/*

https://app.codility.com/programmers/lessons/14-binary_search_algorithm/nailing_planks

# NailingPlanks
# Count the minimum number of nails that allow a series of planks to be nailed.

You are given two non-empty arrays A and B consisting of N integers.
These arrays represent N planks.
More precisely, A[K] is the start and B[K] the end of the K−th plank.

Next, you are given a non-empty array C consisting of M integers.
This array represents M nails.
More precisely, C[I] is the position where you can hammer in the I−th nail.

We say that a plank (A[K], B[K]) is nailed if there exists a nail C[I] such that A[K] ≤ C[I] ≤ B[K].

The goal is to find the minimum number of nails that must be used until all the planks are nailed.
In other words, you should find a value J such that all planks will be nailed after using only the first J nails.
More precisely, for every plank (A[K], B[K]) such that 0 ≤ K < N, there should exist a nail C[I] such that I < J and A[K] ≤ C[I] ≤ B[K].

For example, given arrays A, B such that:
    A[0] = 1    B[0] = 4
    A[1] = 4    B[1] = 5
    A[2] = 5    B[2] = 9
    A[3] = 8    B[3] = 10
four planks are represented: [1, 4], [4, 5], [5, 9] and [8, 10].

Given array C such that:
    C[0] = 4
    C[1] = 6
    C[2] = 7
    C[3] = 10
    C[4] = 2
if we use the following nails:
    0, then planks [1, 4] and [4, 5] will both be nailed.
    0, 1, then planks [1, 4], [4, 5] and [5, 9] will be nailed.
    0, 1, 2, then planks [1, 4], [4, 5] and [5, 9] will be nailed.
    0, 1, 2, 3, then all the planks will be nailed.

Thus, four is the minimum number of nails that, used sequentially, allow all the planks to be nailed.

Write a function:
    class Solution { public int solution(int[] A, int[] B, int[] C); }
that, given two non-empty arrays A and B consisting of N integers and a non-empty array C consisting of M integers, returns the minimum number of nails that, used sequentially, allow all the planks to be nailed.

If it is not possible to nail all the planks, the function should return −1.

For example, given arrays A, B, C such that:
    A[0] = 1    B[0] = 4    C[0] = 4
    A[1] = 4    B[1] = 5    C[1] = 6
    A[2] = 5    B[2] = 9    C[2] = 7
    A[3] = 8    B[3] = 10   C[3] = 10
                            C[4] = 2
the function should return 4, as explained above.

Write an efficient algorithm for the following assumptions:
    N and M are integers within the range [1..30,000];
    each element of arrays A, B and C is an integer within the range [1..2*M];
    A[K] ≤ B[K].

 */

public class Solution {
    public static void main(String[] args) {
        test(new Solution());
        System.out.println(Solution.class);
    }

    public int solution(int[] A, int[] B, int[] C) {
        int n = A.length, m = C.length, maxPos = 2 * m;
        int L = maxPos + 1;
        int INF = m + 1;
        int[] earliest = new int[L];
        for (int i = 0; i < L; ++i) earliest[i] = INF;
        for (int i = 0; i < m; ++i) {
            int pos = C[i];
            if (earliest[pos] > i) earliest[pos] = i;
        }
        int[] logTable = new int[L + 1];
        logTable[1] = 0;
        for (int i = 2; i <= L; ++i) logTable[i] = logTable[i / 2] + 1;
        int K = logTable[L] + 1;
        int[][] st = new int[L][K];
        for (int i = 0; i < L; ++i) st[i][0] = earliest[i];
        for (int j = 1; j < K; ++j) {
            for (int i = 0; i + (1 << j) <= L; ++i) {
                st[i][j] = Math.min(st[i][j - 1], st[i + (1 << (j - 1))][j - 1]);
            }
        }
        int low = 1, high = m, result = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            boolean allNailed = true;
            for (int i = 0; i < n; ++i) {
                int from = A[i], to = B[i];
                int j = logTable[to - from + 1];
                int minIndex = Math.min(st[from][j], st[to - (1 << j) + 1][j]);
                if (minIndex >= mid) {
                    allNailed = false;
                    break;
                }
            }
            if (allNailed) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return result;
    }

    public static void test(Solution solution) {
        Assertions.equalObjects(solution.solution(new int[]{1, 4, 5, 8}, new int[]{4, 5, 9, 10}, new int[]{4, 6, 7, 10, 2}), 4);
        Assertions.equalObjects(solution.solution(new int[]{1, 2}, new int[]{1, 2}, new int[]{1, 2}), 2);
        Assertions.equalObjects(solution.solution(new int[]{1, 4, 5, 8}, new int[]{4, 5, 9, 10}, new int[]{4, 6, 7, 10, 2}), 4);
        Assertions.equalObjects(solution.solution(new int[]{1, 1, 1}, new int[]{1, 1, 1}, new int[]{2, 2, 2, 2}), -1);
    }
}
