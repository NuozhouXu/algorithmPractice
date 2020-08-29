class Solution {
    // O(nlogn) time O(n) space
    public int[] findRightInterval(int[][] intervals) {
        int[] output = new int[intervals.length];
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < intervals.length; i++) {
            map.put(intervals[i][0], i);
        }
        for (int i = 0; i < intervals.length; i++) {
            int end = intervals[i][1];
            Map.Entry<Integer, Integer> entry = map.ceilingEntry(end);
            output[i] = entry != null ? entry.getValue() : -1;
        }
        return output;
    }
}