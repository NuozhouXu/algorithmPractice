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
    public List<Integer> postorder(Node root) {
        List<Integer> results = new ArrayList<>();
        postorderHelper(results, root);
        return results;
    }
    
    private void postorderHelper(List<Integer> results, Node node) {
        if (node == null) return;
        for (Node child: node.children) {
            postorderHelper(results, child);
        }
        results.add(node.val);
    }
}