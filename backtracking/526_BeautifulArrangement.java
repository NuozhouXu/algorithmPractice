class Solution {
    public int countArrangement(int n) {
        int[] count = new int[1];
        boolean[] used = new boolean[n + 1];
        countArrangementHelper(1, count, used, n);
        return count[0];
    }
    
    private void countArrangementHelper(int index, int[] count, boolean[] used, int n) {
        if (index == n + 1) {
            count[0]++;
            return;
        }
        for (int i = 1; i <= n; i++) {
            if ((i % index == 0 || index % i == 0) && !used[i]) {
                used[i] = true;
                countArrangementHelper(index + 1, count, used, n);
                used[i] = false;
            }
        }
    }
}