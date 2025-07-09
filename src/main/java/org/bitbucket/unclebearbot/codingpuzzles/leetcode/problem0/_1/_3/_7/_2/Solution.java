package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._1._3._7._2;

/*

https://leetcode.com/problems/longest-zigzag-path-in-a-binary-tree

1372. Longest ZigZag Path in a Binary Tree
(Medium)

You are given the root of a binary tree.

A ZigZag path for a binary tree is defined as follow:

    Choose any node in the binary tree and a direction (right or left).
    If the current direction is right, move to the right child of the current node; otherwise, move to the left child.
    Change the direction from right to left or from left to right.
    Repeat the second and third steps until you can't move in the tree.

Zigzag length is defined as the number of nodes visited - 1. (A single node has a length of 0).

Return the longest ZigZag path contained in that tree.

Example 1:

     (1)
       \
       [1]
       / \ Right
     (1) [1]
    Left / \
       [1] (1)
         \ Right
         [1]
           \
           (1)

Input: root = [1,null,1,1,1,null,null,1,1,null,1,null,null,null,1]
Output: 3
Explanation: Longest ZigZag path in blue nodes (right -> left -> right).

Example 2:

         [1]
    Left / \
       [1]  (1)
         \ Right
         [1]
    Left / \
       [1] (1)
         \ Right
         [1]

Input: root = [1,1,1,null,1,null,null,1,1,null,1]
Output: 4
Explanation: Longest ZigZag path in blue nodes (left -> right -> left -> right).

Example 3:

    [1]

Input: root = [1]
Output: 0

Constraints:

    The number of nodes in the tree is in the range [1, 5 * 10^4].
    1 <= Node.val <= 100

 */

import java.util.concurrent.atomic.AtomicInteger;

class Solution {
    public int longestZigZag(TreeNode root) {
        AtomicInteger maxLength = new AtomicInteger();
        walkThrough(root, true, 0, maxLength);
        walkThrough(root, false, 0, maxLength);
        return maxLength.get();
    }

    private void walkThrough(TreeNode parent, boolean toTheLeft, int currentLength, AtomicInteger maxLength) {
        TreeNode current;
        if (toTheLeft) {
            current = parent.left;
        } else {
            current = parent.right;
        }
        if (current == null) {
            return;
        }
        int length = currentLength + 1;
        if (length > maxLength.get()) {
            maxLength.set(length);
        }
        if (toTheLeft) {
            walkThrough(current, false, length, maxLength);
            walkThrough(current, true, 0, maxLength);
        } else {
            walkThrough(current, true, length, maxLength);
            walkThrough(current, false, 0, maxLength);
        }
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
