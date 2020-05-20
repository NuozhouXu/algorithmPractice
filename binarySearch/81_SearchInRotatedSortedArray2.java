class Solution {
    // 2 2 2 3 2
    public boolean search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return true;
            } else if (nums[l] < nums[mid]) { // pivot not in l to mid
                if (nums[l] <= target && target < nums[mid]) r = mid - 1;
                else l = mid + 1;
            } else if (nums[l] > nums[mid]){
                if (nums[mid] < target && target <= nums[r]) l = mid + 1;
                else r = mid - 1;
            } else {
                l++;
            }
        }
        return false;
    }
}