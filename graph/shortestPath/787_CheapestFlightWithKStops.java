class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
       Map<Integer, List<int[]>> map = new HashMap<>();
       for(int[] f: flights) {
           map.putIfAbsent(f[0],new ArrayList<>());
           map.get(f[0]).add(new int[]{f[1],f[2]});
       }
       PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
       pq.offer(new int[]{0, src, K + 1});
       while (!pq.isEmpty()) {
           int[] c = pq.poll();
           int cost = c[0], curr = c[1], stop = c[2];
           if (curr == dst) return cost;
           if (stop > 0) {
               if (!map.containsKey(curr)) continue;
               for (int[] next: map.get(curr)) {
                   pq.offer(new int[]{cost + next[1], next[0], stop - 1});
               }
           }
       }
       return -1;
   }
}