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

    public int strStrRollingHash(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        if (haystack.length() < needle.length()) return -1;
        int n = haystack.length();
        int m = needle.length();
        long base = 26;
        long h = 1;
        long mod = 2147483647;
        long patternHash = 0;
        long rollingHash = 0;
        
        for (int i = 0; i < m - 1; i++) {
            h = (h * base) % mod;
        }
        
        for (int i = 0; i < m; i++) {
            patternHash = (patternHash * base + needle.charAt(i) - 'a' + 1) % mod;
            rollingHash = (rollingHash * base + haystack.charAt(i) - 'a' + 1) % mod;
        }
        for (int i = 0; i <= n - m; i++) {
            if (patternHash == rollingHash) {
                if (isMatch(haystack, needle, i)) {
                    return i;
                }
            }
            System.out.println(rollingHash);
            if (i < n - m) {
                rollingHash = (base * (rollingHash - (haystack.charAt(i) - 'a' + 1) * h) + (haystack.charAt(i + m) - 'a' + 1)) % mod;
            }
        }
        
        return -1;
    }
    
    private boolean isMatch(String text, String pattern, int index) {
        for (int i = 0; i < pattern.length(); i++) {
            if (text.charAt(i + index) != pattern.charAt(i)) return false;
        }
        return true;
    }
}