package org.bitbucket.unclebearbot.codingpuzzles.codility.lesson013.task01;

import org.bitbucket.unclebearbot.utils.Assertions;

import java.util.*;

/*

https://app.codility.com/programmers/lessons/13-fibonacci_numbers/fib_frog

# FibFrog
# Count the minimum number of jumps required for a frog to get to the other side of a river.

The Fibonacci sequence is defined using the following recursive formula:
    F(0) = 0
    F(1) = 1
    F(M) = F(M - 1) + F(M - 2) if M >= 2

A small frog wants to get to the other side of a river.
The frog is initially located at one bank of the river (position −1) and wants to get to the other bank (position N).
The frog can jump over any distance F(K), where F(K) is the K-th Fibonacci number.
Luckily, there are many leaves on the river, and the frog can jump between the leaves, but only in the direction of the bank at position N.

The leaves on the river are represented in an array A consisting of N integers.
Consecutive elements of array A represent consecutive positions from 0 to N − 1 on the river.
Array A contains only 0s and/or 1s:
    0 represents a position without a leaf;
    1 represents a position containing a leaf.

The goal is to count the minimum number of jumps in which the frog can get to the other side of the river (from position −1 to position N).
The frog can jump between positions −1 and N (the banks of the river) and every position containing a leaf.

For example, consider array A such that:
    A[0] = 0
    A[1] = 0
    A[2] = 0
    A[3] = 1
    A[4] = 1
    A[5] = 0
    A[6] = 1
    A[7] = 0
    A[8] = 0
    A[9] = 0
    A[10] = 0

The frog can make three jumps of length F(5) = 5, F(3) = 2 and F(5) = 5.

Write a function:
    class Solution { public int solution(int[] A); }
that, given an array A consisting of N integers, returns the minimum number of jumps by which the frog can get to the other side of the river.
If the frog cannot reach the other side of the river, the function should return −1.

For example, given:
    A[0] = 0
    A[1] = 0
    A[2] = 0
    A[3] = 1
    A[4] = 1
    A[5] = 0
    A[6] = 1
    A[7] = 0
    A[8] = 0
    A[9] = 0
    A[10] = 0
the function should return 3, as explained above.

Write an efficient algorithm for the following assumptions:
    N is an integer within the range [0..100,000];
    each element of array A is an integer that can have one of the following values: 0, 1.

 */

public class Solution {
    public static void main(String[] args) {
        test(new Solution());
        System.out.println(Solution.class);
    }

    public int solution(int[] A) {
        int length = A.length;
        List<Integer> fib = new ArrayList<>();
        fib.add(1);
        fib.add(2);
        while (true) {
            int next = fib.get(fib.size() - 1) + fib.get(fib.size() - 2);
            if (next > length + 1) break;
            fib.add(next);
        }
        Collections.reverse(fib);
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[length + 1];
        queue.add(-1);
        int jumps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            ++jumps;
            for (int i = 0; i < size; ++i) {
                int pos = queue.poll();
                for (int f : fib) {
                    int nextPos = pos + f;
                    if (nextPos == length) return jumps;
                    if (nextPos > length || nextPos < 0 || A[nextPos] == 0 || visited[nextPos]) continue;
                    visited[nextPos] = true;
                    queue.add(nextPos);
                }
            }
        }
        return -1;
    }

    public static void test(Solution solution) {
        Assertions.equalObjects(solution.solution(new int[]{1}), 1);
        Assertions.equalObjects(solution.solution(new int[]{}), 1);
        Assertions.equalObjects(solution.solution(new int[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1}), -1);
        Assertions.equalObjects(solution.solution(new int[]{0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0}), 3);
        Assertions.equalObjects(solution.solution(new int[]{1, 1, 1, 1, 1}), 2);
        Assertions.equalObjects(solution.solution(new int[]{0, 0, 0}), -1);
    }
}
