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
    public ListNode plusOne(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        
        ListNode node = dummyHead;
        ListNode not9Node = dummyHead;
        while (node != null) {
            if (node.val != 9) not9Node = node;
            node = node.next;
        }
        not9Node.val++;
        node = not9Node.next;
        
        while (node != null) {
            node.val = 0;
            node = node.next;
        }
        
        return dummyHead.val == 0 ? dummyHead.next : dummyHead;
    }
}