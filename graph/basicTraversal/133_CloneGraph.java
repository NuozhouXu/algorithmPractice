/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    // O(N)
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        Map<Node, Node> map = new HashMap<>();
        Deque<Node> queue = new ArrayDeque<>();
        queue.offer(node);
        Node newRoot = new Node(node.val);
        map.put(node, newRoot);
        while (!queue.isEmpty()) {
            Node oldNode = queue.poll();
            Node newNode = map.get(oldNode);
            for (Node neighbor: oldNode.neighbors) {
                if (!map.containsKey(neighbor)) {
                    Node newNeighbor = new Node(neighbor.val);
                    map.put(neighbor, newNeighbor);
                    queue.offer(neighbor);
                }
                newNode.neighbors.add(map.get(neighbor));
            }
        }
        return newRoot;
    }
}