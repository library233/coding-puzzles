package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._2._0._7;

/*

https://leetcode.com/problems/course-schedule

207. Course Schedule
(Medium)

There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

    For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.

Return true if you can finish all courses. Otherwise, return false.

Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take.
To take course 1 you should have finished course 0. So it is possible.

Example 2:

Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take.
To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.

Constraints:

    1 <= numCourses <= 2000
    0 <= prerequisites.length <= 5000
    prerequisites[i].length == 2
    0 <= ai, bi < numCourses
    All the pairs prerequisites[i] are unique.

 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> dependents = IntStream.range(0, numCourses).mapToObj(i -> new ArrayList<Integer>()).collect(Collectors.toList());
        int[] dependencies = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            int dependent = prerequisite[0];
            int dependency = prerequisite[1];
            dependents.get(dependency).add(dependent);
            ++dependencies[dependent];
        }
        Queue<Integer> ready = new LinkedList<>();
        IntStream.range(0, numCourses).filter(dependent -> dependencies[dependent] == 0).forEach(ready::offer);
        int resolvable = 0;
        while (!ready.isEmpty()) {
            int dependency = ready.poll();
            dependents.get(dependency).stream().filter(dependent -> --dependencies[dependent] == 0).forEach(ready::offer);
            ++resolvable;
        }
        return resolvable == numCourses;
    }
}
