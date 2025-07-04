package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._4._2._9;

/*

https://leetcode.com/problems/n-ary-tree-level-order-traversal

429. N-ary Tree Level Order Traversal
(Medium)

Given an n-ary tree, return the level order traversal of its nodes' values.

Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value (See examples).

Example 1:

          (1)
         / | \
      (3) (2) (4)
      / \
    (5) (6)

Input: root = [1,null,3,2,4,null,5,6]
Output: [[1],[3,2,4],[5,6]]

Example 2:

               (1)
         /    /  \    \
    (2)    (3)    (4)    (5)
           / \     |     / \
         (6) (7)  (8)  (9) (10)
              |    |    |
            (11) (12) (13)
              |
            (14)

Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
Output: [[1],[2,3,4,5],[6,7,8,9,10],[11,12,13],[14]]

Constraints:

    The height of the n-ary tree is less than or equal to 1000
    The total number of nodes is between [0, 10^4]

 */

import java.util.*;

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; ++i) {
                Node node = queue.poll();
                level.add(node.val);
                Optional.ofNullable(node.children).ifPresent(children -> children.stream().filter(Objects::nonNull).forEach(queue::offer));
            }
            result.add(level);
        }
        return result;
    }
}

/*
// Definition for a Node.
*/

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
