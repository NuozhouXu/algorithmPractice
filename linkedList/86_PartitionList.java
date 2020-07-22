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
    public ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode(0);
        ListNode dummy2 = new ListNode(0);
        ListNode head1 = dummy1;
        ListNode head2 = dummy2;
        ListNode curr = head;
        while (curr != null) {
            if (curr.val < x) {
                head1.next = curr;
                head1 = head1.next;
            } else {
                head2.next = curr;
                head2 = head2.next;
            }
            curr = curr.next;
        }
        head1.next = dummy2.next;
        head2.next = null;
        return dummy1.next;
    }
}