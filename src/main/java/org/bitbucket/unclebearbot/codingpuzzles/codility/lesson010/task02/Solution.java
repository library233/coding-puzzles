package org.bitbucket.unclebearbot.codingpuzzles.codility.lesson010.task02;

import org.bitbucket.unclebearbot.codingpuzzles.utils.Assertions;

/*

https://app.codility.com/programmers/lessons/10-prime_and_composite_numbers/min_perimeter_rectangle

# MinPerimeterRectangle
# Find the minimal perimeter of any rectangle whose area equals N.

An integer N is given, representing the area of some rectangle.

The area of a rectangle whose sides are of length A and B is A * B, and the perimeter is 2 * (A + B).

The goal is to find the minimal perimeter of any rectangle whose area equals N.
The sides of this rectangle should be only integers.

For example, given integer N = 30, rectangles of area 30 are:
    (1, 30), with a perimeter of 62,
    (2, 15), with a perimeter of 34,
    (3, 10), with a perimeter of 26,
    (5, 6), with a perimeter of 22.

Write a function:
    class Solution { public int solution(int N); }
that, given an integer N, returns the minimal perimeter of any rectangle whose area is exactly equal to N.

For example, given an integer N = 30, the function should return 22, as explained above.

Write an efficient algorithm for the following assumptions:
    N is an integer within the range [1..1,000,000,000].

 */

public class Solution {
    public static void main(String[] args) {
        test(new Solution());
        System.out.println(Solution.class);
    }

    public int solution(int N) {
        int minPerimeter = Integer.MAX_VALUE;
        if (N == 1) return 4;
        for (int i = 1; i * i <= N; ++i) {
            if (N % i == 0) {
                minPerimeter = Math.min(minPerimeter, 2 * (i + N / i));
            }
        }
        return minPerimeter;
    }

    public static void test(Solution solution) {
        Assertions.equalObjects(solution.solution(30), 22);
        Assertions.equalObjects(solution.solution(1), 4);
        Assertions.equalObjects(solution.solution(2), 6);
        Assertions.equalObjects(solution.solution(16), 16);
        Assertions.equalObjects(solution.solution(100), 40);
        Assertions.equalObjects(solution.solution(1000000000), 126500);
    }
}
