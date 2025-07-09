package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._7._0._0;

/*

https://leetcode.com/problems/search-in-a-binary-search-tree

700. Search in a Binary Search Tree
(Easy)

You are given the root of a binary search tree (BST) and an integer val.

Find the node in the BST that the node's value equals val and return the subtree rooted with that node. If such a node does not exist, return null.

Example 1:

        (4)
        / \
      [2] (7)
      / \
    (1) (3)

Input: root = [4,2,7,1,3], val = 2
Output: [2,1,3]

Example 2:

        (4)
        / \
      (2) (7)
      / \
    (1) (3)

Input: root = [4,2,7,1,3], val = 5
Output: []

Constraints:

    The number of nodes in the tree is in the range [1, 5000].
    1 <= Node.val <= 10^7
    root is a binary search tree.
    1 <= val <= 10^7

 */

abstract class Solution {
    public abstract TreeNode searchBST(TreeNode root, int val);
}

class RecursiveSolution extends Solution {
    @Override
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) {
            return root;
        }
        return val < root.val ? searchBST(root.left, val) : searchBST(root.right, val);
    }
}

class IterativeSolution extends Solution {
    @Override
    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode node = root;
        while (node != null && node.val != val) {
            node = val < node.val ? node.left : node.right;
        }
        return node;
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
