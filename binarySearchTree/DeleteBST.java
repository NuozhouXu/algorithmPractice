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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return root;
        if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else {
            TreeNode newRoot = null;
            if (root.left == null) {
                newRoot = root.right;
            } else if (root.right == null) {
                newRoot = root.left;
            } else {
                TreeNode parent = root;
                newRoot = root.right;
                while (newRoot.left != null) {
                    parent = newRoot;
                    newRoot = newRoot.left;
                }

                if (parent != root) {
                    parent.left = newRoot.right;
                    newRoot.right = root.right;
                }

                newRoot.left = root.left;
            }
            return newRoot;
        }
        return root;
    }
}