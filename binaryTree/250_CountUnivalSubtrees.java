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
    // O(N) time 
    public int countUnivalSubtrees(TreeNode root) {
        if (root == null) return 0;
        int[] count = new int[1];
        countUnivalSubtreesHelper(root, count);
        return count[0];
    }
    
    private boolean countUnivalSubtreesHelper(TreeNode node, int[] count) {
        if (node.left == null && node.right == null) {
            count[0]++;
            return true;
        }
        boolean isUnival = true;
        if (node.left != null) {
            isUnival = countUnivalSubtreesHelper(node.left, count) && isUnival && node.val == node.left.val;
        }
        if (node.right != null) {
            isUnival = countUnivalSubtreesHelper(node.right, count) && isUnival && node.val == node.right.val;
        }
        if (isUnival) count[0]++;
        return isUnival;
    }
}