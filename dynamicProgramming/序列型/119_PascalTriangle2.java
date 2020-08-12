class Solution {
    public List<Integer> getRow(int rowIndex) {
        int[][] dp = new int[2][rowIndex + 1];
        dp[0][0] = 1;
        int prev = 0;
        for (int i = 1; i <= rowIndex; i++) {
            int curr = 1 - prev;
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    dp[curr][j] = 1;
                } else {
                    dp[curr][j] = dp[prev][j - 1] + dp[prev][j];
                }
            }
            prev = curr;
        }
        List<Integer> results = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            results.add(dp[prev][i]);
        }
        return results;
    }

    public List<Integer> getRowSimplified(int k) {
        Integer[] arr = new Integer[k + 1];
        Arrays.fill(arr, 0);
        arr[0] = 1;
        
        for (int i = 1; i <= k; i++) 
            for (int j = i; j > 0; j--) 
                arr[j] = arr[j] + arr[j - 1];
        
        return Arrays.asList(arr);
    }
}