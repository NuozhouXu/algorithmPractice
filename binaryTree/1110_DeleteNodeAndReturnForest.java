class Solution {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> results = new ArrayList<>();
        Set<Integer> deleteSet = new HashSet<>();
        for (int num: to_delete) deleteSet.add(num);
        delNodesHelper(root, results, deleteSet, true);
        return results;
    }
    
    private TreeNode delNodesHelper(TreeNode root, List<TreeNode> results, Set<Integer> deleteSet, boolean isRoot) {
        if (root == null) return null;
        boolean deleted = deleteSet.contains(root.val);
        if (isRoot && !deleted) results.add(root);
        root.left = delNodesHelper(root.left, results, deleteSet, deleted);
        root.right = delNodesHelper(root.right, results, deleteSet, deleted);
        return deleted ? null : root;
    }
}