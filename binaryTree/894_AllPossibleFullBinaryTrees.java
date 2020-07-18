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
    // similar to 96
    // Time O(2^N), Space O(2^N) ??
    public List<TreeNode> allPossibleFBT(int N) {
        return allPossibleFBTHelper(N, new HashMap<>());
    }
    
    private List<TreeNode> allPossibleFBTHelper(int N, Map<Integer, List<TreeNode>> map) {
        if (map.containsKey(N)) return map.get(N);
        List<TreeNode> results = new ArrayList<>();
        if (N % 2 == 0) return results;
        if (N == 1){
            results.add(new TreeNode(0));
            return results;
        }
        N--;
        for (int i = 1; i < N; i+=2) {
            List<TreeNode> left = allPossibleFBT(i);
            List<TreeNode> right = allPossibleFBT(N - i);
            for (TreeNode l: left) {
                for (TreeNode r: right) {
                    TreeNode root = new TreeNode(0);
                    root.left = l;
                    root.right = r;
                    results.add(root);
                }
            }
        }
        map.put(N, results);
        return results;
    }
}