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
    double max;
    
    public double maximumAverageSubtree(TreeNode root) {
        max = 0.0;
        helper(root);
        return max;
    }
    
    private int[] helper(TreeNode node) {
        if (node.left == null && node.right == null) {
            max = Math.max(max, (double) node.val);
            return new int[]{node.val, 1};
        }
        int sum = 0;
        int count = 0;
        if (node.left != null) {
            int[] left = helper(node.left);
            sum += left[0];
            count += left[1];
        }
        if (node.right != null) {
            int[] right = helper(node.right);
            sum += right[0];
            count += right[1];
        }
        sum += node.val;
        count++;
        max = Math.max(max, (double) sum / (double) count);
        return new int[]{sum, count};
    }
}