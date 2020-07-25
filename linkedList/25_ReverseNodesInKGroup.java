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
    
    // O(N) time O(N/k) space
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

    // O(N) time O(1) space
    public ListNode reverseKGroupIterative(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevTail = dummy;
        ListNode curr = head;
        while (curr != null) {
            int count = 0;
            while (curr != null && count < k) {
                curr = curr.next;
                count++;
            }
            if (count == k) {
                ListNode reversedHead = reverseKLinkedList(head, k);
                prevTail.next = reversedHead;
                prevTail = head;
                head = curr;
            }
        }
        prevTail.next = head;
        return dummy.next;
    }
}