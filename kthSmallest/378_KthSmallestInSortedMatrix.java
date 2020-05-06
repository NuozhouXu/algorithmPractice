class Solution {
    public int kthSmallestBruteForce(int[][] matrix, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> b - a);
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                heap.offer(matrix[row][col]);
                if (heap.size() == k + 1) {
                    heap.poll();
                }
            }
        }
        return heap.poll();
    }

    // O(klog(min(n, k))) time O(min(n, k)) space for the heap.
    public int kthSmallestHeap(int[][] matrix, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int n = matrix.length;
        int m = matrix[0].length;
        for (int i = 0; i < Math.min(n, k); i++) {
            heap.offer(new int[]{matrix[i][0], i, 0});
        }
        for (int i = 0; i < k - 1; i++) {
            int[] node = heap.poll();
            int r = node[1], c = node[2];
            if (c < m - 1) {
                heap.offer(new int[]{matrix[r][c + 1], r, c + 1});
            }
        }
        
        return heap.peek()[0];
    }

    public int kthSmallestBinarySearch(int[][] matrix, int k) {
        int n = matrix.length;
        int start = matrix[0][0];
        int end = matrix[n - 1][n - 1];
        while (start < end) {
            int mid = start + (end - start) / 2;
            int[] pair = {matrix[0][0], matrix[n - 1][n - 1]};
            int count = countLessThan(matrix, mid, pair);
            
            if (count == k) {
                return pair[0];
            } else if (count < k) {
                start = pair[1];
            } else {
                end = pair[0];
            }
        }
        return start;
    }
    
    private int countLessThan(int[][] matrix, int mid, int[] smallLargePair) {
        int count = 0;
        int n = matrix.length, row = n - 1, col = 0;
        while (row >= 0 && col < n) {
          if (matrix[row][col] > mid) {
            // as matrix[row][col] is bigger than the mid, let's keep track of the
            // smallest number greater than the mid
            smallLargePair[1] = Math.min(smallLargePair[1], matrix[row][col]);
            row--;
          } else {
            // as matrix[row][col] is less than or equal to the mid, let's keep track of the
            // biggest number less than or equal to the mid
            smallLargePair[0] = Math.max(smallLargePair[0], matrix[row][col]);
            count += row + 1;
            col++;
          }
        }
        return count;
    }
}