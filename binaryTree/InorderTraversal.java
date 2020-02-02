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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        inorderTraversalHelper(root, results);
        return results;
    }

    private void inorderTraversalHelper(TreeNode node, List<Integer> results) {
        if (node != null) {
            inorderTraversalHelper(node.left, results);
            results.add(node.val);
            inorderTraversalHelper(node.right, results);
        }
    }
}