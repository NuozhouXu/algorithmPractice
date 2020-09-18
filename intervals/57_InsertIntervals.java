class Solution {
    // O(N) time where N is the number of intervals
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> results = new ArrayList<>();
        int i = 0;
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            results.add(intervals[i++]);
        }
        
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        
        results.add(newInterval);
        
        while (i < intervals.length) {
            results.add(intervals[i++]);
        }
        return results.toArray(new int[results.size()][2]);
    }
}