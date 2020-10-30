class Codec {
    // O(N) time and O(H) space where H is height of binary tree
    // Encodes an n-ary tree to a binary tree.
    public TreeNode encode(Node root) {
        if (root == null) return null;
        TreeNode newRoot = new TreeNode(root.val);
        
        if (root.children.size() > 0) {
            Node firstChild = root.children.get(0);
            newRoot.left = encode(firstChild);
        }
        
        TreeNode sibling = newRoot.left;
        for (int i = 1; i < root.children.size(); i++) {
            sibling.right = encode(root.children.get(i));
            sibling = sibling.right;
        }
        return newRoot;
    }
	
    // Decodes your binary tree to an n-ary tree.
    public Node decode(TreeNode root) {
        if (root == null) return null;
        Node newRoot = new Node(root.val, new ArrayList<>());
        TreeNode sibling = root.left;
        while (sibling != null) {
            newRoot.children.add(decode(sibling));
            sibling = sibling.right;
        }
        return newRoot;
    }
}