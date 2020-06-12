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
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<>();
        Map<String, List<TreeNode>> dp = new HashMap<>();
        return generateTreesHelper(1, n, dp);
    }
    
    private List<TreeNode> generateTreesHelper(int start, int end, Map<String, List<TreeNode>> dp) {
        List<TreeNode> results = new ArrayList<>();
        if (start > end) {
            results.add(null);
            return results;
        }
        String key = start + "," + end;
        if (dp.containsKey(key)) {
            return dp.get(key);
        }
        
        for (int i = start; i <= end; i++) {
            List<TreeNode> lNodes = generateTreesHelper(start, i - 1, dp);
            List<TreeNode> rNodes = generateTreesHelper(i + 1, end, dp);
            for (TreeNode l: lNodes) {
                for (TreeNode r: rNodes) {
                    TreeNode node = new TreeNode(i);
                    node.left = l;
                    node.right = r;
                    results.add(node);
                }
            }
        }
        dp.put(key, results);
        return results;
    }
}