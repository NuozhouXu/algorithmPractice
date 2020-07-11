/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    // O(N) time O(N) space
    public Node flatten(Node head) {
        if (head == null) return null;
        Node dummyHead = new Node(0, null, head, null);
        flattenHelper(dummyHead, head);
        dummyHead.next.prev = null;
        return dummyHead.next;
    }
    
    // returns the tail of the flatten list
    public Node flattenHelper(Node prev, Node curr) {
        if (curr == null) return prev;
        curr.prev = prev;
        prev.next = curr;
        
        Node nextNode = curr.next;
        Node tail = flattenHelper(curr, curr.child);
        curr.child = null;
        
        return flattenHelper(tail, nextNode);
    }
}