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
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) return false;
        if (isSame(s, t)) return true;
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }
    
    private boolean isSame(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        
        return s.val == t.val && isSame(s.left, t.left) && isSame(s.right, t.right);
    }

    boolean found = false;
    public boolean isSubtreeSerialize(TreeNode s, TreeNode t) {
        String target = postorderHelper(t, null);
        postorderHelper(s, target);
        return found;
    }
    
    private String postorderHelper(TreeNode node, String target) {
        if (found) return "";
        if (node == null) return "#";
        StringBuilder sb = new StringBuilder();
        sb.append(node.val).append(",").append(postorderHelper(node.left, target)).append(",").append(postorderHelper(node.right, target));
        String s = sb.toString();
        if (target != null && s.equals(target)) {
            found = true;
        }
        return s;
    }
}