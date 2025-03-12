package org.bitbucket.unclebearbot.codingpuzzles.codility.lesson008.task02;

import org.bitbucket.unclebearbot.codingpuzzles.utils.Assertions;

/*

https://app.codility.com/programmers/lessons/8-leader/equi_leader

# EquiLeader
# Find the index S such that the leaders of the sequences A[0], A[1], ..., A[S] and A[S + 1], A[S + 2], ..., A[N - 1] are the same.

A non-empty array A consisting of N integers is given.

The leader of this array is the value that occurs in more than half of the elements of A.

An equi leader is an index S such that 0 ≤ S < N − 1 and two sequences A[0], A[1], ..., A[S] and A[S + 1], A[S + 2], ..., A[N − 1] have leaders of the same value.

For example, given array A such that:
    A[0] = 4
    A[1] = 3
    A[2] = 4
    A[3] = 4
    A[4] = 4
    A[5] = 2
we can find two equi leaders:
    0, because sequences: (4) and (3, 4, 4, 4, 2) have the same leader, whose value is 4.
    2, because sequences: (4, 3, 4) and (4, 4, 2) have the same leader, whose value is 4.

The goal is to count the number of equi leaders.

Write a function:
    class Solution { public int solution(int[] A); }
that, given a non-empty array A consisting of N integers, returns the number of equi leaders.

For example, given:
    A[0] = 4
    A[1] = 3
    A[2] = 4
    A[3] = 4
    A[4] = 4
    A[5] = 2
the function should return 2, as explained above.

Write an efficient algorithm for the following assumptions:
    N is an integer within the range [1..100,000];
    each element of array A is an integer within the range [−1,000,000,000..1,000,000,000].

 */

public class Solution {
    public static void main(String[] args) {
        test(new Solution());
    }

    public int solution(int[] A) {
        int n = A.length;
        if (n == 0) {
            return 0;
        }
        int candidate = -1;
        int count = 0;
        for (int val : A) {
            if (count == 0) {
                candidate = val;
                count = 1;
            } else if (candidate == val) {
                ++count;
            } else {
                --count;
            }
        }
        int leader = -1;
        int leaderCount = 0;
        for (int val : A) {
            if (val == candidate) {
                ++leaderCount;
            }
        }
        if (leaderCount > n / 2) {
            leader = candidate;
        } else {
            return 0;
        }

        int equiLeaders = 0;
        int leftLeaderCount = 0;
        for (int i = 0; i < n - 1; ++i) {
            if (A[i] == leader) {
                ++leftLeaderCount;
            }
            int leftLength = i + 1;
            int rightLength = n - 1 - i;
            if (leftLeaderCount > leftLength / 2 && (leaderCount - leftLeaderCount) > rightLength / 2) {
                ++equiLeaders;
            }
        }
        return equiLeaders;
    }

    public static void test(Solution solution) {
        Assertions.equalObjects(solution.solution(new int[]{4, 3, 4, 4, 4, 2}), 2);
        Assertions.equalObjects(solution.solution(new int[]{1, 2, 3, 4, 5}), 0);
        Assertions.equalObjects(solution.solution(new int[]{0, 0}), 1);
        Assertions.equalObjects(solution.solution(new int[]{0, 0, 0}), 2);
        Assertions.equalObjects(solution.solution(new int[]{1, 1, 1, 2, 2}), 0);
    }
}
