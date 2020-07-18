class Solution {
    // O(N) time O(N) space
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> seen = new HashSet<>();
        Set<String> repeated = new HashSet<>();
        for (int i = 0; i <= s.length() - 10; i++) {
            String seq = s.substring(i, i + 10);
            if (seen.contains(seq)) {
                repeated.add(seq);
            } else {
                seen.add(seq);
            }
        }
        return new ArrayList<>(repeated);
    }
}