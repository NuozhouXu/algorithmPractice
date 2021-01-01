class Solution {
    // O(nlogn) time
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int l = 1;
        int r = 1000000000;
        
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (check(position, mid, m)) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return r - 1;
    }
    
    private boolean check(int[] position, int minimumDistance, int m) {
        // Always place first object at position[0]
        int lastBallPosition = position[0];
        int ballsLeftToBePlaced = m - 1;
        for (int i = 1; i < position.length && ballsLeftToBePlaced > 0; i++) {
            if (position[i] - lastBallPosition >= minimumDistance) {
                // Place the ball only if this ball is farther than the previous ball by minimumDistance
                lastBallPosition = position[i];
                ballsLeftToBePlaced--;
            }
        }
        return ballsLeftToBePlaced == 0;
    }
}