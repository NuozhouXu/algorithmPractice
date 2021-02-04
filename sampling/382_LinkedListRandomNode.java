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

    private ArrayList<Integer> range = new ArrayList<>();

    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {
        while (head != null) {
            this.range.add(head.val);
            head = head.next;
        }
    }

    /** Returns a random node's value. */
    public int getRandom() {
        int pick = (int)(Math.random() * this.range.size());
        return this.range.get(pick);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */

class Solution {

    private ListNode head;

    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {
        this.head = head;
    }

    // Can be used for stream with unknown length. Reservoir sampling. O(n) time O(1) space
    /** Returns a random node's value. */
    public int getRandom() {
        int scope = 1;
        int chosenValue = 0;
        ListNode curr = head;
        while (curr != null) {
            if (Math.random() < 1.0 / scope) {
                chosenValue = curr.val;
            }
            scope++;
            curr = curr.next;
        }
        return chosenValue;
    }
}