class Solution {
    // Kahn's algorithm
    public String alienOrder(String[] words) {
        Map<Character, List<Character>> graph = new HashMap<>();
        Map<Character, Integer> indegrees = new HashMap<>();
        
        // Create the nodes
        for (String word: words) {
            for (char c: word.toCharArray()) {
                indegrees.put(c, 0);
                graph.put(c, new ArrayList<>());
            }
        }
        
        // Create the edges
        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];
            if (word1.length() > word2.length() && word1.startsWith(word2)) {
                return "";
            }
            for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
                if (word1.charAt(j) != word2.charAt(j)) {
                    graph.get(word1.charAt(j)).add(word2.charAt(j));
                    indegrees.put(word2.charAt(j), indegrees.get(word2.charAt(j)) + 1);
                    break;
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        Deque<Character> queue = new ArrayDeque<>();
        for (Character c: indegrees.keySet()) {
            if (indegrees.get(c) == 0) {
                queue.offer(c);
            }
        }
        while (!queue.isEmpty()) {
            char c = queue.poll();
            sb.append(c);
            for (Character neighbor: graph.get(c)) {
                indegrees.put(neighbor, indegrees.get(neighbor) - 1);
                if (indegrees.get(neighbor) == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        if (sb.length() < indegrees.size()) {
            return "";
        }
        return sb.toString();
    }

    private static int WHITE = 1;
    private static int GRAY = 2;
    private static int BLACK = 3;
    
    public String alienOrderDFS(String[] words) {
        Map<Character, List<Character>> graph = new HashMap<>();
        Map<Character, Integer> colors = new HashMap<>();
        
        // Create the nodes
        for (String word: words) {
            for (char c: word.toCharArray()) {
                graph.putIfAbsent(c, new ArrayList<>());
                colors.putIfAbsent(c, WHITE);
            }
        }
        
        // Create the edges
        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];
            if (word1.length() > word2.length() && word1.startsWith(word2)) {
                return "";
            }
            for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
                if (word1.charAt(j) != word2.charAt(j)) {
                    graph.get(word2.charAt(j)).add(word1.charAt(j));
                    break;
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (Character c: graph.keySet()) {
            if (colors.get(c) == WHITE) {
                if (dfs(graph, colors, sb, c)) {
                    return "";
                }
            }
        }
        
        return sb.toString();
    }
    
    private boolean dfs(Map<Character, List<Character>> graph, Map<Character, Integer> colors, StringBuilder sb, Character c) {
        colors.put(c, GRAY);
        for (Character neighbor: graph.get(c)) {
            if (colors.get(neighbor) == WHITE) {
                if (dfs(graph, colors, sb, neighbor)) {
                    return true;
                }
            } else if (colors.get(neighbor) == GRAY) {
                return true;
            }
        }
        colors.put(c, BLACK);
        sb.append(c);
        return false;
    }  
}