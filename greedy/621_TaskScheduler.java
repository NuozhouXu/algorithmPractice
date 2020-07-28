class Solution {
    // O(nlogn) time
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> counts = new HashMap<Character, Integer>();
        for (char t : tasks) {
            counts.put(t, counts.getOrDefault(t, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> b - a);
        pq.addAll(counts.values());
        
        int totalTime = 0;
        while (!pq.isEmpty()) {
            int k = n + 1;
            List<Integer> tempList = new ArrayList<>();
            while (k > 0 && !pq.isEmpty()) {
                tempList.add(pq.poll());
                k--;
                totalTime++;
            }
            for (int count: tempList) {
                if (count - 1 > 0) {
                    pq.offer(count - 1);
                }
            }
            if (pq.isEmpty()) break;
            totalTime += k;
        }
        return totalTime;
    }

    // O(n) time
    public int leastIntervalMath(char[] tasks, int n) {
        int[] f = new int[26];
        for (int t : tasks) {
            f[t - 'A']++;
        }
        Arrays.sort(f);
        int i = 25;
        while(i >= 0 && f[i] == f[25]) i--;
        return Math.max(tasks.length, (f[25] - 1) * (n + 1) + 25 - i);
    }
}