package org.bitbucket.unclebearbot.codingpuzzles.codility.lesson003.task01;

import org.bitbucket.unclebearbot.utils.Assertions;

/*

https://app.codility.com/programmers/lessons/3-time_complexity/frog_jmp

# FrogJmp
# Count minimal number of jumps from position X to Y.

A small frog wants to get to the other side of the road.
The frog is currently located at position X and wants to get to a position greater than or equalArrays to Y.
The small frog always jumps a fixed distance, D.

Count the minimal number of jumps that the small frog must perform to reach its target.

Write a function:
    class Solution { public int solution(int X, int Y, int D); }
that, given three integers X, Y and D, returns the minimal number of jumps from position X to a position equalArrays to or greater than Y.

For example, given:
    X = 10
    Y = 85
    D = 30
the function should return 3, because the frog will be positioned as follows:
    after the first jump, at position 10 + 30 = 40
    after the second jump, at position 10 + 30 + 30 = 70
    after the third jump, at position 10 + 30 + 30 + 30 = 100

Write an efficient algorithm for the following assumptions:
    X, Y and D are integers within the range [1..1,000,000,000];
    X ≤ Y.

 */

public class Solution {
    public static void main(String[] args) {
        test(new Solution());
        System.out.println(Solution.class);
    }

    public int solution(int X, int Y, int D) {
        return (Y - X + D - 1) / D;
    }

    public static void test(Solution solution) {
        Assertions.equalObjects(solution.solution(10, 85, 30), 3);
        Assertions.equalObjects(solution.solution(10, 20, 10), 1);
        Assertions.equalObjects(solution.solution(10, 10, 5), 0);
        Assertions.equalObjects(solution.solution(1, 1000000000, 1), 999999999);
        Assertions.equalObjects(solution.solution(1, 1000000000, 1000000000), 1);
    }
}
