package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem00206;

/*

https://leetcode.com/problems/reverse-linked-list

206. Reverse Linked List
Given the head of a singly linked list, reverse the list, and return the reversed list.

Example 1:

Input: head = [1,2,3,4,5]
Output: [5,4,3,2,1]

Example 2:

Input: head = [1,2]
Output: [2,1]

Example 3:

Input: head = []
Output: []

Constraints:

    The number of nodes in the list is the range [0, 5000].
    -5000 <= Node.val <= 5000

Follow up: A linked list can be reversed either iteratively or recursively. Could you implement both?

 */

class Solution {
    class Recursively {
        public ListNode reverseList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode reversedHead = reverseList(head.next);
            head.next.next = head;
            head.next = null;
            return reversedHead;
        }
    }

    class Iteratively {
        public ListNode reverseList(ListNode head) {
            ListNode previous = null;
            ListNode current = head;
            while (current != null) {
                ListNode currentNext = current.next;
                current.next = previous;
                previous = current;
                current = currentNext;
            }
            return previous;
        }
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
