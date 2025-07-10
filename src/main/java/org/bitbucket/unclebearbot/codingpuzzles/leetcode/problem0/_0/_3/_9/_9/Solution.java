package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._3._9._9;

/*

https://leetcode.com/problems/evaluate-division

399. Evaluate Division
(Medium)

You are given an array of variable pairs equations and an array of real numbers values, where equations[i] = [Ai, Bi] and values[i] represent the equation Ai / Bi = values[i]. Each Ai or Bi is a string that represents a single variable.

You are also given some queries, where queries[j] = [Cj, Dj] represents the jth query where you must find the answer for Cj / Dj = ?.

Return the answers to all queries. If a single answer cannot be determined, return -1.0.

Note: The input is always valid. You may assume that evaluating the queries will not result in division by zero and that there is no contradiction.

Note: The variables that do not occur in the list of equations are undefined, so the answer cannot be determined for them.

Example 1:

Input: equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
Output: [6.00000,0.50000,-1.00000,1.00000,-1.00000]
Explanation:
Given: a / b = 2.0, b / c = 3.0
queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
return: [6.0, 0.5, -1.0, 1.0, -1.0 ]
note: x is undefined => -1.0

Example 2:

Input: equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0], queries = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
Output: [3.75000,0.40000,5.00000,0.20000]

Example 3:

Input: equations = [["a","b"]], values = [0.5], queries = [["a","b"],["b","a"],["a","c"],["x","y"]]
Output: [0.50000,2.00000,-1.00000,-1.00000]

Constraints:

    1 <= equations.length <= 20
    equations[i].length == 2
    1 <= Ai.length, Bi.length <= 5
    values.length == equations.length
    0.0 < values[i] <= 20.0
    1 <= queries.length <= 20
    queries[i].length == 2
    1 <= Cj.length, Dj.length <= 5
    Ai, Bi, Cj, Dj consist of lower case English letters and digits.

 */

import java.util.*;

class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> ratios = new HashMap<>();
        for (int i = 0; i < values.length; ++i) {
            List<String> equation = equations.get(i);
            String dividend = equation.get(0);
            String divisor = equation.get(1);
            double quotient = values[i];
            ratios.computeIfAbsent(dividend, k -> new HashMap<>()).put(divisor, quotient);
            ratios.computeIfAbsent(divisor, k -> new HashMap<>()).put(dividend, 1 / quotient);
        }
        double[] result = new double[queries.size()];
        for (int i = 0; i < result.length; ++i) {
            List<String> query = queries.get(i);
            String dividend = query.get(0);
            String divisor = query.get(1);
            if (!ratios.containsKey(dividend)) {
                result[i] = -1;
                continue;
            }
            if (!ratios.containsKey(divisor)) {
                result[i] = -1;
                continue;
            }
            if (Objects.equals(dividend, divisor)) {
                result[i] = 1;
                continue;
            }
            result[i] = divide(dividend, divisor, ratios, new HashSet<>(), 1);
        }
        return result;
    }

    private double divide(String dividend, String divisor, Map<String, Map<String, Double>> ratios, Set<String> visited, double accumulated) {
        if (Objects.equals(dividend, divisor)) {
            return accumulated;
        }
        visited.add(dividend);
        for (Map.Entry<String, Double> ratio : ratios.get(dividend).entrySet()) {
            String next = ratio.getKey();
            if (visited.contains(next)) {
                continue;
            }
            double toAccumulate = ratio.getValue();
            double result = divide(next, divisor, ratios, visited, accumulated * toAccumulate);
            if (result != -1) {
                return result;
            }
        }
        return -1;
    }
}
