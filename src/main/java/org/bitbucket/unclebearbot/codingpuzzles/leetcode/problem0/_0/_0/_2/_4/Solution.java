package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._0._2._4;

/*

https://leetcode.com/problems/swap-nodes-in-pairs

24. Swap Nodes in Pairs
(Medium)

Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)

Example 1:

    (1) -> [2] -> (3) -> [4]

    [2] -> (1) -> [4] -> (3)

Input: head = [1,2,3,4]

Output: [2,1,4,3]

Explanation:

Example 2:

Input: head = []

Output: []

Example 3:

Input: head = [1]

Output: [1]

Example 4:

Input: head = [1,2,3]

Output: [2,1,3]

Constraints:

    The number of nodes in the list is in the range [0, 100].
    0 <= Node.val <= 100

 */

class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode left = head;
        ListNode right = head.next;
        ListNode nextGroup = right.next;
        left.next = swapPairs(nextGroup);
        right.next = left;
        return right;
    }
}

/**
 * Definition for singly-linked list.
 */

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
