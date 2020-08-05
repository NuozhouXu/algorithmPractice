class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, LinkedList<String>> graph = new HashMap<>();
        for (List<String> ticket: tickets) {
            String origin = ticket.get(0);
            String dest = ticket.get(1);
            if (graph.containsKey(origin)) {
                graph.get(origin).add(dest);
            } else {
                LinkedList<String> destList = new LinkedList<>();
                destList.add(dest);
                graph.put(origin, destList);
            }
        }
        for (String key: graph.keySet()) {
            Collections.sort(graph.get(key));
        }
        
        LinkedList<String> results = new LinkedList<>();
        dfs("JFK", results, graph);
        return results;
        
    }
    
    private void dfs(String origin, LinkedList<String> results, Map<String, LinkedList<String>> graph) {
        if (graph.containsKey(origin)) {
            LinkedList<String> destList = graph.get(origin);
            while (!destList.isEmpty()) {
                String dest = destList.removeFirst();
                dfs(dest, results, graph);
            }
        }
        results.addFirst(origin);
    }
}