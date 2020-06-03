class Solution {
    // O(n) time O(n) space
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num: nums) {
            set.add(num);
        }
        
        int longestStreak = 0;
        for (int num: set) {
            if (!set.contains(num - 1)) {
                int currNum = num;
                int currStreak = 1;
                
                while (set.contains(currNum + 1)) {
                    currNum++;
                    currStreak++;
                }
                longestStreak = Math.max(longestStreak, currStreak);
            }
        }
        return longestStreak;
    }
}