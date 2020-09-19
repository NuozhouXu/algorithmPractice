class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        if (oldColor == newColor) return image;
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{sr, sc});
        image[sr][sc] = newColor;
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            for (int[] dir: dirs) {
                int newRow = pos[0] + dir[0];
                int newCol = pos[1] + dir[1];
                if (newRow >= 0 && newRow < image.length &&
                    newCol >= 0 && newCol < image[0].length &&
                    image[newRow][newCol] == oldColor) {
                    image[newRow][newCol] = newColor;
                    queue.offer(new int[]{newRow, newCol});
                }
            } 
        }
        return image;
    }
}
