package org.bitbucket.unclebearbot.codingpuzzles.codility.lesson011.task02;

import org.bitbucket.unclebearbot.codingpuzzles.utils.Assertions;

/*

https://app.codility.com/programmers/lessons/11-sieve_of_eratosthenes/count_semiprimes

# CountSemiprimes
# Count the semiprime numbers in the given range [a..b]

A prime is a positive integer X that has exactly two distinct divisors: 1 and X.
The first few prime integers are 2, 3, 5, 7, 11 and 13.

A semiprime is a natural number that is the product of two (not necessarily distinct) prime numbers.
The first few semiprimes are 4, 6, 9, 10, 14, 15, 21, 22, 25, 26.

You are given two non-empty arrays P and Q, each consisting of M integers.
These arrays represent queries about the number of semiprimes within specified ranges.

Query K requires you to find the number of semiprimes within the range (P[K], Q[K]), where 1 ≤ P[K] ≤ Q[K] ≤ N.

For example, consider an integer N = 26 and arrays P, Q such that:
    P[0] = 1    Q[0] = 26
    P[1] = 4    Q[1] = 10
    P[2] = 16   Q[2] = 20

The number of semiprimes within each of these ranges is as follows:
    (1, 26) is 10,
    (4, 10) is 4,
    (16, 20) is 0.

Write a function:
    class Solution { public int[] solution(int N, int[] P, int[] Q); }
that, given an integer N and two non-empty arrays P and Q consisting of M integers, returns an array consisting of M elements specifying the consecutive answers to all the queries.

For example, given an integer N = 26 and arrays P, Q such that:
    P[0] = 1    Q[0] = 26
    P[1] = 4    Q[1] = 10
    P[2] = 16   Q[2] = 20
the function should return the values [10, 4, 0], as explained above.

Write an efficient algorithm for the following assumptions:
    N is an integer within the range [1..50,000];
    M is an integer within the range [1..30,000];
    each element of arrays P and Q is an integer within the range [1..N];
    P[i] ≤ Q[i].

 */

public class Solution {
    public static void main(String[] args) {
        test(new Solution());
        System.out.println(Solution.class);
    }

    public int[] solution(int N, int[] P, int[] Q) {
        boolean[] prime = new boolean[N + 1];
        for (int i = 2; i <= N; ++i) {
            prime[i] = true;
        }
        for (int i = 2; i * i <= N; ++i) {
            if (prime[i]) {
                for (int j = i * i; j <= N; j += i) {
                    prime[j] = false;
                }
            }
        }
        boolean[] isSemiprime = new boolean[N + 1];
        for (int i = 2; i <= N; ++i) {
            if (!prime[i]) {
                for (int j = 2; j * j <= i; ++j) {
                    if (i % j == 0) {
                        if (prime[j] && prime[i / j]) {
                            isSemiprime[i] = true;
                            break;
                        }
                        if (prime[j] && j * j == i) {
                            isSemiprime[i] = true;
                            break;
                        }
                    }
                }
            }
        }
        int[] semiprimeCounts = new int[N + 1];
        for (int i = 1; i <= N; ++i) {
            semiprimeCounts[i] = semiprimeCounts[i - 1] + (isSemiprime[i] ? 1 : 0);
        }
        int m = P.length;
        int[] result = new int[m];
        for (int i = 0; i < m; ++i) {
            result[i] = semiprimeCounts[Q[i]] - semiprimeCounts[P[i] - 1];
        }
        return result;
    }

    public static void test(Solution solution) {
        Assertions.equalArrays(solution.solution(26, new int[]{1, 4, 16}, new int[]{26, 10, 20}), new int[]{10, 4, 0});
        Assertions.equalArrays(solution.solution(30, new int[]{1, 5, 25}, new int[]{30, 15, 30}), new int[]{10, 5, 2});
        Assertions.equalArrays(solution.solution(1, new int[]{1}, new int[]{1}), new int[]{0});
        Assertions.equalArrays(solution.solution(4, new int[]{1, 4}, new int[]{4, 4}), new int[]{1, 1});
        Assertions.equalArrays(solution.solution(15, new int[]{1, 8, 12}, new int[]{15, 10, 15}), new int[]{6, 2, 2});
    }
}
