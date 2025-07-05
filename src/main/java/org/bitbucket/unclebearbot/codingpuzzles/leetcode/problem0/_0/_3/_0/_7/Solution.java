package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._3._0._7;

/*

https://leetcode.com/problems/range-sum-query-mutable

307. Range Sum Query - Mutable
(Medium)

Given an integer array nums, handle multiple queries of the following types:

    Update the value of an element in nums.
    Calculate the sum of the elements of nums between indices left and right inclusive where left <= right.

Implement the NumArray class:

    NumArray(int[] nums) Initializes the object with the integer array nums.
    void update(int index, int val) Updates the value of nums[index] to be val.
    int sumRange(int left, int right) Returns the sum of the elements of nums between indices left and right inclusive (i.e. nums[left] + nums[left + 1] + ... + nums[right]).

Example 1:

Input
["NumArray", "sumRange", "update", "sumRange"]
[[[1, 3, 5]], [0, 2], [1, 2], [0, 2]]
Output
[null, 9, null, 8]

Explanation
NumArray numArray = new NumArray([1, 3, 5]);
numArray.sumRange(0, 2); // return 1 + 3 + 5 = 9
numArray.update(1, 2);   // nums = [1, 2, 5]
numArray.sumRange(0, 2); // return 1 + 2 + 5 = 8

Constraints:

    1 <= nums.length <= 3 * 10^4
    -100 <= nums[i] <= 100
    0 <= index < nums.length
    -100 <= val <= 100
    0 <= left <= right < nums.length
    At most 3 * 10^4 calls will be made to update and sumRange.

 */

class NumArray {
    private final SegmentTree segmentTree;

    public NumArray(int[] nums) {
        segmentTree = new SegmentTree(nums);
    }

    public void update(int index, int val) {
        segmentTree.update(index, val);
    }

    public int sumRange(int left, int right) {
        return segmentTree.query(left, right);
    }

    private static class SegmentTree {
        private final int[] nodes;
        private final int length;
        private final int root = 1;

        private SegmentTree(int[] nums) {
            length = nums.length;
            nodes = new int[4 * length];
            build(root, nums, 0, length - 1);
        }

        private void build(int node, int[] nums, int numRangeLeft, int numRangeRight) {
            if (numRangeLeft == numRangeRight) {
                nodes[node] = nums[numRangeLeft];
                return;
            }
            int leftChild = 2 * node;
            int rightChild = 2 * node + 1;
            int midNum = (numRangeLeft + numRangeRight) / 2;
            build(leftChild, nums, numRangeLeft, midNum);
            build(rightChild, nums, midNum + 1, numRangeRight);
            nodes[node] = nodes[leftChild] + nodes[rightChild];
        }

        protected void update(int index, int value) {
            update(root, 0, length - 1, index, value);
        }

        private void update(int node, int nodeRangeBegin, int nodeRangeEnd, int index, int value) {
            if (nodeRangeBegin == nodeRangeEnd) {
                nodes[node] = value;
                return;
            }
            int leftChild = 2 * node;
            int rightChild = 2 * node + 1;
            int midNode = (nodeRangeBegin + nodeRangeEnd) / 2;
            if (index <= midNode) {
                update(leftChild, nodeRangeBegin, midNode, index, value);
            } else {
                update(rightChild, midNode + 1, nodeRangeEnd, index, value);
            }
            nodes[node] = nodes[leftChild] + nodes[rightChild];
        }

        protected int query(int left, int right) {
            return query(root, 0, length - 1, left, right);
        }

        private int query(int node, int nodeRangeBegin, int nodeRangeEnd, int queryRangeLeft, int queryRangeRight) {
            if (queryRangeLeft > nodeRangeEnd) {
                return 0;
            }
            if (queryRangeRight < nodeRangeBegin) {
                return 0;
            }
            if (queryRangeLeft <= nodeRangeBegin && queryRangeRight >= nodeRangeEnd) {
                return nodes[node];
            }
            int leftChild = 2 * node;
            int rightChild = 2 * node + 1;
            int midNode = (nodeRangeBegin + nodeRangeEnd) / 2;
            int leftSum = query(leftChild, nodeRangeBegin, midNode, queryRangeLeft, queryRangeRight);
            int rightSum = query(rightChild, midNode + 1, nodeRangeEnd, queryRangeLeft, queryRangeRight);
            return leftSum + rightSum;
        }
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
