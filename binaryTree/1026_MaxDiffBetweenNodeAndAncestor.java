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
    
    public int maxAncestorDiff(TreeNode root) {
        if (root == null) return 0;
        int[] ans = new int[1];
        maxAncestorDiffHelper(root, root.val, root.val, ans);
        return ans[0];
    }
    
    private void maxAncestorDiffHelper(TreeNode node, int currMin, int currMax, int[] ans) {
        if (node == null) return;
        
        ans[0] = Math.max(ans[0], Math.max(Math.abs(currMax - node.val), Math.abs(currMin - node.val)));
        
        currMin = Math.min(currMin, node.val);
        currMax = Math.max(currMax, node.val);
        maxAncestorDiffHelper(node.left, currMin, currMax, ans);
        maxAncestorDiffHelper(node.right, currMin, currMax, ans);
    }
}