class Solution {
    public int myAtoi(String str) {
        if (str.length() == 0) return 0;
        int index = 0;
        int sign = 1;
        int value = 0;
        while (index < str.length() && str.charAt(index) == ' ') {
            index++;
        }
        if (index < str.length() && (str.charAt(index) == '+' || str.charAt(index) == '-')) {
            sign = str.charAt(index) == '+' ? 1 : -1;
            index++;
        }
        while (index < str.length() && Character.isDigit(str.charAt(index))) {
            if (value > Integer.MAX_VALUE / 10 || (value == Integer.MAX_VALUE / 10 && str.charAt(index) - '0' > 7)) {
                value = sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                return value;
            }
            value = value * 10 + (str.charAt(index) - '0');
            index++;
        }
        return value * sign;
    }
}