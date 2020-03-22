class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();
        if (root == null) return results;
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        int level = 0;
        
        while (!deque.isEmpty()) {
            LinkedList<Integer> currentLevel = new LinkedList<>();
            int currentLevelLength = deque.size();
            for (int i = 0; i < currentLevelLength; i++) {
                TreeNode node = deque.poll();
                if (level % 2 == 0) {
                    currentLevel.add(node.val);
                } else {
                    currentLevel.addFirst(node.val);
                }
                if (node.left != null) {
                    deque.add(node.left);
                }
                if (node.right != null) {
                    deque.add(node.right);
                }
            }
            results.add(currentLevel);
            level++;
        }
        return results;
    }
}