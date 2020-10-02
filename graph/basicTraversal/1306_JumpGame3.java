class Solution {
    public boolean canReach(int[] arr, int start) {
        Deque<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[arr.length];
        queue.offer(start);
        visited[start] = true;
        while (!queue.isEmpty()) {
            int index = queue.poll();
            if (arr[index] == 0) {
                return true;
            }
            if (index - arr[index] >= 0 && !visited[index - arr[index]]) {
                queue.offer(index - arr[index]);
                visited[index - arr[index]] = true;
            }
            if (index + arr[index] < arr.length) {
                queue.offer(index + arr[index]);
                visited[index + arr[index]] = true;
            }
        }
        return false;
    }
}