class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<>();
        if (nums == null || nums.length == 0){
            result.add(fromRange(lower,upper));
            return result;
        }

        // 1st step
        if (nums[0] > lower){
            result.add(fromRange(lower,nums[0]-1));
        }

        // 2nd step
        for (int i = 0; i < nums.length-1; i++){
            if (nums[i+1] != nums[i] && nums[i+1] > nums[i] +1) {
                result.add(fromRange(nums[i]+1, nums[i+1]-1));
            }
        }

       // 3rd step
        if (nums[nums.length-1] < upper){
            result.add(fromRange(nums[nums.length-1]+1, upper));
        }
        return result;
    }
    
    public String fromRange(int low, int high){
        return low == high ? String.valueOf(low) : (low + "->" + high);
    }
}