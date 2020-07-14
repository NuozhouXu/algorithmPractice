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

    // O(N) time O(N) space
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> nums = inorderTraversal(root);
        int i = 0, j = nums.size() - 1;
        while (i < j) {
            int sum = nums.get(i) + nums.get(j);
            if (sum == k) {
                return true;
            } else if (sum < k) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }
    
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