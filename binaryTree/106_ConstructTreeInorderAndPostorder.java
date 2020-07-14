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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        return buildTreeHelper(inorder, postorder, inMap, postorder.length - 1, 0, inorder.length - 1);
    }
    
    private TreeNode buildTreeHelper(int[] inorder, int[] postorder, Map<Integer, Integer> inorderMap, int postorderIndex, int inorderStart, int inorderEnd) {
        if (inorderStart > inorderEnd || postorderIndex < 0) return null;
        TreeNode root = new TreeNode(postorder[postorderIndex]);
        int inorderIndex = inorderMap.get(postorder[postorderIndex]);
        root.right = buildTreeHelper(inorder, postorder, inorderMap, postorderIndex - 1, inorderIndex + 1, inorderEnd);
        root.left = buildTreeHelper(inorder, postorder, inorderMap, postorderIndex - (inorderEnd - inorderIndex + 1), inorderStart, inorderIndex - 1);
        return root;
    }
}