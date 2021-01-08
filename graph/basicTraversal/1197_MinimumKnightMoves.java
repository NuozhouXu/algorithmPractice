class Solution {
    public int minKnightMoves(int x, int y) {
        x = Math.abs(x);
        y = Math.abs(y);
        Set<String> visited = new HashSet<>();
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0});
        visited.add("0,0");
        int numMoves = 0;
        int[][] dirs = new int[][]{{2, 1}, {1, 2}, {2, -1}, {1, -2}, {-2, -1}, {-1, -2}, {-1, 2}, {-2, 1}};
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] node = queue.poll();
                if (node[0] == x && node[1] == y) {
                    return numMoves;
                }
                for (int[] dir: dirs) {
                    int newX = node[0] + dir[0];
                    int newY = node[1] + dir[1];
                    if (newX >= -1 && newY >= -1 && !visited.contains(newX + "," + newY)) {
                        queue.offer(new int[]{newX, newY});
                        visited.add(newX + "," + newY);
                    }
                }
            }
            numMoves++;
        }
        return -1;
    }
}