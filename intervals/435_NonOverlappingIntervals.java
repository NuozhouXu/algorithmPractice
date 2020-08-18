class Solution {
    // O(nlogn) time O(1) space
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int currEnd = intervals[0][1];
        int countErase = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= currEnd) {
                currEnd = intervals[i][1];
            } else {
                countErase++;
            }
        }
        return countErase;
    }
}