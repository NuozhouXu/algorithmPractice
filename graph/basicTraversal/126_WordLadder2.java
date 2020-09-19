class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> results = new ArrayList<>();
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return results;
        Set<String> visited = new HashSet<>();
        Deque<String> queue = new ArrayDeque<>();
        Map<String, List<String>> parent = new HashMap<>();
        for (String word: wordSet) {
            parent.put(word, new ArrayList<>());
        }
        parent.put(beginWord, new ArrayList<>());
        Map<String, Integer> dist = new HashMap<>();
        int level = 0;
        int shortestLen = Integer.MAX_VALUE;
        dist.put(beginWord, 0);
        queue.offer(beginWord);
        visited.add(beginWord);
        while (!queue.isEmpty() && level < shortestLen) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                for (int j = 0; j < word.length(); j++) {
                    char[] chars = word.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (chars[j] == c) continue;
                        char temp = chars[j];
                        chars[j] = c;
                        String newWord = new String(chars);
                        if (newWord.equals(endWord)) {
                            shortestLen = level + 1;
                            parent.get(endWord).add(word);
                        } else {
                            if (wordSet.contains(newWord)) {
                                if (dist.get(newWord) == null) {
                                    dist.put(newWord, level + 1);
                                }
                                if (dist.get(newWord) == level + 1) {
                                    parent.get(newWord).add(word);
                                }
                                if (!visited.contains(newWord)) {
                                    visited.add(newWord);
                                    queue.offer(newWord);
                                }
                            }
                        }
                        chars[j] = temp;
                    }
                }
            }
            level++;
        }
        dfs(results, parent, new LinkedList<>(Arrays.asList(endWord)), endWord, beginWord);
        
        return results;
    }
    
    private void dfs(List<List<String>> results, Map<String, List<String>> parent, LinkedList<String> path, String word, String beginWord) {
        if (word.equals(beginWord)) {
            results.add(new ArrayList<>(path));
        } else {
            for (String prevWord: parent.get(word)) {
                path.addFirst(prevWord);
                dfs(results, parent, path, prevWord, beginWord);
                path.removeFirst();
            }
        }
    }
}