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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        postorderTraversalHelper(root, results);
        return results;
    }

    private void postorderTraversalHelper(TreeNode node, List<Integer> results) {
        if (node != null) {
            postorderTraversalHelper(node.left, results);
            postorderTraversalHelper(node.right, results);
            results.add(node.val);
        }
    }
}