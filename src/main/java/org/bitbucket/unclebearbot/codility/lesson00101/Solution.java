package org.bitbucket.unclebearbot.codility.lesson00101;

import org.bitbucket.unclebearbot.codility.utils.Assertion;

/*

https://app.codility.com/programmers/lessons/1-iterations/binary_gap

A binary gap within a positive integer N is any maximal sequence of consecutive zeros that is surrounded by ones at both ends in the binary representation of N.

For example, number 9 has binary representation 1001 and contains a binary gap of length 2.
The number 529 has binary representation 1000010001 and contains two binary gaps: one of length 4 and one of length 3.
The number 20 has binary representation 10100 and contains one binary gap of length 1.
The number 15 has binary representation 1111 and has no binary gaps.
The number 32 has binary representation 100000 and has no binary gaps.

Write a function:
    class Solution { public int solution(int N); }
that, given a positive integer N, returns the length of its longest binary gap.
The function should return 0 if N doesn't contain a binary gap.

For example, given N = 1041 the function should return 5, because N has binary representation 10000010001 and so its longest binary gap is of length 5.
Given N = 32 the function should return 0, because N has binary representation '100000' and thus no binary gaps.

Write an efficient algorithm for the following assumptions:
    N is an integer within the range [1..2,147,483,647].

 */

public class Solution {
    public static void main(String[] args) {
        test(new Solution());
    }

    public int solution(int N) {
        String binary = Integer.toBinaryString(N);
        String[] gaps = binary.split("1");
        int max = 0;
        for (int i = 0; i < gaps.length; ++i) {
            if (i < gaps.length - 1 || binary.endsWith("1")) {
                max = Math.max(max, gaps[i].length());
            }
        }
        return max;
    }

    public static void test(Solution solution) {
        Assertion.equalObjects(solution.solution(0 /* 0 */), 0);
        Assertion.equalObjects(solution.solution(1 /* 1 */), 0);
        Assertion.equalObjects(solution.solution(2 /* 10 */), 0);
        Assertion.equalObjects(solution.solution(5 /* 101 */), 1);
        Assertion.equalObjects(solution.solution(6 /* 110 */), 0);
        Assertion.equalObjects(solution.solution(8 /* 1000 */), 0);
        Assertion.equalObjects(solution.solution(15 /* 1111 */), 0);
        Assertion.equalObjects(solution.solution(20 /* 10100 */), 1);
        Assertion.equalObjects(solution.solution(32 /* 100000 */), 0);
        Assertion.equalObjects(solution.solution(529 /* 1000010001 */), 4);
        Assertion.equalObjects(solution.solution(561 /* 1000110001 */), 3);
        Assertion.equalObjects(solution.solution(1041 /* 10000010001 */), 5);
        Assertion.equalObjects(solution.solution(1162 /* 10010001010 */), 3);
        Assertion.equalObjects(solution.solution(1073741825 /* 1000000000000000000000000000001 */), 29);
        Assertion.equalObjects(solution.solution(2147483647 /* 1111111111111111111111111111111 */), 0);
    }
}
