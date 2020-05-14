class Solution {
    // O(n^2) time O(1) space.
    public List<Integer> pancakeSort(int[] A) {
        int k = A.length;
        List<Integer> results = new ArrayList<>();
        while (k > 0) {
            int largestIndex = findLargest(A, k);
            flip(A, largestIndex + 1);
            flip(A, k);
            results.add(largestIndex + 1);
            results.add(k);
            k--;
        }
        return results;
    }
    
    private int findLargest(int[] A, int k) {
        int index = 0;
        for (int i = 1; i < k; i++) {
            if (A[i] > A[index]) {
                index = i;
            }
        }
        return index;
    }
    
    private void flip(int[] A, int k) {
        int l = 0;
        int r = k - 1;
        while (l < r) {
            int temp = A[l];
            A[l] = A[r];
            A[r] = temp;
            l++;
            r--;
        }
    }
}