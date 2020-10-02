class Solution {
    public int minJumps(int[] arr) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.putIfAbsent(arr[i], new ArrayList<>());
            map.get(arr[i]).add(i);
        }
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(0);
        int dist = 0;
        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int index = 0; index < size; index++) {
                int i = queue.poll();
                if (i == arr.length - 1) return dist;
                if (i + 1 < arr.length && !visited.contains(i + 1)) {
                    queue.offer(i + 1);
                    visited.add(i + 1);
                }
                if (i - 1 >= 0 && !visited.contains(i - 1)) {
                    queue.offer(i - 1);
                    visited.add(i - 1);
                }
                for (int j: map.get(arr[i])) {
                    if (i != j && !visited.contains(j)) {
                        queue.offer(j);
                        visited.add(j);
                    }
                }
                map.get(arr[i]).clear();
            }
            dist++;
        }
        return -1;
    }
}