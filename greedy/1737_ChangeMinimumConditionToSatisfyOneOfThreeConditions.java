class Solution {
    public int minCharacters(String a, String b) {
        int m = a.length(), n = b.length(), res = m + n;
        int[] c1 = new int[26], c2 = new int[26];
        for (int i = 0; i < m; i++)
            c1[a.charAt(i) - 'a']++;
        for (int i = 0; i < n; i++)
            c2[b.charAt(i) - 'a']++;

        for (int i = 0; i < 26; i++) {
            res = Math.min(res, m + n - c1[i] - c2[i]); // condition 3
            if (i > 0) {
                c1[i] += c1[i - 1];
                c2[i] += c2[i - 1];
            }
            if (i < 25) {
                res = Math.min(res, m - c1[i] + c2[i]); // condition 1
                res = Math.min(res, n - c2[i] + c1[i]); // condition 2
            }
        }
        return res;
    }
}