/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface BinaryMatrix {
 *     public int get(int row, int col) {}
 *     public List<Integer> dimensions {}
 * };
 */

class Solution {
    // O(mlogn) time O(1) space
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> d = binaryMatrix.dimensions();
        int m = d.get(0);
        int n = d.get(1);
        int smallest = n;
        for (int row = 0; row < m; row++) {
            int l = 0;
            int r = n - 1;
            // Find first item == 1
            while (l < r) {
                int mid = l + (r - l) / 2;
                if (binaryMatrix.get(row, mid) == 1) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            if (binaryMatrix.get(row, l) == 1) {
                smallest = Math.min(smallest, l);
            }
        }
        return smallest == n ? -1 : smallest;
    }

    public int leftMostColumnWithOneOptimizedBinarySearch(BinaryMatrix binaryMatrix) {
        List<Integer> d = binaryMatrix.dimensions();
        int m = d.get(0);
        int n = d.get(1);
        int smallest = n;
        for (int row = 0; row < m; row++) {
            if (binaryMatrix.get(row, smallest - 1) == 0) 
                continue;
            int l = 0;
            int r = smallest - 1;
            // Find first item == 1
            while (l < r) {
                int mid = l + (r - l) / 2;
                if (binaryMatrix.get(row, mid) == 1) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            if (binaryMatrix.get(row, l) == 1) {
                smallest = Math.min(smallest, l);
            }
            if (smallest == 0) return smallest;
        }
        return smallest == n ? -1 : smallest;
    }

    // O(m + n) time O(1) space
    public int leftMostColumnWithOneLinear(BinaryMatrix binaryMatrix) {
        List<Integer> dimen = binaryMatrix.dimensions();
        int m = dimen.get(0), n = dimen.get(1);
        int ans = -1, r = 0, c = n - 1;
        while (r < m && c >= 0) {
            if (binaryMatrix.get(r, c) == 1) {
                ans = c; // record as current ans
                c--;
            } else {
                r++;
            }
        }
        return ans;
    }
}
