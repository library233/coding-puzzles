package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._3._0._3;

/*

https://leetcode.com/problems/range-sum-query-immutable

303. Range Sum Query - Immutable
(Easy)

Given an integer array nums, handle multiple queries of the following type:

    Calculate the sum of the elements of nums between indices left and right inclusive where left <= right.

Implement the NumArray class:

    NumArray(int[] nums) Initializes the object with the integer array nums.
    int sumRange(int left, int right) Returns the sum of the elements of nums between indices left and right inclusive (i.e. nums[left] + nums[left + 1] + ... + nums[right]).

Example 1:

Input
["NumArray", "sumRange", "sumRange", "sumRange"]
[[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
Output
[null, 1, -1, -3]

Explanation
NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
numArray.sumRange(0, 2); // return (-2) + 0 + 3 = 1
numArray.sumRange(2, 5); // return 3 + (-5) + 2 + (-1) = -1
numArray.sumRange(0, 5); // return (-2) + 0 + 3 + (-5) + 2 + (-1) = -3

Constraints:

    1 <= nums.length <= 10^4
    -10^5 <= nums[i] <= 10^5
    0 <= left <= right < nums.length
    At most 10^4 calls will be made to sumRange.

 */

class NumArray {
    private final SegmentTree segmentTree;

    public NumArray(int[] nums) {
        segmentTree = new SegmentTree(nums);
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
 * int param_1 = obj.sumRange(left,right);
 */
