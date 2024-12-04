package org.bitbucket.unclebearbot.codingpuzzles.codility.lesson005.task03;

import org.bitbucket.unclebearbot.codingpuzzles.utils.Assertion;

/*

https://app.codility.com/programmers/lessons/5-prefix_sums/genomic_range_query

A DNA sequence can be represented as a string consisting of the letters A, C, G and T, which correspond to the types of successive nucleotides in the sequence.
Each nucleotide has an impact factor, which is an integer.
Nucleotides of types A, C, G and T have impact factors of 1, 2, 3 and 4, respectively.
You are going to answer several queries of the form: What is the minimal impact factor of nucleotides contained in a particular part of the given DNA sequence?

The DNA sequence is given as a non-empty string S = S[0]S[1]...S[N-1] consisting of N characters.
There are M queries, which are given in non-empty arrays P and Q, each consisting of M integers.
The K-th query (0 ≤ K < M) requires you to find the minimal impact factor of nucleotides contained in the DNA sequence between positions P[K] and Q[K] (inclusive).

For example, consider string S = CAGCCTA and arrays P, Q such that:
    P[0] = 2    Q[0] = 4
    P[1] = 5    Q[1] = 5
    P[2] = 0    Q[2] = 6

The answers to these M = 3 queries are as follows:
    The part of the DNA between positions 2 and 4 contains nucleotides G and C (twice), whose impact factors are 3 and 2 respectively, so the answer is 2.
    The part between positions 5 and 5 contains a single nucleotide T, whose impact factor is 4, so the answer is 4.
    The part between positions 0 and 6 (the whole string) contains all nucleotides, in particular nucleotide A whose impact factor is 1, so the answer is 1.

Write a function:
    class Solution { public int[] solution(String S, int[] P, int[] Q); }
that, given a non-empty string S consisting of N characters and two non-empty arrays P and Q consisting of M integers, returns an array consisting of M integers specifying the consecutive answers to all queries.

Result array should be returned as an array of integers.

For example, given the string S = CAGCCTA and arrays P, Q such that:
    P[0] = 2    Q[0] = 4
    P[1] = 5    Q[1] = 5
    P[2] = 0    Q[2] = 6
the function should return the values [2, 4, 1], as explained above.

Write an efficient algorithm for the following assumptions:
    N is an integer within the range [1..100,000];
    M is an integer within the range [1..50,000];
    each element of arrays P and Q is an integer within the range [0..N - 1];
    P[K] ≤ Q[K], where 0 ≤ K < M;
    string S consists only of upper-case English letters A, C, G, T.

 */

public class Solution {
    public static void main(String[] args) {
        test(new Solution());
    }

    public int[] solution(String S, int[] P, int[] Q) {
        int sequenceLength = S.length();
        int queryLength = P.length;
        int[][] prefixCounts = new int[4][sequenceLength + 1];
        for (int i = 0; i < sequenceLength; ++i) {
            char nucleotide = S.charAt(i);
            int impact = "ACGT".indexOf(nucleotide) + 1;
            for (int j = 0; j < 4; ++j) {
                prefixCounts[j][i + 1] = prefixCounts[j][i];
            }
            ++prefixCounts[impact - 1][i + 1];
        }
        int[] result = new int[queryLength];
        for (int i = 0; i < queryLength; ++i) {
            int start = P[i];
            int end = Q[i] + 1;
            for (int j = 0; j < 4; ++j) {
                if (prefixCounts[j][end] - prefixCounts[j][start] > 0) {
                    result[i] = j + 1;
                    break;
                }
            }
        }
        return result;
    }

    public static void test(Solution solution) {
        Assertion.equalArrays(solution.solution("A", new int[]{0}, new int[]{0}), new int[]{1});
        Assertion.equalArrays(solution.solution("TGCA", new int[]{0, 1, 2, 3}, new int[]{0, 1, 2, 3}), new int[]{4, 3, 2, 1});
        Assertion.equalArrays(solution.solution("AATCG", new int[]{0, 2}, new int[]{1, 4}), new int[]{1, 2});
        Assertion.equalArrays(solution.solution("CAGCCTA", new int[]{2, 5, 0}, new int[]{4, 5, 6}), new int[]{2, 4, 1});
    }
}
