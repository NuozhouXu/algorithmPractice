/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> results = new ArrayList<>();
        preorderHelper(results, root);
        return results;
    }
    
    private void preorderHelper(List<Integer> results, Node node) {
        if (node == null) return;
        results.add(node.val);
        for (Node n: node.children) {
            preorderHelper(results, n);
        }
    }
}