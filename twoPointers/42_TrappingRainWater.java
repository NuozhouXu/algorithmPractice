class Solution {
    // O(n) time O(1) space
    public int trap(int[] height) {
        if (height.length == 0) return 0;
        int l = 0;
        int r = height.length - 1;
        int maxL = height[l];
        int maxR = height[r];
        int water = 0;
        
        while (l < r) {
            if (height[l] < height[r]) {
                maxL = Math.max(height[l], maxL);
                water += maxL - height[l];
                l++;
            } else {
                maxR = Math.max(height[r], maxR);
                water += maxR - height[r];
                r--;
            }
        }
        return water;
    }

    // DP O(n) time O(n) space
    public int trapDP(int[] height) {
        if (height.length == 0) return 0;
        int[] maxL = new int[height.length];
        maxL[0] = height[0];
        int[] maxR = new int[height.length];
        maxR[height.length - 1] = height[height.length - 1];
        int water = 0;
        
        for (int i = 1; i < height.length; i++) {
            maxL[i] = Math.max(height[i], maxL[i - 1]);
        }
        for (int i = height.length - 2; i >= 0; i--) {
            maxR[i] = Math.max(height[i], maxR[i + 1]);
        }
        for (int i = 0; i < height.length; i++) {
            water += Math.min(maxL[i], maxR[i]) - height[i];
        }
        return water;
    }
}