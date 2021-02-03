class Solution {
    public int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {
        int minDist = Integer.MAX_VALUE;
        int totalDist = 0;
        for (int[] nut: nuts) {
            totalDist += (Math.abs(nut[0] - tree[0]) + Math.abs(nut[1] - tree[1])) * 2;
        }
        for (int[] nut: nuts) {
            int treeDist = Math.abs(nut[0] - tree[0]) + Math.abs(nut[1] - tree[1]);
            int squirrelDist = Math.abs(nut[0] - squirrel[0]) + Math.abs(nut[1] - squirrel[1]);
            minDist = Math.min(minDist, totalDist - treeDist + squirrelDist);
        }
        return minDist;
    }
}