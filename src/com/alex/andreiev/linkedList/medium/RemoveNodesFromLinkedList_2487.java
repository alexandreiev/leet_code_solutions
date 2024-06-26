package com.alex.andreiev.linkedList.medium;

import com.alex.andreiev.utils.ListNode;

/*
You are given the head of a linked list.
Remove every node which has a node with a greater value anywhere to the right side of it.
Return the head of the modified linked list.

Example 1:
Input: head = [5,2,13,3,8]
Output: [13,8]
Explanation: The nodes that should be removed are 5, 2 and 3.
- Node 13 is to the right of node 5.
- Node 13 is to the right of node 2.
- Node 8 is to the right of node 3.

Example 2:
Input: head = [1,1,1,1]
Output: [1,1,1,1]
Explanation: Every node has value 1, so no nodes are removed.

Constraints:
    The number of the nodes in the given list is in the range [1, 105].
    1 <= Node.val <= 105
 */

public class RemoveNodesFromLinkedList_2487 {
    // Reverse Twice
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        var current = head;
        ListNode nextTemp;

        // Set each node's next pointer to the previous node
        while (current != null) {
            nextTemp = current.next;
            current.next = prev;
            prev = current;
            current = nextTemp;
        }

        return prev;
    }

    public ListNode removeNodes(ListNode head) {
        // Reverse the original linked list
        head = reverseList(head);

        var maximum = 0;
        ListNode prev = null;
        ListNode current = head;

        // Traverse the list deleting nodes
        while (current != null) {
            maximum = Math.max(maximum, current.val);

            // Delete nodes that are smaller than maximum
            if (current.val < maximum) {
                // Delete current by skipping
                prev.next = current.next;
                var deleted = current;
                current = current.next;
                deleted.next = null;
            }

            // Current does not need to be deleted
            else {
                prev = current;
                current = current.next;
            }
        }

        // Reverse and return the modified linked list
        return reverseList(head);
    }

    // recursive
//    public ListNode removeNodes(ListNode head) {
//        if (head == null || head.next == null) {
//            return head;
//        }
//
//        var nextNode = removeNodes(head.next);
//        if (head.val < nextNode.val) {
//            return nextNode;
//        } else {
//            head.next = nextNode;
//            return head;
//        }
//    }
}
