/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class Solution {
    // O(logN)
    public int search(ArrayReader reader, int target) {
        int hi = 1;
        while (reader.get(hi) < target) {
            hi *= 2;
        }
        int low = hi / 2;
        while (low <= hi) {
            int mid = low + (hi - low) / 2;
            if (reader.get(mid) > target) {
                hi = mid - 1;
            } else if (reader.get(mid) < target) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}