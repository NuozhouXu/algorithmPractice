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
    // Note: Elements processed in the inorder fashion on a binary search tree turn out to be sorted in ascending order.
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

    public List<Integer> inorderIterative(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        if (root == null) return results;
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            results.add(curr.val);
            curr = curr.right;
        }
        return results;
    }
}