class Solution {
    int maxValue;
    
    public int maxPathSum(TreeNode root) {
        maxValue = Integer.MIN_VALUE;
        maxPathDown(root);
        return maxValue;
    }
    
    private int maxPathDown(TreeNode node) {
        if (node == null) return 0;
        int left = maxPathDown(node.left);
        int right = maxPathDown(node.right);
        maxValue = Math.max(node.val + left + right, maxValue);
        return Math.max(Math.max(left, right) + node.val, 0);
    }
}