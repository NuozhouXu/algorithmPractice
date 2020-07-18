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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root == null) return paths;
        preorderHelper(paths, new StringBuilder(), root);
        return paths;
    }
    
    private void preorderHelper(List<String> paths, StringBuilder sb, TreeNode node) {
        int len = sb.length();
        sb.append(node.val);
        if (node.left == null && node.right == null) {
            paths.add(sb.toString());
        } else {
            sb.append("->");
            if (node.left != null) {
                preorderHelper(paths, sb, node.left);
            }
            if (node.right != null) {
                preorderHelper(paths, sb, node.right);
            }
        }
        sb.setLength(len);
    }
}