class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        
        PriorityQueue<int[]> allocator = new PriorityQueue<>(intervals.length, (a, b) -> a[1] - b[1]);
        
        allocator.offer(intervals[0]);
        
        for (int i = 1; i < intervals.length; i++) {
            // If the earliest ending meeting in the queue is less than the start time of the new meeting
            if (allocator.peek()[1] <= intervals[i][0]) allocator.poll();
            allocator.add(intervals[i]);
        }
        return allocator.size();
    }
}