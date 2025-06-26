package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem00103;

/*

https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal

103. Binary Tree Zigzag Level Order Traversal
(Medium)

Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left for the next level and alternate between).

Example 1:

      (3)
      / \
    (9) (20)
        /  \
     (15)  (7)

Input: root = [3,9,20,null,null,15,7]
Output: [[3],[20,9],[15,7]]

Example 2:

Input: root = [1]
Output: [[1]]

Example 3:

Input: root = []
Output: []

Constraints:

    The number of nodes in the tree is in the range [0, 2000].
    -100 <= Node.val <= 100

 */

import java.util.*;
import java.util.stream.IntStream;

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        final boolean[] leftToRight = {true};
        while (!queue.isEmpty()) {
            LinkedList<Integer> level = new LinkedList<>();
            IntStream.range(0, queue.size()).mapToObj(i -> queue.poll()).filter(Objects::nonNull).forEach(node -> {
                if (leftToRight[0]) {
                    level.addLast(node.val);
                } else {
                    level.addFirst(node.val);
                }
                queue.offer(node.left);
                queue.offer(node.right);
            });
            if (!level.isEmpty()) {
                result.add(level);
            }
            leftToRight[0] = !leftToRight[0];
        }
        return result;
    }
}

/**
 * Definition for a binary tree node.
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
