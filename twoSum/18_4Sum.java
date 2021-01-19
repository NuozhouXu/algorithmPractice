class Solution {
    // O(n^3)
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums.length < 4) return results;
        Arrays.sort(nums);
        for (int i = 0; i <= nums.length - 4; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j <= nums.length - 3; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                List<List<Integer>> twoSumResults = twoSum(nums, target - nums[i] - nums[j], j + 1);
                for (List<Integer> pair: twoSumResults) {
                    results.add(Arrays.asList(nums[i], nums[j], pair.get(0), pair.get(1)));
                }
            }
        }
        return results;
    }
    
    private List<List<Integer>> twoSum(int[] nums, int target, int startIndex) {
        List<List<Integer>> results = new ArrayList<>();
        int l = startIndex;
        int r = nums.length - 1;
        while (l < r) {
            if (nums[l] + nums[r] < target) {
                l++;
            } else if (nums[l] + nums[r] > target) {
                r--;
            } else {
                results.add(Arrays.asList(nums[l], nums[r]));
                l++;
                r--;
                while (l < r && nums[l] == nums[l - 1]) l++;
                while (l < r && nums[r] == nums[r + 1]) r--;
            }
        }
        return results;
    }

    public List<List<Integer>> fourSumGeneralized(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums, 0, 4, target);
    }
    private List<List<Integer>> kSum(int[] nums, int start, int k, int target) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (k == 2) {
            int left = start, right = len - 1;
            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum == target) {
                    List<Integer> pair = new ArrayList<>();
                    pair.add(nums[left]);
                    pair.add(nums[right]);
                    res.add(pair);
                    left++;
                    right--;
                    while(left < right && nums[left] == nums[left - 1]) left++;
                    while(left < right && nums[right] == nums[right + 1]) right--;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        } else {
            for (int i = start; i < len - (k - 1); i++) {
                if (i > start && nums[i] == nums[i - 1]) continue;
                List<List<Integer>> temp = kSum(nums, i + 1, k - 1, target - nums[i]);
                for (List<Integer> t : temp) {
                   t.add(0, nums[i]);
                }                    
                res.addAll(temp);
            }
        }
        return res;
    }
}