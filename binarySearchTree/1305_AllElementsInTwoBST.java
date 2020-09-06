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
    // O(M + N) time and space
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> sorted1 = new ArrayList<>();
        List<Integer> sorted2 = new ArrayList<>();
        inorder(sorted1, root1);
        inorder(sorted2, root2);
        List<Integer> output = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < sorted1.size() && j < sorted2.size()) {
            int val1 = sorted1.get(i);
            int val2 = sorted2.get(j);
            if (val1 < val2) {
                output.add(val1);
                i++;
            } else {
                output.add(val2);
                j++;
            }
        }
        while (i < sorted1.size()) {
            output.add(sorted1.get(i));
            i++;
        }
        while (j < sorted2.size()) {
            output.add(sorted2.get(j));
            j++;
        }
        return output;
    }
    
    private void inorder(List<Integer> results, TreeNode node) {
        if (node != null) {
            inorder(results, node.left);
            results.add(node.val);
            inorder(results, node.right);
        }
    }
}