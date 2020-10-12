class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        if (roads.length == 0) return 0;
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new HashSet<>());
        }
        for (int[] road: roads) {
            graph.get(road[0]).add(road[1]);
            graph.get(road[1]).add(road[0]);
        }
        int maxRank = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int count = graph.get(i).size() + graph.get(j).size();
                if (graph.get(i).contains(j)) {
                    count--;
                }
                maxRank = Math.max(maxRank, count);
            }
        }
        return maxRank;
    }
}