/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    // O(N) time O(N) space
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        
        ListNode firstNode = head;
        ListNode secondNode = head.next;

        firstNode.next  = swapPairs(secondNode.next);
        secondNode.next = firstNode;

        return secondNode;
    }

    // O(N) time and O(1) space
    public ListNode swapPairsIterative(ListNode head) {
        
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode curr = head;
        ListNode prev = dummyHead;
        
        while (curr != null && curr.next != null) {
            ListNode first = curr;
            ListNode second = curr.next;
            
            prev.next = second;
            first.next = second.next;
            second.next = first;
            
            prev = first;
            curr = first.next;
        }
        return dummyHead.next;
    }
}