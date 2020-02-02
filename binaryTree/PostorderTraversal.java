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

    public List<Integer> postorderIterative(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        if (root == null) return results;
        Deque<TreeNode> stack = new ArrayDeque<>();

        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            results.add(0, node.val);
            if (node.left != null) stack.push(node.left);
            if (node.right != null) stack.push(node.right);
        }

        return results;
    }
}