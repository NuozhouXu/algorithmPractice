class Solution {
    // O(mn) time
    public int numSpecial(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        boolean[] rows = new boolean[m];
        boolean[] cols = new boolean[n];
        for (int i = 0; i < m; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    count++;
                }
            }
            if (count == 1) {
                rows[i] = true;
            }
        }
        
        for (int j = 0; j < n; j++) {
            int count = 0;
            for (int i = 0; i < m; i++) {
                if (mat[i][j] == 1) {
                    count++;
                }
            }
            if (count == 1) {
                cols[j] = true;
            }
        }
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1 && rows[i] && cols[j]) {
                    res++;
                }
            }
        }
        return res;
    }
}