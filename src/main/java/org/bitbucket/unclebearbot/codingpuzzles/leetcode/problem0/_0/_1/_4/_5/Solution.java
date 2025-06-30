package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._1._4._5;

/*

https://leetcode.com/problems/binary-tree-postorder-traversal

145. Binary Tree Postorder Traversal
(Easy)

Given the root of a binary tree, return the postorder traversal of its nodes' values.

Example 1:

      (1)
        \
        (2)
        /
      (3)

Input: root = [1,null,2,3]

Output: [3,2,1]

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

Output: [4,6,7,5,2,9,8,3,1]

Explanation:

Example 3:

Input: root = []

Output: []

Example 4:

Input: root = [1]

Output: [1]

Constraints:

    The number of the nodes in the tree is in the range [0, 100].
    -100 <= Node.val <= 100

Follow up: Recursive solution is trivial, could you do it iteratively?

 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        Collections.reverse(result);
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
