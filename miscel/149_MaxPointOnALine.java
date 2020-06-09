class Solution {
    // O(n^2) time
    // O(n) space
    public int maxPoints(int[][] points) {
        int ans = 0;
        for (int i = 0; i < points.length; i++) {
            Map<String, Integer> map = new HashMap<>();
            int max = 0;
            int duplicate = 0;
            for (int j = i + 1; j < points.length; j++) {
                int deltaY = points[j][1] - points[i][1];
                int deltaX = points[j][0] - points[i][0];
                if (deltaY == 0 && deltaX == 0) {
                    duplicate++;
                    continue;
                }
                int gcd = gcd(deltaX, deltaY);
                deltaY /= gcd;
                deltaX /= gcd;
                String key = deltaX + "," + deltaY;
                map.put(key, map.getOrDefault(key, 0) + 1);
                max = Math.max(max, map.get(key));
            }
            ans = Math.max(ans, max + duplicate + 1);
        }
        return ans;
    }
    
    public int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a%b);
    }
}