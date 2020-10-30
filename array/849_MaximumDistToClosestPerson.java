class Solution {
    public int maxDistToClosest(int[] seats) {
        int maxDist = 0;
        int i = 0;
        while (i < seats.length && seats[i] == 0) i++;
        maxDist = Math.max(maxDist, i - 0);
        int lastOne = i;
        while (i < seats.length) {
            if (seats[i] == 1) {
                maxDist = Math.max(maxDist, (i - lastOne) / 2);
                lastOne = i;
            }
            i++;
        }
        if (lastOne != seats.length - 1) {
            maxDist = Math.max(maxDist, seats.length - 1 - lastOne);
        }
        return maxDist;
    }
}