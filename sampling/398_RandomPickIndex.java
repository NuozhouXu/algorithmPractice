class Solution {
    private Map<Integer, List<Integer>> map;
    private Random rand;

    // O(n) time O(n) space
    public Solution(int[] nums) {
        this.map = new HashMap<>();
        this.rand = new Random();
        for (int i = 0; i < nums.length; i++) {
            map.putIfAbsent(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
        }
    }
    
    public int pick(int target) {
        return map.get(target).get(rand.nextInt(map.get(target).size()));
    }
}

class Solution {
    
    private int[] nums;
    private Random rand;

    public Solution(int[] nums) {
        this.nums = nums;
        this.rand = new Random();
    }
    
    public int pick(int target) {
        int count = 0;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                count++;
                if (rand.nextInt(count) == 0) {
                    index = i;
                }
            }
        }
        return index;
    }
}