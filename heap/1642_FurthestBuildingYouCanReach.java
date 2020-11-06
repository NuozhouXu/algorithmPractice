class Solution {
    // O(NlogK) time
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        if (heights.length == 1) return 0;
        int n = heights.length;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 1; i < heights.length; i++) {
            int cost = Math.max(0, heights[i] - heights[i - 1]);
            minHeap.offer(cost);
            if (minHeap.size() > ladders) {
                bricks -= minHeap.poll();
                if (bricks < 0) return i - 1;
            }
        }
        return n - 1;
    }
}