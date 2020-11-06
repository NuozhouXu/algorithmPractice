class Solution {
    // O(n^3)
    public int countSubstrings(String s, String t) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < t.length(); j++) {
                int count = 0;
                int p1 = i, p2 = j;
                while (count <= 1 && p1 < s.length() && p2 < t.length()) {
                    if (s.charAt(p1++) != t.charAt(p2++)) {
                        count++;
                    }
                    
                    if (count == 1) ans++;
                }
            }
        }
        return ans;
    }
}