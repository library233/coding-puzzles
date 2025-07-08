package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._1._4._3;

/*

https://leetcode.com/problems/reorder-list

143. Reorder List
(Medium)

You are given the head of a singly linked-list. The list can be represented as:

L0 → L1 → … → Ln - 1 → Ln

Reorder the list to be on the following form:

L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …

You may not modify the values in the list's nodes. Only nodes themselves may be changed.

Example 1:

    (1) -> (2) -> (3) -> (4)

    (1) -> (4) -> (2) -> (3)

Input: head = [1,2,3,4]
Output: [1,4,2,3]

Example 2:

    (1) -> (2) -> (3) -> (4) -> (5)

    (1) -> (5) -> (2) -> (4) -> (3)

Input: head = [1,2,3,4,5]
Output: [1,5,2,4,3]

Constraints:

    The number of nodes in the list is in the range [1, 5 * 10^4].
    1 <= Node.val <= 1000

 */

class Solution {
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode secondHalf = reverse(slow.next);
        slow.next = null;
        ListNode firstHalf = head;
        while (secondHalf != null) {
            ListNode firstNext = firstHalf.next;
            firstHalf.next = secondHalf;
            ListNode secondNext = secondHalf.next;
            secondHalf.next = firstNext;
            firstHalf = firstNext;
            secondHalf = secondNext;
        }
    }

    private ListNode reverse(ListNode head) {
        ListNode reversedHead = null;
        ListNode current = head;
        while (current != null) {
            ListNode currentNext = current.next;
            current.next = reversedHead;
            reversedHead = current;
            current = currentNext;
        }
        return reversedHead;
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
