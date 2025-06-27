package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem00111;

/*

https://leetcode.com/problems/minimum-depth-of-binary-tree

111. Minimum Depth of Binary Tree
(Easy)

Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

Note: A leaf is a node with no children.

Example 1:

      (3)
      / \
    (9) (20)
        /  \
     (15)  (7)

Input: root = [3,9,20,null,null,15,7]
Output: 2

Example 2:

    (2)
      \
      (3)
        \
        (4)
          \
          (5)
            \
            (6)

Input: root = [2,null,3,null,4,null,5,null,6]
Output: 5

Constraints:

    The number of nodes in the tree is in the range [0, 10^5].
    -1000 <= Node.val <= 1000

 */

class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null) {
            return 1 + minDepth(root.right);
        }
        if (root.right == null) {
            return 1 + minDepth(root.left);
        }
        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
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
