class Solution {
    // O(n*m^2 + m*n^2)
    public int numTriplets(int[] nums1, int[] nums2) {
        Map<Long, Integer> count1 = countProducts(nums1);
        Map<Long, Integer> count2 = countProducts(nums2);
        
        int ans = 0;
        for (int num: nums1) {
            ans += count2.getOrDefault((long) num * (long) num, 0);
        }
        for (int num: nums2) {
            ans += count1.getOrDefault((long) num * (long) num, 0);
        }
        return ans;
    }
    
    private Map<Long, Integer> countProducts(int[] nums) {
        Map<Long, Integer> count = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                long product = (long) nums[i] * (long) nums[j];
                count.put(product, count.getOrDefault(product, 0) + 1);
            }
        }
        return count;
    }

    // O(mn) time
    public int numTripletsTwoProduct(int[] nums1, int[] nums2) {
        long ans = 0;
        for (int num: nums1) {
            ans += twoProduct(nums2, (long)num * (long)num);
        }
        for (int num: nums2) {
            ans += twoProduct(nums1, (long)num * (long)num);
        }
        return (int) ans;
    }
    
    private long twoProduct(int[] nums, long target) {
        long count = 0L;
        Map<Long, Long> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            long num = (long) nums[i];
            if (target % num == 0 && map.containsKey(target / num)) {
                count += map.get(target / num);
            }
            map.put(num, map.getOrDefault(num, 0L) + 1);
        }
        return count;
    }
}