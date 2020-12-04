class Solution {
    public boolean canDistribute(int[] nums, int[] quantity) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num: nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        int idx = 0;
        int[] arrCounts = new int[count.size()];
        for (var key : count.keySet()) {
            arrCounts[idx++] = count.get(key);
        }
        Arrays.sort(arrCounts);
        Arrays.sort(quantity);
        reverse(quantity);
        return canDistributeHelper(arrCounts, quantity, 0);
    }
    
    private void reverse(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
    }
    
    private boolean canDistributeHelper(int[] counts, int[] quantity, int idx) {
        if (idx >= quantity.length) {
            return true;
        }
        
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] >= quantity[idx]) {
                counts[i] -= quantity[idx];
                if (canDistributeHelper(counts, quantity, idx + 1)) {
                    return true;
                }
                counts[i] += quantity[idx];
            }
        }
        
        return false;
    }
}