class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return buildTreeHelper(preorder, inorder, inorderMap, 0, 0, inorder.length - 1);
    }
    
    private TreeNode buildTreeHelper(int[] preorder, int[] inorder, Map<Integer, Integer> inorderMap, int preorderIndex, int inorderStart, int inorderEnd) {
        if (inorderStart > inorderEnd || preorderIndex > preorder.length) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preorderIndex]);
        int inorderIndex = inorderMap.get(root.val);
        root.left = buildTreeHelper(preorder, inorder, inorderMap, preorderIndex + 1, inorderStart, inorderIndex - 1);
        root.right = buildTreeHelper(preorder, inorder, inorderMap, preorderIndex + inorderIndex - inorderStart + 1, inorderIndex + 1, inorderEnd);
        return root;
    }
}