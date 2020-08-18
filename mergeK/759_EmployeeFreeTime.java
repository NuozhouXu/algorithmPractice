/*
// Definition for an Interval.
class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
};
*/

class Solution {
    // O(NlogK) N is the number of intervals in schedule. K is the number of employee
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> schedule.get(a[0]).get(a[1]).start - schedule.get(b[0]).get(b[1]).start);
        List<Interval> results = new ArrayList<>();
        for (int i = 0; i < schedule.size(); i++) {
            pq.offer(new int[]{i, 0});
        }
        int prevEnd = schedule.get(pq.peek()[0]).get(pq.peek()[1]).end;
        while (!pq.isEmpty()) {
            int[] index = pq.poll();
            Interval interval = schedule.get(index[0]).get(index[1]);
            if (interval.start > prevEnd) {
                results.add(new Interval(prevEnd, interval.start));
            }
            prevEnd = Math.max(prevEnd, interval.end);
            if (index[1] < schedule.get(index[0]).size() - 1) {
                pq.offer(new int[]{index[0], index[1] + 1});
            }
        }
        return results;
    }
}