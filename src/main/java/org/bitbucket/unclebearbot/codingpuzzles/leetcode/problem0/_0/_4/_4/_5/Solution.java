package org.bitbucket.unclebearbot.codingpuzzles.leetcode.problem0._0._4._4._5;

/*

https://leetcode.com/problems/add-two-numbers-ii

445. Add Two Numbers II
(Medium)

You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example 1:

      (7) -> (2) -> (4) -> (3)
    +        (5) -> (6) -> (4)
    --------------------------
      (7) -> (8) -> (0) -> (7)

Input: l1 = [7,2,4,3], l2 = [5,6,4]
Output: [7,8,0,7]

Example 2:

      (2) -> (4) -> (3)
    + (5) -> (6) -> (4)
    -------------------
      (8) -> (0) -> (7)

Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [8,0,7]

Example 3:

Input: l1 = [0], l2 = [0]
Output: [0]

Constraints:

    The number of nodes in each linked list is in the range [1, 100].
    0 <= Node.val <= 9
    It is guaranteed that the list represents a number that does not have leading zeros.

Follow up: Could you solve it without reversing the input lists?

 */

import java.util.Stack;

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> digits1 = dump(l1);
        Stack<Integer> digits2 = dump(l2);
        ListNode head = null;
        int carry = 0;
        while (!digits1.isEmpty() || !digits2.isEmpty() || carry > 0) {
            if (!digits1.isEmpty()) {
                carry += digits1.pop();
            }
            if (!digits2.isEmpty()) {
                carry += digits2.pop();
            }
            ListNode node = new ListNode(carry % 10);
            node.next = head;
            head = node;
            carry /= 10;
        }
        return head;
    }

    private Stack<Integer> dump(ListNode node) {
        Stack<Integer> digits = new Stack<>();
        while (node != null) {
            digits.push(node.val);
            node = node.next;
        }
        return digits;
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
