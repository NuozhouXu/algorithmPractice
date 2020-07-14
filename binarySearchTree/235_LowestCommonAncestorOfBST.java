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
    // O(N) time O(1) space
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode lca = root;
        while (lca != null) {
            if (lca.val < p.val && lca.val < q.val) {
                lca = lca.right;
            } else if (lca.val > p.val && lca.val > q.val) {
                lca = lca.left;
            } else {
                return lca;
            }
        }
        return null;
    }
}