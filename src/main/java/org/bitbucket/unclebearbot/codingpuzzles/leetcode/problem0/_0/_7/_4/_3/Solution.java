package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._7._4._3;

/*

https://leetcode.com/problems/network-delay-time

743. Network Delay Time
(Medium)

You are given a network of n nodes, labeled from 1 to n. You are also given times, a list of travel times as directed edges times[i] = (ui, vi, wi), where ui is the source node, vi is the target node, and wi is the time it takes for a signal to travel from source to target.

We will send a signal from a given node k. Return the minimum time it takes for all the n nodes to receive the signal. If it is impossible for all the n nodes to receive the signal, return -1.

Example 1:

          1
(1) <------------ (2)
                   |
                   |
                   |1
                   |
                   V
(4) <------------ (3)
          1

Input: times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
Output: 2

Example 2:

Input: times = [[1,2,1]], n = 2, k = 1
Output: 1

Example 3:

Input: times = [[1,2,1]], n = 2, k = 2
Output: -1

Constraints:

    1 <= k <= n <= 100
    1 <= times.length <= 6000
    times[i].length == 3
    1 <= ui, vi <= n
    ui != vi
    0 <= wi <= 100
    All the pairs (ui, vi) are unique. (i.e., no multiple edges.)

 */

import java.util.Arrays;
import java.util.stream.IntStream;

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] delays = IntStream.rangeClosed(0, n).map(i -> Integer.MAX_VALUE).toArray();
        delays[k] = 0;
        for (int i = 0; i < n - 1; ++i) {
            boolean foundAnyUsefulEdge = false;
            for (int[] edge : times) {
                int begin = edge[0];
                int end = edge[1];
                int delay = edge[2];
                if (delays[begin] == Integer.MAX_VALUE) {
                    continue;
                }
                int delayByThisWay = delays[begin] + delay;
                if (delayByThisWay < delays[end]) {
                    delays[end] = delayByThisWay;
                    foundAnyUsefulEdge = true;
                }
            }
            if (!foundAnyUsefulEdge) {
                break;
            }
        }
        delays[0] = Integer.MIN_VALUE;
        if (Arrays.stream(delays).anyMatch(delay -> delay == Integer.MAX_VALUE)) {
            return -1;
        }
        return Arrays.stream(delays).max().getAsInt();
    }
}
