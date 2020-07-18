class Solution {
    // O(logn) time, O(logn) space
    public double myPow(double x, int n) {
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        return fastPow(x, n);
    }
    
    private double fastPow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        double half = fastPow(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }

    public double myPowNew(double x, int n) {
        long num = n;
        if (num < 0) {
            x = 1 / x;
            num = -num;
        }
        double ans = 1.0;
        double curr = x;
        for (long i = num; i > 0; i /= 2) {
            if (i % 2 == 1) {
                ans *= curr;
            }
            curr *= curr;
        }
        return ans;
    }
}