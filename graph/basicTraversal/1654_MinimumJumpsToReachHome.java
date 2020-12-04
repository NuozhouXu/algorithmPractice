class Solution {
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        boolean[][] visited = new boolean[10000][2];
        for (int i : forbidden) visited[i][0] = visited[i][1] = true;
        int level = 0;
        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0});
        visited[0][0] = true;
        while (!queue.isEmpty()) {
            for (int i = queue.size(); i > 0; i--) {
                int[] node = queue.poll();
                if (node[0] == x) return level;
                if (node[0] - b >= 0 && !visited[node[0] - b][1] && node[1] == 0) {
                    queue.offer(new int[]{node[0] - b, 1});
                    visited[node[0] - b][1] = true;
                }
                if (!visited[node[0] + a][0] && node[0] + a <= 4000) {
                    queue.offer(new int[]{node[0] + a, 0});
                    visited[node[0] + a][0] = true;
                }
            }
            level++;
        }
        return -1;
    }
}