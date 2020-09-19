class Solution {

    public int[] findOrderKahn(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> indegrees = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
            indegrees.put(prerequisites[i][0], indegrees.getOrDefault(prerequisites[i][0], 0) + 1);
        }
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegrees.getOrDefault(i, 0) == 0) {
                queue.offer(i);
            }
        }
        int[] topologicalOrder = new int[numCourses];
        int index = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            topologicalOrder[index++] = course;
            for (int neighbor: graph.get(course)) {
                indegrees.put(neighbor, indegrees.get(neighbor) - 1);
                if (indegrees.get(neighbor) == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        if (index < numCourses - 1) {
            return new int[0];
        }
        return topologicalOrder;
    }

    private static int WHITE = 1;
    private static int GRAY = 2;
    private static int BLACK = 3;
    private boolean hasCycle = false;
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> courseGraph = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            courseGraph.put(i, new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            courseGraph.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        
        int[] colors = new int[numCourses];
        
        for (int i = 0; i < numCourses; i++) {
            colors[i] = WHITE;
        }
        LinkedList<Integer> topologicalOrder = new LinkedList<>();
        
        for (int i = 0; i < numCourses; i++) {
            if (colors[i] == WHITE) {
                dfs(courseGraph, i, colors, topologicalOrder);
            }
        }
        if (hasCycle) return new int[0];
        int[] results = new int[numCourses];
        for (int i = 0; i < topologicalOrder.size(); i++) {
            results[i] = topologicalOrder.get(i);
        }
        return results;
    }
    
    private void dfs(HashMap<Integer, List<Integer>> graph, int course, int[] colors, LinkedList<Integer> topologicalOrder) {
        if (hasCycle) {
          return;
        }
        colors[course] = GRAY;
        for (Integer neighbor: graph.get(course)) {
            if (colors[neighbor] == WHITE) {
                dfs(graph, neighbor, colors, topologicalOrder);
            } else if (colors[neighbor] == GRAY) {
                hasCycle = true;
            }
        }
        colors[course] = BLACK;
        topologicalOrder.addFirst(course);
    }
}