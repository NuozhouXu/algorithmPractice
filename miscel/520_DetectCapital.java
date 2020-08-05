class Solution {
    // O(n) time O(1) space
    public boolean detectCapitalUse(String word) {
        if (word.length() <= 1) return true;
        boolean isFirstCapital = Character.isUpperCase(word.charAt(0));
        boolean isSecondCapital = Character.isUpperCase(word.charAt(1));
        if (isFirstCapital && isSecondCapital) {
            for (int i = 2; i < word.length(); i++) {
                if (Character.isLowerCase(word.charAt(i))) {
                    return false;
                }
            }
        } else {
            for (int i = 1; i < word.length(); i++) {
                if (Character.isUpperCase(word.charAt(i))) {
                    return false;
                }
            }
        }
        return true;
    }
}