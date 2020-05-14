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
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode succ = null;
        while (root != null) {
            if (p.val < root.val) {
                succ = root;
                root = root.left;
            }
            else
                root = root.right;
        }
        return succ;
    }

    public TreeNode inorderSuccessorRecursive(TreeNode root, TreeNode p) {
        if (root == null) return null;
        if (p.val >= root.val) {
            return inorderSuccessorRecursive(root.right, p);
        } else {
            TreeNode left = inorderSuccessorRecursive(root.left, p);
            return (left != null) ? left : root;
        }
    }
}