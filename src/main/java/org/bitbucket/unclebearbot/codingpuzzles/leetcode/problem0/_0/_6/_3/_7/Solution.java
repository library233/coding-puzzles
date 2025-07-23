package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._6._3._7;

/*

https://leetcode.com/problems/average-of-levels-in-binary-tree

637. Average of Levels in Binary Tree
(Easy)

Given the root of a binary tree, return the average value of the nodes on each level in the form of an array. Answers within 10-5 of the actual answer will be accepted.

Example 1:

      (3)
      / \
    (9) (20)
        /  \
     (15)  (7)

Input: root = [3,9,20,null,null,15,7]
Output: [3.00000,14.50000,11.00000]
Explanation: The average value of nodes on level 0 is 3, on level 1 is 14.5, and on level 2 is 11.
Hence return [3, 14.5, 11].

Example 2:

         (3)
         / \
       (9) (20)
       / \
    (15) (7)

Input: root = [3,9,20,15,7]
Output: [3.00000,14.50000,11.00000]

Constraints:

    The number of nodes in the tree is in the range [1, 10^4].
    -2^31 <= Node.val <= 2^31 - 1

 */

import java.util.*;

class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            double sum = 0;
            for (int i = 0; i < size; ++i) {
                TreeNode node = queue.poll();
                sum += node.val;
                Optional.ofNullable(node.left).ifPresent(queue::offer);
                Optional.ofNullable(node.right).ifPresent(queue::offer);
            }
            result.add(sum / size);
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
