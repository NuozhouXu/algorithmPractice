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
    private ListNode reverseKLinkedList(ListNode head, int k) {
        ListNode prev = null;
        ListNode curr = head;
        while (k > 0) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
            k--;
        }
        return prev;
    }
    
    public ListNode reverseKGroup(ListNode head, int k) {
        int count = 0;
        ListNode curr = head;
        while (count < k && curr != null) {
            curr = curr.next;
            count++;
        }
        if (count == k) {
            ListNode reversedHead = reverseKLinkedList(head, k);
            head.next = reverseKGroup(curr, k);
            return reversedHead;
        }
        
        return head;
    }
}