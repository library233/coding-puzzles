package org.bitbucket.unclebearbot.codingpuzzles.codility.lesson012.task02;

import org.bitbucket.unclebearbot.codingpuzzles.utils.Assertions;

import java.util.HashSet;
import java.util.Set;

/*

https://app.codility.com/programmers/lessons/12-euclidean_algorithm/common_prime_divisors

# CommonPrimeDivisors
# Check whether two numbers have the same prime divisors.

A prime is a positive integer X that has exactly two distinct divisors: 1 and X.
The first few prime integers are 2, 3, 5, 7, 11 and 13.

A prime D is called a prime divisor of a positive integer P if there exists a positive integer K such that D * K = P.
For example, 2 and 5 are prime divisors of 20.

You are given two positive integers N and M.
The goal is to check whether the sets of prime divisors of integers N and M are exactly the same.

For example, given:
    N = 15 and M = 75, the prime divisors are the same: {3, 5};
    N = 10 and M = 30, the prime divisors aren't the same: {2, 5} is not equal to {2, 3, 5};
    N = 9 and M = 5, the prime divisors aren't the same: {3} is not equal to {5}.

Write a function:
    class Solution { public int solution(int[] A, int[] B); }
that, given two non-empty arrays A and B of Z integers, returns the number of positions K for which the prime divisors of A[K] and B[K] are exactly the same.

For example, given:
    A[0] = 15   B[0] = 75
    A[1] = 10   B[1] = 30
    A[2] = 3    B[2] = 5
the function should return 1, because only one pair (15, 75) has the same set of prime divisors.

Write an efficient algorithm for the following assumptions:
    Z is an integer within the range [1..6,000];
    each element of arrays A and B is an integer within the range [1..2,147,483,647].

 */

public class Solution {
    public static void main(String[] args) {
        test(new Solution());
    }

    public int solution(int[] A, int[] B) {
        int count = 0;
        for (int i = 0; i < A.length; ++i) {
            if (hasSamePrimeDivisors(A[i], B[i])) {
                ++count;
            }
        }
        return count;
    }

    private boolean hasSamePrimeDivisors(int N, int M) {
        Set<Integer> primeDivisorsN = getPrimeDivisors(N);
        Set<Integer> primeDivisorsM = getPrimeDivisors(M);
        return primeDivisorsN.equals(primeDivisorsM);
    }

    private Set<Integer> getPrimeDivisors(int num) {
        Set<Integer> divisors = new HashSet<>();
        if (num == 1) {
            return divisors;
        }
        while (num % 2 == 0) {
            divisors.add(2);
            num /= 2;
        }
        for (int i = 3; i * i <= num; i += 2) {
            while (num % i == 0) {
                divisors.add(i);
                num /= i;
            }
        }
        if (num > 1) {
            divisors.add(num);
        }
        return divisors;
    }

    public static void test(Solution solution) {
        Assertions.equalObjects(solution.solution(new int[]{15, 10, 3}, new int[]{75, 30, 5}), 1);
        Assertions.equalObjects(solution.solution(new int[]{15}, new int[]{75}), 1);
        Assertions.equalObjects(solution.solution(new int[]{10}, new int[]{30}), 0);
        Assertions.equalObjects(solution.solution(new int[]{9}, new int[]{5}), 0);
        Assertions.equalObjects(solution.solution(new int[]{1}, new int[]{1}), 1);
        Assertions.equalObjects(solution.solution(new int[]{2}, new int[]{4}), 1);
        Assertions.equalObjects(solution.solution(new int[]{6}, new int[]{12}), 1);
        Assertions.equalObjects(solution.solution(new int[]{21}, new int[]{42}), 0);
        Assertions.equalObjects(solution.solution(new int[]{2 * 3 * 5 * 7}, new int[]{2 * 3 * 5 * 7 * 11}), 0);
        Assertions.equalObjects(solution.solution(new int[]{2 * 3 * 5 * 7 * 11}, new int[]{2 * 3 * 5 * 7}), 0);
        Assertions.equalObjects(solution.solution(new int[]{2 * 3 * 5 * 7}, new int[]{2 * 2 * 3 * 3 * 5 * 5 * 7 * 7}), 1);
    }
}
