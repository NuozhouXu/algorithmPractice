class Solution {
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((p1, p2) -> p2[0] * p2[0] + p2[1] * p2[1] - p1[0] * p1[0] - p1[1] * p1[1]);
        for (int[] p : points) {
            pq.offer(p);
            if (pq.size() > K) {
                pq.poll();
            }
        }
        int[][] res = new int[K][2];
        while (K > 0) {
            res[--K] = pq.poll();
        }
        return res;
    }

    public int[][] kClosestOptimal(int[][] points, int K) {
        return kClosestHelper(points, 0, points.length - 1, K);
    }
    
    private int[][] kClosestHelper(int[][] points, int l, int r, int K) {
        int pivotIndex = partition(points, l, r);
        if (pivotIndex == K - 1) {
            return Arrays.copyOfRange(points, 0, K);
        } else if (pivotIndex < K) {
            return kClosestHelper(points, pivotIndex + 1, r, K);
        } else {
            return kClosestHelper(points, l, pivotIndex - 1, K);
        }
    }
    
    private int partition(int[][] points, int l, int r) {
        int[] pivotValue = points[r];
        int i = l - 1;
        for (int j = l; j < r; j++) {
            if (compare(points[j], pivotValue) <= 0) {
                i++;
                exchange(points, i, j);
            }
        }
        exchange(points, i + 1, r);
        return i + 1;
    }
    
    private void exchange(int[][] points, int i, int j) {
        int[] temp = points[j];
        points[j] = points[i];
        points[i] = temp;
    }
    
    private int compare(int[] p1, int[] p2) {
        return p1[0] * p1[0] + p1[1] * p1[1] - p2[0] * p2[0] - p2[1] * p2[1];
    }
}