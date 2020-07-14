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
    // O(N) time O(H) space
    public int sumNumbers(TreeNode root) {
        return preorder(root, 0);
    }
  
    private int preorder(TreeNode node, int curr) {
        if (node == null) return 0;
        int newCurr = curr * 10 + node.val;
        if (node.left == null && node.right == null) return newCurr;
        return preorder(node.left, newCurr) + preorder(node.right, newCurr);
    }
}