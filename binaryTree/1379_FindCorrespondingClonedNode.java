class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (original == null && cloned == null) return null;
        TreeNode nodeOriginal = original;
        TreeNode nodeCloned = cloned;
        Deque<TreeNode> stack = new ArrayDeque<>();
        Deque<TreeNode> clonedStack = new ArrayDeque<>();
        while (nodeOriginal != null || !stack.isEmpty()) {
            while (nodeOriginal != null) {
                stack.push(nodeOriginal);
                clonedStack.push(nodeCloned);
                nodeOriginal = nodeOriginal.left;
                nodeCloned = nodeCloned.left;
            }
            nodeOriginal = stack.pop();
            nodeCloned = clonedStack.pop();
            if (nodeOriginal == target) {
                return nodeCloned;
            }
            nodeOriginal = nodeOriginal.right;
            nodeCloned = nodeCloned.right;
        }
        return null;
    }
}