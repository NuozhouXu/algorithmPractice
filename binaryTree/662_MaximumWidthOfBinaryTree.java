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
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        int maxWidth = 0;
        Deque<Pair<TreeNode, Integer>> queue = new ArrayDeque<>();
        queue.offer(new Pair<>(root, 0));
        while (queue.size() > 0) {
            Integer headValue = queue.peek().getValue();
            int size = queue.size();
            Pair<TreeNode, Integer> pair = queue.peek();
            for (int i = 0; i < size; i++) {
                pair = queue.poll();
                TreeNode node = pair.getKey();
                if (node.left != null) {
                    queue.offer(new Pair<>(node.left, 2* pair.getValue()));
                }
                if (node.right != null) {
                    queue.offer(new Pair<>(node.right, 2 * pair.getValue() + 1));
                }
            }
            maxWidth = Math.max(maxWidth, pair.getValue() - headValue + 1);
        }
        return maxWidth;
    }
}