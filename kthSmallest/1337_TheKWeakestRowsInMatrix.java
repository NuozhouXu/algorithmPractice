class Solution {
    // O(mlogm + mlogn = mlogmn) time O(k) space
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[1] == b[1]) {
                return b[0] - a[0];
            } else {
                return b[1] - a[1];
            }
        });
        int m = mat.length;
        int n = mat[0].length;
        for (int row = 0; row < m; row++) {
            int count = count1s(mat[row]);
            pq.offer(new int[]{row, count});
            if (pq.size() > k) {
                pq.poll();
            }
        }
        int[] results = new int[pq.size()];
        int index = pq.size() - 1;
        while (!pq.isEmpty()) {
            results[index--] = pq.poll()[0];
        }
        return results;
    }
    
    private int count1s(int[] row) {
        int l = 0;
        int r = row.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (row[mid] == 1) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}