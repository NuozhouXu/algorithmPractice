class Solution {
    public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
        List<List<Integer>> results = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][1] <= toBeRemoved[0] || intervals[i][0] >= toBeRemoved[1]) {
                results.add(Arrays.asList(intervals[i][0], intervals[i][1]));
            } else {
                if (intervals[i][0] < toBeRemoved[0]) {
                    results.add(Arrays.asList(intervals[i][0], toBeRemoved[0]));
                }
                if (intervals[i][1] > toBeRemoved[1]) {
                    results.add(Arrays.asList(toBeRemoved[1], intervals[i][1]));
                }
            }
        }
        return results;
    }
}