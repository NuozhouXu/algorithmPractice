/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode secondHead = slow;
        prev.next = null;
        ListNode first = sortList(head);
        ListNode second = sortList(secondHead);
        return merge(first, second);
    }
    
    private ListNode merge(ListNode first, ListNode second) {
        ListNode dummyHead = new ListNode(-1);
        ListNode curr = dummyHead;
        while (first != null && second != null) {
            if (first.val < second.val) {
                curr.next = first;
                first = first.next;
            } else {
                curr.next = second;
                second = second.next;
            }
            curr = curr.next;
        }
        if (first != null) curr.next = first;
        if (second != null) curr.next = second;
        return dummyHead.next;
    }
}