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
    public int longestUnivaluePath(TreeNode root) {
        int[] len = new int[1];
        longestUnivaluePathHelper(root, len);
        return len[0];
    }
    
    private int longestUnivaluePathHelper(TreeNode node, int[] len) {
        if (node == null) return 0;
        int left = longestUnivaluePathHelper(node.left, len);
        int right = longestUnivaluePathHelper(node.right, len);
        int newLeft = 0;
        int newRight = 0;
        if (node.left != null && node.left.val == node.val) {
            newLeft = left + 1;
        }
        if (node.right != null && node.right.val == node.val) {
            newRight = right + 1;
        }
        len[0] = Math.max(len[0], newLeft + newRight);
        return Math.max(newLeft, newRight);
    } 
}