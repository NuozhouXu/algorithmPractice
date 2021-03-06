class Solution {
    public int[] searchRange(int[] nums, int target) {
        int startIndex = findFirst(nums, target);
        if (startIndex == nums.length || nums[startIndex] != target) return new int[] {-1, -1};
        int endIndex = findLast(nums, target);
        return new int[] {startIndex, endIndex};
    }
    
    private int findFirst(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        // find l such that l is the leftest element >= target
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < target) {
                l = mid + 1; // doesn't satisfy
            } else {
                r = mid; // satisfy
            }
        }
        return l;
    }
    
    private int findLast(int[] nums, int target) {
        int l = 0;
        int r = nums.length;
        // find l such that l is the leftest element > target
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > target) {
                r = mid; // satisfy
            } else {
                l = mid + 1; // not satisfy
            }
        }
        return l - 1;
    }
}