class Solution {
    public int findKthPositive(int[] arr, int k) {
        int l = 0, r = arr.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            // find first index where numMissing >= k; 
            if (arr[mid] - mid - 1 >= k) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l + k;
    }
}