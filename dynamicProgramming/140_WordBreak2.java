class Solution {
    /*
    Suppose f(n) represents the total # of outputs, then since every substring is valid:

    f(n) = f(n - 1) + f(n -2) + ... + f(1)
    O(2^N)
    */
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        Map<String, List<String>> memo = new HashMap<>();
        return dfs(s, wordSet, memo);
    }
    
    private List<String> dfs(String s, Set<String> wordSet, Map<String, List<String>> map) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() == 0) return res;
        if (map.containsKey(s)) return map.get(s);
        if (wordSet.contains(s)) res.add(s);
        for (int i = 1 ; i <= s.length() ; i++) {
            String t = s.substring(0, i);
            if (wordSet.contains(t)) {
                List<String> temp = dfs(s.substring(i), wordSet, map);
                if (temp.size() != 0) {
                    for (int j = 0 ; j < temp.size() ; j++) {
                        res.add(t + " " + temp.get(j));
                    }
                }
            }
        }
        map.put(s , res);
        return res;
    }
}