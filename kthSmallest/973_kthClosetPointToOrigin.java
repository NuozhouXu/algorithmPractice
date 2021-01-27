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
        return quickSelect(points, 0, points.length - 1, K);
    }
    
    private int[][] quickSelect(int[][] points, int l, int r, int K) {
        int partitionIndex = randomizedPartition(points, l, r);
        if (partitionIndex == K - 1) {
            return Arrays.copyOfRange(points, 0, K);
        } else if (partitionIndex < K - 1) {
            return quickSelect(points, partitionIndex + 1, r, K);
        } else {
            return quickSelect(points, l, partitionIndex - 1, K);
        }
    }
    
    private int randomizedPartition(int[][] points, int l, int r) {
        Random rand = new Random();
        int pivotIndex = l + rand.nextInt(r - l + 1);
        swap(points, pivotIndex, r);
        return partition(points, l, r);
    }
    
    private int partition(int[][] points, int l, int r) {
        int[] pivot = points[r];
        int i = l - 1;
        for (int j = l; j < r; j++) {
            if (compareTo(points[j], pivot) <= 0) {
                i++;
                swap(points, i, j);
            }
        }
        swap(points, i + 1, r);
        return i + 1;
    }
    
    private int compareTo(int[] point1, int[] point2) {
        int val1 = point1[0] * point1[0] + point1[1] * point1[1];
        int val2 = point2[0] * point2[0] + point2[1] * point2[1];
        return val1 - val2;
    }
    
    private void swap(int[][] points, int i, int j) {
        int[] temp = points[i];
        points[i] = points[j];
        points[j] = temp;
    }
}