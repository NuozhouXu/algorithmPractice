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
    // O(n^2) time O(n) space
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructHelper(nums, 0, nums.length - 1);
    }
    
    private TreeNode constructHelper(int[] nums, int start, int end) {
        if (start > end) return null;
        int maximum = nums[start];
        int maxIndex = start;
        for (int i = start; i <= end; i++) {
            if (nums[i] > maximum) {
                maximum = nums[i];
                maxIndex = i;
            }
        }
        TreeNode root = new TreeNode(maximum);
        root.left = constructHelper(nums, start, maxIndex - 1);
        root.right = constructHelper(nums, maxIndex + 1, end);
        return root;
    }

    // O(N) time O(N) space
    public TreeNode constructMaximumBinaryTreeOptimal(int[] nums) {
        Deque<TreeNode> stack = new LinkedList<>();
        for(int i = 0; i < nums.length; i++) {
            TreeNode curr = new TreeNode(nums[i]);
            while(!stack.isEmpty() && stack.peek().val < nums[i]) {
                curr.left = stack.pop();
            }
            if(!stack.isEmpty()) {
                stack.peek().right = curr;
            }
            stack.push(curr);
        }
        
        return stack.isEmpty() ? null : stack.removeLast();
    }
}