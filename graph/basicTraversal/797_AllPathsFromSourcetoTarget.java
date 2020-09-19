class Solution {
    // O(2^N * N) time O(N) space
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        tempList.add(0);
        dfs(results, graph, tempList, 0);
        return results;
    }
    
    private void dfs(List<List<Integer>> results, int[][] graph, List<Integer> tempList, int node) {
        for (int neighbor: graph[node]) {
            tempList.add(neighbor);
            if (neighbor == graph.length - 1) {
                results.add(new ArrayList<>(tempList));
            } else {
                dfs(results, graph, tempList, neighbor);
            }
            tempList.remove(tempList.size() - 1);
        }
    }

    private void dfs2(List<List<Integer>> results, int[][] graph, List<Integer> tempList, int node) {
        if (node == graph.length - 1) {
            results.add(new ArrayList<>(tempList));
            return;
        }
        for (int neighbor: graph[node]) {
            tempList.add(neighbor);
            dfs(results, graph, tempList, neighbor);
            tempList.remove(tempList.size() - 1);
        }
    }
}