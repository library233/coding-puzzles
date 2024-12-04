package org.bitbucket.unclebearbot.codingpuzzles.codility.lesson004.task04;

import org.bitbucket.unclebearbot.codingpuzzles.utils.Assertion;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/*

https://app.codility.com/programmers/lessons/4-counting_elements/missing_integer

This is a demo task.

Write a function:
    class Solution { public int solution(int[] A); }
that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.

For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.

Given A = [1, 2, 3], the function should return 4.

Given A = [−1, −3], the function should return 1.

Write an efficient algorithm for the following assumptions:
    N is an integer within the range [1..100,000];
    each element of array A is an integer within the range [−1,000,000..1,000,000].

 */

public class Solution {
    public static void main(String[] args) {
        test(new Solution());
    }

    public int solution(int[] A) {
        Set<Integer> appeared = Arrays.stream(A).filter(number -> number > 0).boxed().collect(Collectors.toSet());
        int missing = 1;
        while (appeared.contains(missing)) {
            ++missing;
        }
        return missing;
    }

    public static void test(Solution solution) {
        Assertion.equalObjects(solution.solution(new int[]{1, 3, 6, 4, 1, 2}), 5);
        Assertion.equalObjects(solution.solution(new int[]{1, 2, 3}), 4);
        Assertion.equalObjects(solution.solution(new int[]{-1, -3}), 1);
        Assertion.equalObjects(solution.solution(new int[]{0, 0, 0, 0}), 1);
        Assertion.equalObjects(solution.solution(new int[]{1000000}), 1);
        Assertion.equalObjects(solution.solution(new int[]{1, 2, 2, 2, 3, 3, 4, 4, 5}), 6);
    }
}
