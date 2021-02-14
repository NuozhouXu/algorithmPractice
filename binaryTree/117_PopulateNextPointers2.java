/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if (root == null) return null;
        Deque<Node> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (i < size - 1) {
                    node.next = queue.peek();
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return root;
    }

    public Node connectNoSpace(Node root) {
        if (root == null) return null;
        Node node = root;
        Node nextLevelDummyHead = new Node(-1);
        while (node != null) {
            Node curr = nextLevelDummyHead;
            while (node != null) {
                if (node.left != null) {
                    curr.next = node.left;
                    curr = curr.next;
                }
                if (node.right != null) {
                    curr.next = node.right;
                    curr = curr.next;
                }
                node = node.next;
            }
            node = nextLevelDummyHead.next;
            nextLevelDummyHead.next = null;
        }
        return root;
    }
}