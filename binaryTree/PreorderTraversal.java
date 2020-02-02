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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        preorderTraversalHelper(root, results);
        return results;
    }

    private void preorderTraversalHelper(TreeNode node, List<Integer> results) {
        if (node != null) {
            results.add(node.val);
            preorderTraversalHelper(node.left, results);
            preorderTraversalHelper(node.right, results);
        }
    }

    public List<Integer> preorderTraversalIterative(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        if (root == null) return results;
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            results.add(node.val);
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }
        return results;
    }
}