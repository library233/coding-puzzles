package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._7._3._9;

/*

https://leetcode.com/problems/daily-temperatures

739. Daily Temperatures
(Medium)

Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature. If there is no future day for which this is possible, keep answer[i] == 0 instead.

Example 1:

Input: temperatures = [73,74,75,71,69,72,76,73]
Output: [1,1,4,2,1,1,0,0]

Example 2:

Input: temperatures = [30,40,50,60]
Output: [1,1,1,0]

Example 3:

Input: temperatures = [30,60,90]
Output: [1,1,0]

Constraints:

    1 <= temperatures.length <= 10^5
    30 <= temperatures[i] <= 100

 */

import java.util.Stack;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int days = temperatures.length;
        int[] answer = new int[days];
        Stack<Integer> unprocessed = new Stack<>();
        for (int today = 0; today < days; ++today) {
            while (!unprocessed.isEmpty()) {
                if (temperatures[today] > temperatures[unprocessed.peek()]) {
                    int historicalDay = unprocessed.pop();
                    answer[historicalDay] = today - historicalDay;
                } else {
                    break;
                }
            }
            unprocessed.push(today);
        }
        return answer;
    }
}
