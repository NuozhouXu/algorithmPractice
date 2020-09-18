class Solution {
    // O(nlogn) time
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        for (int i = 0; i < intervals.length; i++) {
            if (pq.isEmpty()) {
                pq.offer(intervals[i]);
            } else {
                if (pq.peek()[1] <= intervals[i][0]) pq.poll();
                pq.offer(intervals[i]);
            }
        }
        return pq.size();
    }
}