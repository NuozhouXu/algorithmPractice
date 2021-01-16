class Solution {
    // O(max(tx, ty)) time O(1) space
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        while (tx >= sx && ty >= sy) {
            if (sx == tx && sy == ty) return true;
            if (tx > ty) {
                tx -= ty;
            } else {
                ty -= tx;
            }
        }
        return false;
    }

    // O(log(max(tx, ty))) time O(1) space
    public boolean reachingPointsOptimized(int sx, int sy, int tx, int ty) {
        while (tx >= sx && ty >= sy) {
            if (tx == ty) break;
            if (tx > ty) {
                if (ty > sy) tx %= ty;
                else return (tx - sx) % ty == 0;
            } else {
                if (tx > sx) ty %= tx;
                else return (ty - sy) % tx == 0;
            }
        }
        return (tx == sx && ty == sy);
    }
}