package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._2._3._0;

/*

https://leetcode.com/problems/kth-smallest-element-in-a-bst

230. Kth Smallest Element in a BST
(Medium)

Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.

Example 1:

      (3)
      / \
    (1) (4)
      \
      (2)

Input: root = [3,1,4,null,2], k = 1
Output: 1

Example 2:

          (5)
          / \
        (3) (6)
        / \
      (2) (4)
      /
    (1)

Input: root = [5,3,6,2,4,null,null,1], k = 3
Output: 3

Constraints:

    The number of nodes in the tree is n.
    1 <= k <= n <= 10^4
    0 <= Node.val <= 10^4

Follow up: If the BST is modified often (i.e., we can do insert and delete operations) and you need to find the kth smallest frequently, how would you optimize?

 */

import java.util.Stack;

class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> inorder = new Stack<>();
        TreeNode node = root;
        while (node != null || !inorder.isEmpty()) {
            while (node != null) {
                inorder.push(node);
                node = node.left;
            }
            node = inorder.pop();
            if (--k == 0) {
                return node.val;
            }
            node = node.right;
        }
        throw new IllegalArgumentException();
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
