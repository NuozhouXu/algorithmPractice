class Solution {
    public int atMostNGivenDigitSet(String[] digits, int n) {
        String s = String.valueOf(n);
        int[] dp = new int[s.length() + 1];
        dp[s.length()] = 1;
        
        for (int i = s.length() - 1; i >= 0; i--) {
            int c = s.charAt(i) - '0';
            for (String digit: digits) {
                if (Integer.valueOf(digit) < c) {
                    dp[i] += Math.pow(digits.length, s.length() - i - 1);
                } else if (Integer.valueOf(digit) == c) {
                    dp[i] += dp[i + 1];
                }
            }
        }
        
        for (int i = 1; i < s.length(); i++)
            dp[0] += Math.pow(digits.length, i);
        return dp[0];
    }
}