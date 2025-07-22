package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._0._1._9;

/*

https://leetcode.com/problems/remove-nth-node-from-end-of-list

19. Remove Nth Node From End of List
(Medium)

Given the head of a linked list, remove the nth node from the end of the list and return its head.

Example 1:

    (1) -> (2) -> (3) -> [4] -> (5)

    (1) -> (2) -> (3) --------> (5)

Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]

Example 2:

Input: head = [1], n = 1
Output: []

Example 3:

Input: head = [1,2], n = 1
Output: [1]

Constraints:

    The number of nodes in the list is sz.
    1 <= sz <= 30
    0 <= Node.val <= 100
    1 <= n <= sz

Follow up: Could you do this in one pass?

 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode start = new ListNode(0, head);
        ListNode left = start;
        ListNode right = start;
        for (int i = 0; i <= n; ++i) {
            right = right.next;
        }
        while (right != null) {
            left = left.next;
            right = right.next;
        }
        left.next = left.next.next;
        return start.next;
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
