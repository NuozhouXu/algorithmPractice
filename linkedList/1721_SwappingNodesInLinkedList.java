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
    public ListNode swapNodes(ListNode head, int k) {
        int index = 0;
        ListNode front = null;
        ListNode back = null;
        ListNode curr = head;
        while (curr != null) {
            index++;
            if (back != null) back = back.next;
            if (index == k) {
                front = curr;
                back = head;
            }
            curr = curr.next;
        }
        
        int temp = front.val;
        front.val = back.val;
        back.val = temp;
        return head;
    }
}