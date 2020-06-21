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

    public int rob1(TreeNode root) {
        return robHelper(new HashMap<>(), root);
    }
    
    private int robHelper1(Map<TreeNode, Integer> memo, TreeNode node) {
        if (node == null) return 0;
        if (memo.containsKey(node)) return memo.get(node);
        int robRootResult = node.val;
        if (node.left != null) {
            robRootResult += robHelper(memo, node.left.left) + robHelper(memo, node.left.right);
        }
        if (node.right != null) {
            robRootResult += robHelper(memo, node.right.left) + robHelper(memo, node.right.right);
        }
        
        int ans = Math.max(robRootResult, robHelper(memo, node.left) + robHelper(memo, node.right));
        memo.put(node, ans);
        return ans;
    }

    public int rob2(TreeNode root) {
        int[] res = robHelper(root);
        return Math.max(res[0], res[1]);
    }
    
    private int[] robHelper2(TreeNode node) {
        if (node == null) return new int[2];
        
        int[] left = robHelper(node.left);
        int[] right = robHelper(node.right);
        int[] res = new int[2];
        
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        res[1] = node.val + left[0] + right[0];
        return res;
    }
}