/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head; 
        ListNode lastNode = null;
        ListNode curr = head;
        int length = 0;
        while (curr != null) {
            if (curr.next == null) lastNode = curr;
            length++;
            curr = curr.next;
        }
        k %= length;
        if (k == 0) return head;
        curr = head;
        for (int i = 0; i < length - k - 1; i++) {
            curr = curr.next;
        }
        lastNode.next = head;
        ListNode newHead = curr.next;
        curr.next = null;
        return newHead;
    }
}