package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._1._0._6;

/*

https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal

106. Construct Binary Tree from Inorder and Postorder Traversal
(Medium)

Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and postorder is the postorder traversal of the same tree, construct and return the binary tree.

Example 1:

      (3)
      / \
    (9) (20)
        /  \
     (15)  (7)

Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
Output: [3,9,20,null,null,15,7]

Example 2:

Input: inorder = [-1], postorder = [-1]
Output: [-1]

Constraints:

    1 <= inorder.length <= 3000
    postorder.length == inorder.length
    -3000 <= inorder[i], postorder[i] <= 3000
    inorder and postorder consist of unique values.
    Each value of postorder also appears in inorder.
    inorder is guaranteed to be the inorder traversal of the tree.
    postorder is guaranteed to be the postorder traversal of the tree.

 */

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> valuesToInorderIndices = IntStream.range(0, inorder.length).boxed().collect(Collectors.toMap(i -> inorder[i], Function.identity(), (a, b) -> b));
        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, valuesToInorderIndices);
    }

    private TreeNode buildTree(int[] inorder, int inorderBegin, int inorderEnd, int[] postorder, int postorderBegin, int postorderEnd, Map<Integer, Integer> valuesToInorderIndices) {
        if (inorderBegin > inorderEnd || postorderBegin > postorderEnd) {
            return null;
        }
        int rootValue = postorder[postorderEnd];
        int rootInorderIndex = valuesToInorderIndices.get(rootValue);
        int leftNodeCount = rootInorderIndex - inorderBegin;
        TreeNode left = buildTree(inorder, inorderBegin, rootInorderIndex - 1, postorder, postorderBegin, postorderBegin + leftNodeCount - 1, valuesToInorderIndices);
        TreeNode right = buildTree(inorder, rootInorderIndex + 1, inorderEnd, postorder, postorderBegin + leftNodeCount, postorderEnd - 1, valuesToInorderIndices);
        return new TreeNode(rootValue, left, right);
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
