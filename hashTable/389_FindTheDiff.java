class Solution {
    // O(N) time O(26) space
    public char findTheDifference(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
            }
            if (!map.containsKey(c) || map.get(c) < 0) {
                return c;
            }
        }
        return 'a';
    }

    public char findTheDifferenceBitManipulation(String s, String t) {

		// Initialize ch with 0, because 0 ^ X = X
		// 0 when XORed with any bit would not change the bits value.
		char ch = 0;

		// XOR all the characters of both s and t.
		for (int i = 0; i < s.length(); i += 1) {
			ch ^= s.charAt(i);
		}
		for (int i = 0; i < t.length(); i += 1) {
			ch ^= t.charAt(i);
		}

		// What is left after XORing everything is the difference.
		return ch;
	}
}