class Solution {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        
        do {
            slow = nextNum(slow);
            fast = nextNum(nextNum(fast));
        } while (slow != fast && fast != 1);
        
        return fast == 1;
    }
    
    private int nextNum(int num) {
        int next = 0;
        while (num > 0) {
            int digit = num % 10;
            num /= 10;
            next += digit * digit;
        }
        return next;
    }
}