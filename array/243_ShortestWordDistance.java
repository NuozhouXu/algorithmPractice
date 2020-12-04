class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int word1Index = -1;
        int word2Index = -1;
        int minDist = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                word1Index = i;
            } else if (words[i].equals(word2)) {
                word2Index = i;
            }
            if (word1Index >= 0 && word2Index >= 0) {
                minDist = Math.min(minDist, Math.abs(word1Index - word2Index));
            }
        }
        return minDist;
    }
}