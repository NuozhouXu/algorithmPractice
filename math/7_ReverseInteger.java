class Solution {
    public int reverse(int x) {
        int result = 0;
        while (x != 0) {
            int digit = x % 10;
            x /= 10;
            int newResult = result * 10 + digit;
            if ((newResult - digit) / 10 != result) return 0;
            result = newResult;
        }
        return result;
    }
}