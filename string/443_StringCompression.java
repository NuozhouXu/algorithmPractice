class Solution {
    // O(N) time
    public int compress(char[] chars) {
        if (chars.length == 0) return 0;
        int index = 0;
        int i = 0;
        while (i < chars.length) {
            char c = chars[i];
            int j = i;
            while (j < chars.length && chars[i] == chars[j]) j++;
            int count = j - i;
            chars[index++] = c;
            if (count > 1) {
                String countStr = String.valueOf(count);
                for (int k = 0; k < countStr.length(); k++) {
                    chars[index++] = countStr.charAt(k);
                }
            }
            i = j;
        }
        return index;
    }
}