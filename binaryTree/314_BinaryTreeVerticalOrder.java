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
    /*
    class Pair<U, V> {
        public U key;
        public V value;
        
        public Pair(U key, V value) {
            this.key = key;
            this.value = value;
        }
        
        public U getKey() { return key; }
        public V getValue() { return value; }
    }
    */
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> output = new ArrayList();
        if (root == null) {
          return output;
        }
        
        Map<Integer, List<Integer>> columnTable = new HashMap<>();
        Deque<Pair<TreeNode, Integer>> queue = new ArrayDeque<>();
        queue.offer(new Pair<>(root, 0));
        
        int minCol = 0, maxCol = 0;
        
        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> p = queue.poll();
            TreeNode node = p.getKey();
            int col = p.getValue();
            
            if (!columnTable.containsKey(col)) {
                columnTable.put(col, new ArrayList<>());
            }
            columnTable.get(col).add(node.val);
            minCol = Math.min(minCol, col);
            maxCol = Math.max(maxCol, col);
            if (node.left != null) queue.offer(new Pair<>(node.left, col - 1));
            if (node.right != null) queue.offer(new Pair<>(node.right, col + 1));
        }
        
        for (int i = minCol; i <= maxCol; i++) {
            output.add(columnTable.get(i));
        }
        return output;
    }
}