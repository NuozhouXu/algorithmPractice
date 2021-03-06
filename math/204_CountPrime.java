class Solution {
    public int countPrimes(int n) {
        if (n <= 1) return 0;
        boolean[] notPrime = new boolean[n];
        notPrime[0] = true; 
        notPrime[1] = true; 
        for (int i = 2; i < Math.sqrt(n); i++) {
            for (int j = 2; i * j < n; j++) {
                notPrime[i * j] = true;
            }
        }
        
        int count = 0; 
        for (int i = 2; i < n; i++){
            if (!notPrime[i]) count++;
        }
        return count;
    }
}