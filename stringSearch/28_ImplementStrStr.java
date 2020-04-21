class Solution {
    // O(n^2), O(n) solution with KMP
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            for (int j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i + j) == needle.charAt(j)) {
                    if (j == needle.length() - 1) return i;
                } else {
                    break;
                }
            }
        }
        return -1;
    }
}