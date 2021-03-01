class Solution {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();
        findLeavesHelper(root, results);
        return results;
    }
    
    private int findLeavesHelper(TreeNode node, List<List<Integer>> results) {
        if (node == null) {
            return -1;
        }
        int leftLevel = findLeavesHelper(node.left, results);
        int rightLevel = findLeavesHelper(node.right, results);
        int level = 1 + Math.max(leftLevel, rightLevel);
        if (results.size() == level) {
            results.add(new ArrayList<>());
        }
        results.get(level).add(node.val);
        return level;
    }
}