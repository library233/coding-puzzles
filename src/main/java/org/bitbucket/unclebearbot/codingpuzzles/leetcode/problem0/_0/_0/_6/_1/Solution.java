package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._0._6._1;

/*

https://leetcode.com/problems/rotate-list

61. Rotate List
(Medium)

Given the head of a linked list, rotate the list to the right by k places.

Example 1:

              (1) -> (2) -> (3) -> (4) -> (5)

    rotate 1  (5) -> (1) -> (2) -> (3) -> (4)

    rotate 2  (4) -> (5) -> (1) -> (2) -> (3)

Input: head = [1,2,3,4,5], k = 2
Output: [4,5,1,2,3]

Example 2:

              (0) -> (1) -> (2)

    rotate 1  (2) -> (0) -> (1)

    rotate 2  (1) -> (2) -> (0)

    rotate 3  (0) -> (1) -> (2)

    rotate 4  (2) -> (0) -> (1)

Input: head = [0,1,2], k = 4
Output: [2,0,1]

Constraints:

    The number of nodes in the list is in the range [0, 500].
    -100 <= Node.val <= 100
    0 <= k <= 2 * 10^9

 */

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        ListNode current = head;
        int length = 1;
        while (current.next != null) {
            current = current.next;
            ++length;
        }
        int skip = length - k % length;
        if (skip == 0) {
            return head;
        }
        current.next = head;
        for (int i = 0; i < skip; ++i) {
            current = current.next;
        }
        ListNode newHead = current.next;
        current.next = null;
        return newHead;
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
