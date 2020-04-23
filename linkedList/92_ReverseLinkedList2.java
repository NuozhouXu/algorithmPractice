/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        int index = 1;
        ListNode prev = null;
        ListNode curr = head;
        while (index < m) {
            prev = curr;
            curr = curr.next;
            index++;
        }
        ListNode start = prev; 
        ListNode end = curr;
        while (index <= n) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
            index++;
        }
        if (start == null) {
            head = prev;
        } else {
            start.next = prev;
        }
        end.next = curr;
        return head;
    }
}