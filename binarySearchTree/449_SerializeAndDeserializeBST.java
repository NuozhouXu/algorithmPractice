public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }
    
    public void serializeHelper(TreeNode root, StringBuilder sb) {
        if (root == null) return;
        sb.append(root.val).append(",");
        serializeHelper(root.left, sb);
        serializeHelper(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0) return null;
        Deque<String> queue = new ArrayDeque<>();
        String[] vals = data.split(",");
        for (String val: vals) {
            if (val.length() > 0) queue.offer(val);
        }
        return deserializeHelper(queue, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    private TreeNode deserializeHelper(Deque<String> queue, int low, int high) {
        if (queue.isEmpty()) return null;
        String s = queue.peek();
        int val = Integer.parseInt(s);
        if (val < low || val > high) return null;
        queue.poll();
        TreeNode root = new TreeNode(val);
        root.left = deserializeHelper(queue, low, val);
        root.right = deserializeHelper(queue, val, high);
        return root;
    }
}