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
    // O(H) time O(1) space
    public int closestValue(TreeNode root, double target) {
        int closest = root.val;
        while (root != null) {
            int val = root.val;
            if (Math.abs(val - target) < Math.abs(closest - target)) {
                closest = val;
            }
            if (val < target) {
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return closest;
    }
}