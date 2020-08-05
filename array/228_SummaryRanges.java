class Solution {
    public String fromRange(int low, int high) { 
        return low == high ? String.valueOf(low) : (low + "->" + high);
    }
    
    //O(N) time O(1) space
    public List<String> summaryRanges(int[] nums) {
        List<String> results = new ArrayList<>();
        if (nums.length == 0) return results;
        int left = nums[0];
        int right = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == right + 1) {
                right = nums[i];
            } else {
                results.add(fromRange(left, right));
                left = nums[i];
                right = nums[i];
            }
        }
        results.add(fromRange(left, right));
        return results;
    }
}