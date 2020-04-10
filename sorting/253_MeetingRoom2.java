class Solution {
    public int minMeetingRooms(int[][] intervals) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        for (int i = 0; i < intervals.length; i++) {
            Integer earliestEndTime = minHeap.peek();
            if (earliestEndTime == null) {
                minHeap.offer(intervals[i][1]);
            } else {
                if (intervals[i][0] >= earliestEndTime) {
                    minHeap.poll();
                }
                minHeap.offer(intervals[i][1]);
            }
        }
        return minHeap.size();
    }
}