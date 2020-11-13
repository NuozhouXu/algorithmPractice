class Solution {
    public int findTilt(TreeNode root) {
        int[] sumTilt = new int[1];
        findTiltHelper(root, sumTilt);
        return sumTilt[0];
    }
    
    private int findTiltHelper(TreeNode node, int[] sumTilt) {
        if (node == null) return 0;
        if (node.left == null && node.right == null) return node.val;
        int leftSum = findTiltHelper(node.left, sumTilt);
        int rightSum = findTiltHelper(node.right, sumTilt);
        sumTilt[0] += Math.abs(leftSum - rightSum);
        return leftSum + rightSum + node.val;
    }
}