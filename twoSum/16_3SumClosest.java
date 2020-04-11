class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closestDiff = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) continue;
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int targetDiff = target - nums[i] - nums[left] -  nums[right];
                if (targetDiff == 0) return target;
                if (Math.abs(targetDiff) < Math.abs(closestDiff) || 
                    (Math.abs(targetDiff) == Math.abs(closestDiff) && targetDiff > closestDiff)) {
                    closestDiff = targetDiff;
                }
                if (targetDiff < 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return target - closestDiff;
    }
}