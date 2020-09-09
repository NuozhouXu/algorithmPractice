class Solution {
    public String modifyString(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '?') {
                c = 'a';
                if (i > 0 && sb.charAt(i-1) == 'a') c = 'b';
                if (i < s.length()-1 && s.charAt(i+1) == c) c = 'c';
            }
            sb.append(c);
        }
        return sb.toString();
    }
}