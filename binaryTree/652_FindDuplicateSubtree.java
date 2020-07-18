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
    // O(n^2) time and space
    // 
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> results = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        postorderHelper(root, results, map);
        return results;
    }
    
    private String postorderHelper(TreeNode node, List<TreeNode> results, Map<String, Integer> map) {
        if (node == null) return "#";
        StringBuilder sb = new StringBuilder();
        sb.append(node.val).append(",").append(postorderHelper(node.left, results, map)).append(",").append(postorderHelper(node.right, results, map));
        String serial = sb.toString();
        if (map.getOrDefault(serial, 0) == 1) results.add(node);
        map.put(serial, map.getOrDefault(serial, 0) + 1);
        return serial;
    }
}