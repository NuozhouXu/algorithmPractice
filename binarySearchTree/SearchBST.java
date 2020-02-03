class Solution {

    // Recursion: average case space and time O(nlogn), worst case space and time O(n)
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || val == root.val) return root;
    
        return val < root.val ? searchBST(root.left, val) : searchBST(root.right, val);
    }

    // Iteration: average case time O(nlogn), worst case time O(n), space O(1)
    public TreeNode searchBSTIteration(TreeNode root, int val) {
        while (root != null && val != root.val)
            root = val < root.val ? root.left : root.right;
        return root;
    }

    public TreeNode minimumBST(TreeNode root) {
        if (root == null) return null;
        while (root.left != null)
            root = root.left;
        return root;
    }

    public TreeNode maximumBST(TreeNode root) {
        if (root == null) return null;
        while (root.right != null)
            root = root.right;
        return root;
    }
}