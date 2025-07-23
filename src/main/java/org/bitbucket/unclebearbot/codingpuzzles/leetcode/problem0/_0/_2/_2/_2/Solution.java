package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._2._2._2;

/*

https://leetcode.com/problems/count-complete-tree-nodes

222. Count Complete Tree Nodes
(Easy)

Given the root of a complete binary tree, return the number of the nodes in the tree.

According to Wikipedia, every level, except possibly the last, is completely filled in a complete binary tree, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.

Design an algorithm that runs in less than O(n) time complexity.

Example 1:

          (1)
         /   \
      (2)     (3)
      / \     /
    (4) (5) (6)

Input: root = [1,2,3,4,5,6]
Output: 6

Example 2:

Input: root = []
Output: 0

Example 3:

Input: root = [1]
Output: 1

Constraints:

    The number of nodes in the tree is in the range [0, 5 * 10^4].
    0 <= Node.val <= 5 * 10^4
    The tree is guaranteed to be complete.

 */

class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        TreeNode left = root;
        int leftPathLength = 0;
        while (left.left != null) {
            left = left.left;
            ++leftPathLength;
        }
        int rightPathLength = 0;
        TreeNode right = root;
        while (right.right != null) {
            right = right.right;
            ++rightPathLength;
        }
        if (leftPathLength == rightPathLength) {
            return (int) Math.pow(2, leftPathLength + 1) - 1;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
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
