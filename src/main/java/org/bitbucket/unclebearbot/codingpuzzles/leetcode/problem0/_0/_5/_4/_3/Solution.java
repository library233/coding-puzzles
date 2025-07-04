package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._5._4._3;

/*

https://leetcode.com/problems/diameter-of-binary-tree

543. Diameter of Binary Tree
(Easy)

Given the root of a binary tree, return the length of the diameter of the tree.

The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

The length of a path between two nodes is represented by the number of edges between them.

Example 1:

        (1)
        / \
      (2) (3)
      / \
    (4) (5)

Input: root = [1,2,3,4,5]
Output: 3
Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].

Example 2:

Input: root = [1,2]
Output: 1

      (1)
      /
    (2)

Constraints:

    The number of nodes in the tree is in the range [1, 10^4].
    -100 <= Node.val <= 100

 */

class Solution {
    private int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        walkThrough(root);
        return maxDiameter;
    }

    private int walkThrough(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftDepth = walkThrough(node.left);
        int rightDepth = walkThrough(node.right);
        int diameter = leftDepth + rightDepth;
        if (diameter > maxDiameter) {
            maxDiameter = diameter;
        }
        return 1 + Math.max(leftDepth, rightDepth);
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
