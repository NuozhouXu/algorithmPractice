class Solution {
    public String largestNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, (a, b) -> {
            String order1 = a + b; // 109
            String order2 = b + a; // 910
            return order2.compareTo(order1);
        });
        
        if (strs[0].equals("0")) return "0";
        StringBuilder sb = new StringBuilder();
        for (String num: strs) {
            sb.append(num);
        }
        return sb.toString();
    }
}