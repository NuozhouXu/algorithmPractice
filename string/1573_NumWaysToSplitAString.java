class Solution {
    // 3! / 2! * 1!
    // 
    public int numWays(String s) {
        int numOnes = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                numOnes++;
                map.put(numOnes, i);
            }
        }
        if (numOnes % 3 != 0) return 0;
        long result = 0L;
        if (numOnes == 0) {
            long first = (long)(s.length() - 1);
            long second = (long)(s.length() - 2);
            return (int) ((first * second / 2L) % 1000000007);
        } else {
            long first = (long) (map.get(numOnes / 3 + 1) - map.get(numOnes / 3));
            long second = (long) (map.get(numOnes / 3 * 2 + 1) - map.get(numOnes / 3 * 2));
            result = first * second;
            return (int) (result % 1000000007);
        }
        
    }
}