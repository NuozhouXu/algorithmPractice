class Solution {
    // O(N) time O(1) space
    public List<Integer> partitionLabels(String S) {
        int[] last = new int[26];
        for (int i = 0; i < S.length(); i++) {
            last[S.charAt(i) - 'a'] = i;
        }
        List<Integer> results = new ArrayList<>();
        int start = 0;
        int end = 0;
        for (int i = 0; i < S.length(); i++) {
            end = Math.max(end, last[S.charAt(i) - 'a']);
            if (end == i) {
                results.add(end - start + 1);
                start = end + 1;
            }
        }
        return results;
    }
}