/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    HashMap<Node, Node> map = new HashMap<>();
    
    private Node getClonedNode(Node node) {
        if (node != null) {
            if (map.containsKey(node)) {
                return map.get(node);
            } else {
                Node newNode = new Node(node.val);
                map.put(node, newNode);
                return newNode;
            }
        }
        return null;
    }
    
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Node curr = head;
        Node copyHead = new Node(curr.val);
        Node copyCurr = copyHead;
        map.put(curr, copyCurr);
        while (curr != null) {
            copyCurr.next = getClonedNode(curr.next);
            copyCurr.random = getClonedNode(curr.random);
            
            copyCurr = copyCurr.next;
            curr = curr.next;
        }
        return copyHead;
    }
}