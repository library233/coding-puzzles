package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._1._0._1;

/*

https://leetcode.com/problems/symmetric-tree

101. Symmetric Tree
(Easy)

Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

Example 1:

          (1)
         /   \
      (2)     (2)
      / \     / \
    (3) (4) (4) (3)

Input: root = [1,2,2,3,4,4,3]
Output: true

Example 2:

        (1)
       /   \
    (2)     (2)
      \       \
      (3)     (3)

Input: root = [1,2,2,null,3,null,3]
Output: false

Constraints:

    The number of nodes in the tree is in the range [1, 1000].
    -100 <= Node.val <= 100

Follow up: Could you solve it both recursively and iteratively?

 */

import java.util.LinkedList;
import java.util.Queue;

abstract class Solution {
    public abstract boolean isSymmetric(TreeNode root);
}

class RecursiveSolution extends Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode front, TreeNode back) {
        if (front == null && back == null) {
            return true;
        }
        if (front == null || back == null) {
            return false;
        }
        if (front.val != back.val) {
            return false;
        }
        if (!isMirror(front.left, back.right)) {
            return false;
        }
        if (!isMirror(front.right, back.left)) {
            return false;
        }
        return true;
    }
}

class IterativeSolution extends Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);
        while (!queue.isEmpty()) {
            TreeNode front = queue.poll();
            TreeNode back = queue.poll();
            if (front == null && back == null) {
                continue;
            }
            if (front == null || back == null) {
                return false;
            }
            if (front.val != back.val) {
                return false;
            }
            queue.offer(front.left);
            queue.offer(back.right);
            queue.offer(front.right);
            queue.offer(back.left);
        }
        return true;
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
