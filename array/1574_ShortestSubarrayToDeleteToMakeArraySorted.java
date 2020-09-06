class Solution {
    // O(N) time
    public int findLengthOfShortestSubarray(int[] arr) {
        int l = 0;
        while (l < arr.length - 1 && arr[l] <= arr[l + 1]) {
            l++;
        }
        // when the arr is sorted, we don't need to delete anything
        if(l == arr.length - 1) return 0;
        
        int r = arr.length - 1;
        while (r > l && arr[r] >= arr[r - 1]) {
            r--;
        }
        // Similar to merge process for merge sort
        int i = 0;
        int j = r;
        int minLen = Math.min(arr.length - l - 1, r);
        while (i <= l && j < arr.length) {
            if (arr[i] <= arr[j]) {
                minLen = Math.min(minLen, j - i - 1);
                i++;
            } else {
                j++;
            }
        }
        return minLen;
    }
}