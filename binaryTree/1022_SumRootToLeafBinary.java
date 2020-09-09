class Solution {
    // O(N) time O(h) space
    public int sumRootToLeaf(TreeNode root) {
        int[] sum = new int[1];
        sumRootToLeafHelper(root, 0, sum);
        return sum[0];
    }
    
    private void sumRootToLeafHelper(TreeNode node, int curr, int[] sum) {
        if (node == null) return;
        if (node.left == null && node.right == null) {
            int num = curr * 2 + node.val;
            sum[0] += num;
            return;
        }
        sumRootToLeafHelper(node.left, curr * 2 + node.val, sum);
        sumRootToLeafHelper(node.right, curr * 2 + node.val, sum);
    }
}