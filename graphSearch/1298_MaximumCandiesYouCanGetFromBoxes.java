class Solution {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        Deque<Integer> queue = new ArrayDeque<>();
        boolean[] reachedClosedBoxes = new boolean[status.length];
        
        for (int box: initialBoxes) {
            if (status[box] == 1) {
                queue.offer(box);
            } else {
                reachedClosedBoxes[box] = true;
            }
        }
        int numCandies = 0;
        while (!queue.isEmpty()) {
            int box = queue.poll();
            numCandies += candies[box];
            for (int key: keys[box]) {
                if (status[key] == 0 && reachedClosedBoxes[key]) {
                    queue.offer(key);
                }
                status[key] = 1;
            }
            for (int containedBox: containedBoxes[box]) {
                if (status[containedBox] == 1) {
                    queue.offer(containedBox);
                } else {
                    reachedClosedBoxes[containedBox] = true;
                }
            }
        }
        return numCandies;
    }
}