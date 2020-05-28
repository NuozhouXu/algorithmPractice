/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int maxPath;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        maxPath = Integer.MIN_VALUE;
        maxSideLength(root);
        return maxPath - 1;
    }
    
    private int maxSideLength(TreeNode node) {
        if (node == null) return 0;
        int left = maxSideLength(node.left);
        int right = maxSideLength(node.right);
        maxPath = Math.max(left + right + 1, maxPath);
        return Math.max(left, right) + 1;
    }
}