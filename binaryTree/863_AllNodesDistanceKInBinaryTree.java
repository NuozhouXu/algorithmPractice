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
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> results = new ArrayList<>();
        if (root == null) return results;
        Map<TreeNode, Integer> map = new HashMap<>();
        find(map, root, target);
        dfs(results, map, root, map.get(root), K);
        return results;
    }
    
    private int find(Map<TreeNode, Integer> map, TreeNode root, TreeNode target) {
        if (root == null) return -1;
        if (root == target) {
            map.put(root, 0);
            return 0;
        }
        int left = find(map, root.left, target);
        if (left >= 0) {
            map.put(root, left + 1);
            return left + 1;
        }
        int right = find(map, root.right, target);
        if (right >= 0) {
            map.put(root, right + 1);
            return right + 1;
        }
        return -1;
    }
    
    private void dfs(List<Integer> results, Map<TreeNode, Integer> map, TreeNode root, int len, int K) {
        if (len == K) {
            results.add(root.val);
        }
        if (root.left != null) {
            int leftLen = map.containsKey(root.left) ? len - 1 : len + 1;
            dfs(results, map, root.left, leftLen, K);
        }
        if (root.right != null) {
            int rightLen = map.containsKey(root.right) ? len - 1 : len + 1;
            dfs(results, map, root.right, rightLen, K);
        }
    } 
}