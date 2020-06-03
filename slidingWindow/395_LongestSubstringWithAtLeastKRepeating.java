class Solution {
    public int longestSubstring(String s, int k) {
        int d = 0;
    
        for (int numUniqueTarget = 1; numUniqueTarget <= 26; numUniqueTarget++)
            d = Math.max(d, longestSubstringWithNUniqueChars(s, k, numUniqueTarget));

        return d;
    }
    
    private int longestSubstringWithNUniqueChars(String s, int k, int numUniqueTarget) {
        int[] count = new int[26];
        int numUnique = 0; // counter 1
        int numNoLessThanK = 0; // counter 2
        int begin = 0;
        int d = 0;
        
        for (int end = 0; end < s.length(); end++) {
            char rightChar = s.charAt(end);
            if (count[rightChar - 'a'] == 0) numUnique++;
            count[rightChar - 'a']++;
            if (count[rightChar - 'a'] == k) numNoLessThanK++;
            
            while (numUnique > numUniqueTarget) {
                char leftChar = s.charAt(begin);
                if (count[leftChar - 'a'] == k) numNoLessThanK--;
                count[leftChar - 'a']--;
                if (count[leftChar - 'a'] == 0) numUnique--;
                begin++;
            }
            
            if (numUnique == numUniqueTarget && numUnique == numNoLessThanK)
                d = Math.max(end - begin + 1, d);
        }
        return d;
    }
}