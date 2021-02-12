class Codec {
    // Encodes a tree to a single string.
    public String serialize(Node root) {
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }
    
    private void serializeHelper(Node node, StringBuilder sb) {
        sb.append(node.val).append(",");
        sb.append(node.children.size()).append(",");
        for (Node child: node.children) {
            serializeHelper(child, sb);
        }
    }
	
    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        if (data.length() == 0) return null;
        Deque<String> queue = new ArrayDeque<>(Arrays.asList(data.split(",")));
        return deserializeHelper(queue);
    }
    
    private Node deserializeHelper(Deque<String> queue) {
        int val = Integer.parseInt(queue.poll());
        int numChildren = Integer.parseInt(queue.poll());
        Node newNode = new Node(val, new ArrayList<>());
        for (int i = 0; i < numChildren; i++) {
            newNode.children.add(deserializeHelper(queue));
        }
        return newNode;
    }
}