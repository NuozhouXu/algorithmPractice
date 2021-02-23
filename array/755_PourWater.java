class Solution {
    // O(VN) time
    public int[] pourWater(int[] heights, int V, int K) {
        for (int i = 0; i < V; i++) {
            int cur = K;
            while(cur > 0 && heights[cur] >= heights[cur - 1]) {
                cur--;
            }
            while(cur < heights.length - 1 && heights[cur] >= heights[cur + 1]) {
                cur++;
            }
            while(cur > K && heights[cur] == heights[cur - 1]) {
                cur--;
            }
            heights[cur]++;
        }
        return heights;
    }

    // O((V + N)logN) time
    public int[] pourWaterPQ(int[] heights, int V, int K) {
        PriorityQueue<Integer> pq1 = new PriorityQueue<>((a, b) -> heights[a] == heights[b] ? b - a : heights[a] - heights[b]);
        PriorityQueue<Integer> pq2 = new PriorityQueue<>((a, b) -> heights[a] == heights[b] ? a - b : heights[a] - heights[b]);
        
        int l = K - 1;
        int r = K + 1;
        for (int i = 0; i < V; i++) {
            while (l >= 0 && heights[l] <= heights[l + 1]) {
                pq1.offer(l--);
            }
            while (r < heights.length && heights[r] <= heights[r - 1]) {
                pq2.offer(r++);
            }
            if (!pq1.isEmpty() && heights[pq1.peek()] < heights[K]) {
                heights[pq1.peek()]++;
                pq1.offer(pq1.poll());
            } else if (!pq2.isEmpty() && heights[pq2.peek()] < heights[K]) {
                heights[pq2.peek()]++;
                pq2.offer(pq2.poll());
            } else {
                heights[K]++;
            }
        }
        return heights;
    }
}