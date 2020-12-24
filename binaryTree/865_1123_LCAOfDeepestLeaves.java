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
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return helper(root, 0).getKey();
    }
    
    private Pair<TreeNode, Integer> helper(TreeNode node, int depth) {
        if (node == null) {
            return new Pair<>(node, depth);
        }
        Pair<TreeNode, Integer> leftPair = helper(node.left, depth + 1);
        Pair<TreeNode, Integer> rightPair = helper(node.right, depth + 1);
        if (leftPair.getValue() < rightPair.getValue()) {
            return rightPair;
        } else if (leftPair.getValue() > rightPair.getValue()) {
            return leftPair;
        } else {
            return new Pair<>(node, leftPair.getValue());
        }
    }
}