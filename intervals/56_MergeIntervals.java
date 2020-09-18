class Solution {
    // O(nlogn)
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        LinkedList<int[]> results = new LinkedList<>(); // this is a stack
        for (int i = 0; i < intervals.length; i++) {
            if (results.isEmpty() || results.getLast()[1] < intervals[i][0]) {
                results.add(intervals[i]);
            } else {
                results.getLast()[1] = Math.max(results.getLast()[1], intervals[i][1]);
            }
        }
        return results.toArray(new int[results.size()][2]);
    }
}