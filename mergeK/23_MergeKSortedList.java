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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummyHead = new ListNode(-1);
        ListNode curr = dummyHead;
        // O(k) space
        PriorityQueue<ListNode> heap = new PriorityQueue<>((node1, node2) -> node1.val - node2.val);
        // O(klogk) time
        for (ListNode listNode: lists) {
            if (listNode != null) heap.offer(listNode);
        }
        // O(nlogk) time
        while (!heap.isEmpty()) {
            ListNode node = heap.poll();
            curr.next = node;
            curr = curr.next;
            if (node.next != null) {
                heap.offer(node.next);
            }
        }
        
        return dummyHead.next;
    }
}