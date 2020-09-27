class Solution {
    // O(2^15 * 15)
    public int maxUniqueSplit(String s) {
        Set<String> uniqueSet = new HashSet<>();
        return maxUniqueSplitHelper(uniqueSet, s);
    }
    
    private int maxUniqueSplitHelper(Set<String> uniqueSet, String curr) {
        if (curr.length() == 0) return 0;
        int max = 0;
        for (int i = 1; i <= curr.length(); i++) {
            String str = curr.substring(0, i);
            if (!uniqueSet.contains(str)) {
                uniqueSet.add(str);
                String next = curr.substring(i);
                max = Math.max(max, maxUniqueSplitHelper(uniqueSet, next) + 1);
                uniqueSet.remove(str);
            }
        }
        return max;
    }
}