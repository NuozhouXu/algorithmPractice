class Solution {
    // O(mn) time
    public String multiply(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int[] digits = new int[num1.length() + num2.length()];
        for (int i = num2.length() - 1; i >= 0; i--) {
            for (int j = num1.length() - 1; j >= 0; j--) {
                int product = (num2.charAt(i) - '0') * (num1.charAt(j) - '0');
                int p1 = i + j;
                int p2 = i + j + 1; 
                int sum = product + digits[p2];
                digits[p1] += sum / 10;
                digits[p2] = sum % 10;
            }
        }
        
        for (int i = 0; i < digits.length; i++) {
            if (!(sb.length() == 0 && digits[i] == 0)) {
                sb.append(digits[i]);
            }
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}