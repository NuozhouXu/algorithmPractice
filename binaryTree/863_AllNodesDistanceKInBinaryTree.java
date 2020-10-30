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


    public List<Node> findKDistanceFromTarget(Node root, Node target, int K) {
        if (root == null) return new ArrayList<>();
        Map<Node, List<Node>> graph = new HashMap<>();
        traverse(graph, root);
        return bfs(graph, target, K);
      }
        
      // O(N) time
      private void traverse(Map<Node, List<Node>> graph, Node root) {
        if (root == null) {
          return;
        }
        
        graph.putIfAbsent(root, new ArrayList<>());
        
        if (root.left != null) {
          graph.putIfAbsent(root.left, new ArrayList<>());
          graph.get(root).add(root.left);
          graph.get(root.left).add(root);
          traverse(graph, root.left);
        }
        
        if (root.right != null) {
          graph.putIfAbsent(root.right, new ArrayList<>());
          graph.get(root).add(root.right);
          graph.get(root.right).add(root);
          traverse(graph, root.right);
        }
      }
        
        
      // O(N) 
      private List<Node> bfs(Map<Node, List<Node>> graph, Node target, int K) {
        Deque<Node> queue = new ArrayDeque<>();
        Set<Node> visited = new HashSet<>();
        
        queue.offer(target);
        visited.add(target);
        int dist = 0;
        
        while (!queue.isEmpty()) {
          int size = queue.size();
          List<Node> currLevel = new ArrayList<>();
          for (int i = 0; i < size; i++) {
            Node node = queue.poll();
            currLevel.add(node);
            for (Node neighbor: graph.get(node)) {
              if (!visited.contains(neighbor)) {
                queue.offer(neighbor);
                visited.add(neighbor);
              }
            }
          }
          dist++;
          if (dist == K) {
            return currLevel;
          }
        }
        
        return new ArrayList<>();
      }
}