class Solution {
    public int kthFactor(int n, int k) {
        List<Integer> divisors = new ArrayList();
        int sqrtN = (int) Math.sqrt(n);
        for (int x = 1; x < sqrtN + 1; ++x) {
            if (n % x == 0) {
                --k;
                divisors.add(x);
                if (k == 0) {
                    return x;    
                }    
            }    
        }
        
        // If n is a perfect square
        // we have to skip the duplicate 
        // in the divisor list
        if (sqrtN * sqrtN == n) {
            ++k;    
        }
                
        int nDiv = divisors.size();
        return (k <= nDiv) ? n / divisors.get(nDiv - k) : -1;
    }
}