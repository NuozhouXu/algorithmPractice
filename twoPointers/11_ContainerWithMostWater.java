class Solution {
    public int maxArea(int[] height) {
        if (height.length == 0) return 0;
        
        int maximumArea = 0;
        int l = 0, r = height.length - 1;
        while (l < r) {
            maximumArea = Math.max(maximumArea, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return maximumArea;
    }
}