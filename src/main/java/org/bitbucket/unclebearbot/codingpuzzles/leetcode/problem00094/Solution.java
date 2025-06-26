package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem00094;

/*

https://leetcode.com/problems/binary-tree-inorder-traversal

94. Binary Tree Inorder Traversal
(Easy)

Given the root of a binary tree, return the inorder traversal of its nodes' values.

Example 1:

      (1)
        \
        (2)
        /
      (3)

Input: root = [1,null,2,3]

Output: [1,3,2]

Explanation:

Example 2:

          (1)
         /   \
      (2)     (3)
      / \       \
    (4) (5)     (8)
        / \     /
      (6) (7) (9)

Input: root = [1,2,3,4,5,null,8,null,null,6,7,9]

Output: [4,2,6,5,7,1,3,9,8]

Explanation:

Example 3:

Input: root = []

Output: []

Example 4:

Input: root = [1]

Output: [1]

Constraints:

    The number of nodes in the tree is in the range [0, 100].
    -100 <= Node.val <= 100

Follow up: Recursive solution is trivial, could you do it iteratively?

 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            result.add(node.val);
            node = node.right;
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
