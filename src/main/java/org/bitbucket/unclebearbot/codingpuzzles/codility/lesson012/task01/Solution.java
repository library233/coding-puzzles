package org.bitbucket.unclebearbot.codingpuzzles.codility.lesson012.task01;

import org.bitbucket.unclebearbot.codingpuzzles.utils.Assertions;

/*

https://app.codility.com/programmers/lessons/12-euclidean_algorithm/chocolates_by_numbers

# ChocolatesByNumbers
# There are N chocolates in a circle. Count the number of chocolates you will eat.

Two positive integers N and M are given.
Integer N represents the number of chocolates arranged in a circle, numbered from 0 to N − 1.

You start to eat the chocolates.
After eating a chocolate you leave only a wrapper.

You begin with eating chocolate number 0.
Then you omit the next M − 1 chocolates or wrappers on the circle, and eat the following one.

More precisely, if you ate chocolate number X, then you will next eat the chocolate with number (X + M) modulo N (remainder of division).

You stop eating when you encounter an empty wrapper.

For example, given integers N = 10 and M = 4.
You will eat the following chocolates: 0, 4, 8, 2, 6.

The goal is to count the number of chocolates that you will eat, following the above rules.

Write a function:
    class Solution { public int solution(int N, int M); }
that, given two positive integers N and M, returns the number of chocolates that you will eat.

For example, given integers N = 10 and M = 4.
the function should return 5, as explained above.

Write an efficient algorithm for the following assumptions:
    N and M are integers within the range [1..1,000,000,000].

 */

public class Solution {
    public static void main(String[] args) {
        test(new Solution());
    }

    public int solution(int N, int M) {
        int gcd = N;
        while (M != 0) {
            int temp = M;
            M = gcd % M;
            gcd = temp;
        }
        return N / gcd;
    }

    public static void test(Solution solution) {
        Assertions.equalObjects(solution.solution(10, 4), 5);
        Assertions.equalObjects(solution.solution(12, 3), 4);
        Assertions.equalObjects(solution.solution(17, 5), 17);
        Assertions.equalObjects(solution.solution(1, 1), 1);
        Assertions.equalObjects(solution.solution(1000000, 1), 1000000);
        Assertions.equalObjects(solution.solution(1000000, 1000000), 1);
        Assertions.equalObjects(solution.solution(999999, 999999), 1);
        Assertions.equalObjects(solution.solution(999999, 2), 999999);
    }
}
