class Solution {
    public int orangesRotting(int[][] grid) {
        Deque<int[]> queue = new ArrayDeque<>();
        
        int numFresh = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 2) {
                    queue.offer(new int[]{row, col});
                } else if (grid[row][col] == 1) {
                    numFresh++;
                }
            } 
        }
        if (numFresh == 0) return 0;
        int timeNeeded = -1;
        int[][] directions = new int[][] {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] pair = queue.poll();
                int row = pair[0];
                int col = pair[1];
                for (int[] direction: directions) {
                    int neighborRow = row + direction[0];
                    int neighborCol = col + direction[1];
                    if (neighborRow >= 0 && neighborRow < grid.length &&
                        neighborCol >= 0 && neighborCol < grid[0].length &&
                        grid[neighborRow][neighborCol] == 1) {
                        grid[neighborRow][neighborCol] = 2;
                        queue.offer(new int[] {neighborRow, neighborCol});
                        numFresh--;
                    }
                }
            }
            timeNeeded++;
        }
        return numFresh == 0 ? timeNeeded : -1;
    }
}