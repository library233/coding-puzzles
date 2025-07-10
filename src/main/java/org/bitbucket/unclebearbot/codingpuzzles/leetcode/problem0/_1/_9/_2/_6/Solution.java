package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._1._9._2._6;

/*

https://leetcode.com/problems/nearest-exit-from-entrance-in-maze

1926. Nearest Exit from Entrance in Maze
(Medium)

You are given an m x n matrix maze (0-indexed) with empty cells (represented as '.') and walls (represented as '+'). You are also given the entrance of the maze, where entrance = [entrancerow, entrancecol] denotes the row and column of the cell you are initially standing at.

In one step, you can move one cell up, down, left, or right. You cannot step into a cell with a wall, and you cannot step outside the maze. Your goal is to find the nearest exit from the entrance. An exit is defined as an empty cell that is at the border of the maze. The entrance does not count as an exit.

Return the number of steps in the shortest path from the entrance to the nearest exit, or -1 if no such path exists.

Example 1:

    |+|+|!|+|
    |.|.|?|+|
    |+|+|+|.|

Input: maze = [["+","+",".","+"],[".",".",".","+"],["+","+","+","."]], entrance = [1,2]
Output: 1
Explanation: There are 3 exits in this maze at [1,0], [0,2], and [2,3].
Initially, you are at the entrance cell [1,2].
- You can reach [1,0] by moving 2 steps left.
- You can reach [0,2] by moving 1 step up.
It is impossible to reach [2,3] from the entrance.
Thus, the nearest exit is [0,2], which is 1 step away.

Example 2:

    |+|+|+|
    |?|.|!|
    |+|+|+|

Input: maze = [["+","+","+"],[".",".","."],["+","+","+"]], entrance = [1,0]
Output: 2
Explanation: There is 1 exit in this maze at [1,2].
[1,0] does not count as an exit since it is the entrance cell.
Initially, you are at the entrance cell [1,0].
- You can reach [1,2] by moving 2 steps right.
Thus, the nearest exit is [1,2], which is 2 steps away.

Example 3:

    |?|+|

Input: maze = [[".","+"]], entrance = [0,0]
Output: -1
Explanation: There are no exits in this maze.

Constraints:

    maze.length == m
    maze[i].length == n
    1 <= m, n <= 100
    maze[i][j] is either '.' or '+'.
    entrance.length == 2
    0 <= entrancerow < m
    0 <= entrancecol < n
    entrance will always be an empty cell.

 */

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int lines = maze.length;
        int columns = maze[0].length;
        Queue<Cell> route = new LinkedList<>();
        Cell start = new Cell(entrance[0], entrance[1], 0);
        route.offer(start);
        boolean[][] visited = new boolean[lines][columns];
        visited[start.line][start.column] = true;
        while (!route.isEmpty()) {
            Cell cell = route.poll();
            if (isExit(cell, lines, columns)) {
                return cell.distance;
            }
            for (Direction direction : Direction.values()) {
                Cell next = cell.move(direction);
                if (isOut(next, lines, columns)) {
                    continue;
                }
                if (visited[next.line][next.column]) {
                    continue;
                }
                if (maze[next.line][next.column] == '+') {
                    continue;
                }
                route.offer(next);
                visited[next.line][next.column] = true;
            }
        }
        return -1;
    }

    private boolean isExit(Cell cell, int lines, int columns) {
        if (cell.distance == 0) {
            return false;
        }
        if (cell.line == 0) {
            return true;
        }
        if (cell.line == lines - 1) {
            return true;
        }
        if (cell.column == 0) {
            return true;
        }
        if (cell.column == columns - 1) {
            return true;
        }
        return false;
    }

    private boolean isOut(Cell cell, int lines, int columns) {
        if (cell.line < 0) {
            return true;
        }
        if (cell.line >= lines) {
            return true;
        }
        if (cell.column < 0) {
            return true;
        }
        if (cell.column >= columns) {
            return true;
        }
        return false;
    }

    private static class Cell {
        private final int line;
        private final int column;
        private final int distance;

        private Cell(int line, int column, int distance) {
            this.line = line;
            this.column = column;
            this.distance = distance;
        }

        protected Cell move(Direction direction) {
            return new Cell(line + direction.lineOffset, column + direction.columnOffset, distance + 1);
        }
    }

    private enum Direction {
        North(-1, 0),
        East(0, 1),
        South(1, 0),
        West(0, -1);
        private final int lineOffset;
        private final int columnOffset;

        Direction(int lineOffset, int columnOffset) {
            this.lineOffset = lineOffset;
            this.columnOffset = columnOffset;
        }
    }
}
