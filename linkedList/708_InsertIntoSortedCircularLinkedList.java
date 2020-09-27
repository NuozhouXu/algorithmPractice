class Solution {
    public Node insert(Node head, int insertVal) {
        if (head == null) {
            head = new Node(insertVal);
            head.next = head;
            return head;
        }
        Node prev = head;
        Node curr = head.next;
        do {
            if (prev.val <= insertVal && insertVal <= curr.val) {
                insertBetween(prev, curr, insertVal);
                return head;
            } else if (prev.val > curr.val) {
                if (insertVal <= curr.val || insertVal >= prev.val) {
                    insertBetween(prev, curr, insertVal);
                    return head;
                }
            }
            prev = curr;
            curr = curr.next;
        } while (prev != head);
        insertBetween(prev, curr, insertVal);
        return head;
    }
    
    private void insertBetween(Node prev, Node curr, int insertVal) {
        Node newNode = new Node(insertVal);
        prev.next = newNode;
        newNode.next = curr;
    }
}