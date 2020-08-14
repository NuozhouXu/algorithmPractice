class Solution {
    
    private int[] prefixSum;
    private int total;

    // O(N)
    public Solution(int[] w) {
        this.prefixSum = new int[w.length];
        int sum = 0;
        for (int i = 0; i < w.length; i++) {
            sum += w[i];
            this.prefixSum[i] = sum;
        }
        this.total = sum;
    }
    
    // O(N)
    public int pickIndex() {
        double target = total * Math.random();
        for (int i = 0; i < prefixSum.length; i++) {
            if (prefixSum[i] > target) return i;
        }
        return -1;
    }

    // O(logN)
    public int pickIndexBinarySearch() {
        double target = total * Math.random();
        int l = 0;
        int r = prefixSum.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (target < prefixSum[mid]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}