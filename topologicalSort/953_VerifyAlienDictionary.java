class Solution {
    // O(C) time where c is the number of chars in all words
    // O(1) space
    public boolean isAlienSorted(String[] words, String order) {
        if (words.length < 2) return true;
        int[] indexes = new int[26];
        for (int i = 0; i < order.length(); i++) {
            indexes[order.charAt(i) - 'a'] = i;
        }
        for (int i = 1; i < words.length; i++) {
            String firstWord = words[i - 1];
            String secondWord = words[i];
            int j = 0;
            while (j < Math.min(firstWord.length(), secondWord.length())) {
                char firstChar = firstWord.charAt(j);
                char secondChar = secondWord.charAt(j);
                if (firstChar != secondChar) {
                    if (indexes[firstChar - 'a'] > indexes[secondChar - 'a']) {
                        return false;
                    }
                    break;
                }
                j++;
            }
            if (j == Math.min(firstWord.length(), secondWord.length()) && firstWord.length() > secondWord.length()) return false;
        }
        return true;
    }
}