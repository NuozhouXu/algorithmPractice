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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> results = new ArrayList<>();
        pathSumHelper(results, new ArrayList<>(), root, sum);
        return results;
    }
    
    private void pathSumHelper(List<List<Integer>> results, List<Integer> tempList, TreeNode node, int sum) {
        if (node == null) return;
        tempList.add(node.val);
        int newSum = sum - node.val;
        if (newSum == 0 && node.left == null && node.right == null) {
            results.add(new ArrayList<>(tempList));
        } else {
            pathSumHelper(results, tempList, node.left, newSum);
            pathSumHelper(results, tempList, node.right, newSum);
        }
        tempList.remove(tempList.size() - 1);
    }
}