class Solution {
    // O(logn)
    public int addDigits(int num) {
        int digitalRoot = 0;
        while (num > 0) {
            digitalRoot += num % 10;
            num = num / 10;
            
            if (num == 0 && digitalRoot > 9) {
                num = digitalRoot;
                digitalRoot = 0;  
            }    
        }     
        return digitalRoot;
    }

    // O(1)
    public int addDigitsMath(int num) {
        if (num == 0) return 0;
        if (num % 9 == 0) return 9;
        return num % 9;
    }
}