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
    int count = 0;
    public int countPairs(TreeNode root, int distance) {
        if (root == null) return 0;
        countPairsHelper(root, distance);
        return count;
    }
    
    private Map<Integer, Integer> countPairsHelper(TreeNode node, int distance) {
        Map<Integer, Integer> map = new HashMap<>(); // distance to root --> count
        if (node == null) return map;
        if (node.left == null && node.right == null) {
            map.put(0, 1);
            return map;
        }
        Map<Integer, Integer> leftMap = countPairsHelper(node.left, distance);
        Map<Integer, Integer> rightMap = countPairsHelper(node.right, distance);
        for (int distLeft: leftMap.keySet()) {
            int distLeftToRoot = distLeft + 1;
            for (int distRight: rightMap.keySet()) {
                int distRightToRoot = distRight + 1;
                if (distLeftToRoot + distRightToRoot <= distance) {
                    count += leftMap.get(distLeft) * rightMap.get(distRight);
                }
            }
        }
        
        
        for (int dist: leftMap.keySet()) {
            map.put(dist + 1, map.getOrDefault(dist + 1, 0) + leftMap.get(dist));
        }
        for (int dist: rightMap.keySet()) {
            map.put(dist + 1, map.getOrDefault(dist + 1, 0) + rightMap.get(dist));
        }
        return map;
    }
}