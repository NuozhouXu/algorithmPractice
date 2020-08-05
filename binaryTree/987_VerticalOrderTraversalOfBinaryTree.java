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
    class Node {
        public TreeNode node;
        public int row;
        public int col;
        public Node(TreeNode node, int row, int col) {
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();
        if (root == null) return results;
        Map<Integer, PriorityQueue<Node>> columnTable = new HashMap<>();
        Deque<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(root, 0, 0));
        int minCol = 0, maxCol = 0;
        
        while (!queue.isEmpty()) {
            Node n = queue.poll();
            TreeNode node = n.node;
            int row = n.row;
            int col = n.col;
            if (!columnTable.containsKey(col)) {
                columnTable.put(col, new PriorityQueue<>((a, b) -> {
                    if (a.row == b.row) {
                        if (a.col == b.col) {
                            return a.node.val - b.node.val;
                        } else {
                            return a.col - b.col;
                        }
                    } else {
                        return a.row - b.row;
                    }
                }));
            }
            columnTable.get(col).offer(n);
            minCol = Math.min(minCol, col);
            maxCol = Math.max(maxCol, col);
            if (node.left != null) {
                queue.offer(new Node(node.left, row + 1, col - 1));
            }
            if (node.right != null) {
                queue.offer(new Node(node.right, row + 1, col + 1));
            }
        }
        for (int i = minCol; i <= maxCol; i++) {
            PriorityQueue<Node> pq = columnTable.get(i);
            List<Integer> lst = new ArrayList<>();
            while (!pq.isEmpty()) {
                lst.add(pq.poll().node.val);
            }
            results.add(lst);
        }
        return results;
    }
}