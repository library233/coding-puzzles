package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem00092;

/*

https://leetcode.com/problems/reverse-linked-list-ii

92. Reverse Linked List II
(Medium)

Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes of the list from position left to position right, and return the reversed list.

Example 1:

            |<----------->|
    (1) -> (2) -> (3) -> (4) -> (5)
                   |
    (1) -> (4) -> (3) -> (2) -> (5)
            |<----------->|

Input: head = [1,2,3,4,5], left = 2, right = 4
Output: [1,4,3,2,5]

Example 2:

Input: head = [5], left = 1, right = 1
Output: [5]

Constraints:

    The number of nodes in the list is n.
    1 <= n <= 500
    -500 <= Node.val <= 500
    1 <= left <= right <= n

Follow up: Could you do it in one pass?

 */

class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode temp = new ListNode();
        temp.next = head;
        ListNode skippedTail = temp;
        for (int position = 1; position < left; ++position) {
            skippedTail = skippedTail.next;
        }
        ListNode current = skippedTail.next;
        for (int i = 0; i < right - left; ++i) {
            ListNode toMoveToReversedHead = getNext(current);
            ListNode unprocessedHead = getNext(getNext(current));
            setNext(current, unprocessedHead);
            ListNode reversedHead = getNext(skippedTail);
            setNext(toMoveToReversedHead, reversedHead);
            setNext(skippedTail, toMoveToReversedHead);
        }
        return temp.next;
    }

    private ListNode getNext(ListNode listNode) {
        return listNode.next;
    }

    private void setNext(ListNode listNode, ListNode next) {
        listNode.next = next;
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
