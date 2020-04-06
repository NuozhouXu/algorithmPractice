/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public void flatten(TreeNode root) {
        if (root == null) return;
        flattenHelper(root);
    }
    
    private TreeNode flattenHelper(TreeNode node) {
        if (node.left == null && node.right == null) {
            return node;
        } else if (node.left == null) {
            node.right = flattenHelper(node.right);
            node.left = null;
            return node;
        } else if (node.right == null) {
            node.right = flattenHelper(node.left);
            node.left = null;
            return node;
        } else {
            TreeNode leftBranch = flattenHelper(node.left);
            TreeNode rightBranch = flattenHelper(node.right);
            node.right = leftBranch;
            while (leftBranch.right != null) {
                leftBranch = leftBranch.right;
            }
            leftBranch.right = rightBranch;
            node.left = null;
            return node;
        }
    }

    public void flattenNoExtraSpace(TreeNode root) {
        if (root == null) return;
        
        TreeNode node = root;
        
        while (node != null) {
            if (node.left != null) {
                TreeNode rightmost = node.left;
                while (rightmost.right != null) {
                    rightmost = rightmost.right;
                }
                rightmost.right = node.right;
                node.right = node.left;
                node.left = null;
            }
            node = node.right;
        }
    }
}