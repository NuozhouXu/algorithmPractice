class Solution {
    // O(n^2) time
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> (a[1] - a[0]) - (b[1] - b[0]));
        int numRemoved = 0;
        for (int i = 0; i < intervals.length; i++) {
            int[] a = intervals[i];
            for (int j = i + 1; j < intervals.length; j++) {
                int[] b = intervals[j];
                if (a[0] >= b[0] && a[1] <= b[1]) {
                    numRemoved++;
                    break;
                }
            }
        }
        return intervals.length - numRemoved;
    }

    // O(nlogn) time
    public int removeCoveredIntervalsOptimal(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int count = 0;
        int prevEnd = 0;
        for (int[] curr: intervals) {
            int currEnd = curr[1];
            if (prevEnd < currEnd) {
                count++;
                prevEnd = currEnd;
            }
        }
        return count;
    }
}