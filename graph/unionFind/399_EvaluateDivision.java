class Solution {

    // O(MN) time where M is the number of queries, and N is the number of input equations. O(N) space
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            List<String> pair = equations.get(i);
            String a = pair.get(0);
            String b = pair.get(1);
            graph.putIfAbsent(a, new HashMap<>());
            graph.putIfAbsent(b, new HashMap<>());
            graph.get(a).put(b, values[i]);
            graph.get(b).put(a, 1 / values[i]);
        }
        
        double[] results = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            String dividend = query.get(0), divisor = query.get(1);

            if (!graph.containsKey(dividend) || !graph.containsKey(divisor))
                results[i] = -1.0;
            else if (dividend == divisor)
                results[i] = 1.0;
            else {
                Set<String> visited = new HashSet<>();
                results[i] = dfs(graph, dividend, divisor, 1, visited);
            }
        }
        return results;
    }
    
    private double dfs(Map<String, Map<String, Double>> graph, String currNode, String targetNode, double currProduct, Set<String> visited) {
        visited.add(currNode);
        double ret = -1.0;
        if (currNode.equals(targetNode)) {
            return currProduct;
        }
        Map<String, Double> neighbors = graph.get(currNode);
        for (String neighbor: neighbors.keySet()) {
            if (!visited.contains(neighbor)) {
                ret = dfs(graph, neighbor, targetNode, currProduct * neighbors.get(neighbor), visited);
                if (ret != -1.0) break;
            }
        }
        visited.remove(currNode);
        return ret;
    }
}