class Solution {
    // O(N^4) time
    public int largestOverlap(int[][] A, int[][] B) {
        int m = A.length;
        int n = A[0].length;
        
        List<int[]> pixelA = new ArrayList<>();
        List<int[]> pixelB = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (A[i][j] == 1) pixelA.add(new int[]{i, j});
                if (B[i][j] == 1) pixelB.add(new int[]{i, j});
            }
        }
        
        Map<String, Integer> map = new HashMap<>();
        for (int[] a: pixelA) {
            for (int[] b: pixelB) {
                String v = (a[0] - b[0]) + " " + (a[1] - b[1]);
                map.put(v, map.getOrDefault(v, 0) + 1);
            }
        }
        int max = 0;
        for (int count: map.values()) {
            max = Math.max(max, count);
        }
        return max;
    }
}