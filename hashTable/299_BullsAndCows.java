class Solution {
    // O(n) time
    public String getHint(String secret, String guess) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < secret.length(); i++) {
            char c = secret.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int bulls = 0;
        int cows = 0;
        for (int i = 0; i < guess.length(); i++) {
            char c = guess.charAt(i);
            if (map.containsKey(c)) {
                if (c == secret.charAt(i)) {
                    bulls++;
                    if (map.get(c) <= 0) {
                        cows--;
                    }
                } else {
                    if (map.get(c) > 0) {
                        cows++;
                    }
                }
                map.put(c, map.get(c) - 1);
            }
        }
        return Integer.toString(bulls) + "A" + Integer.toString(cows) + "B";
    }

    public String getHintOnePass(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        int[] numbers = new int[10];
        for (int i = 0; i<secret.length(); i++) {
            int s = Character.getNumericValue(secret.charAt(i));
            int g = Character.getNumericValue(guess.charAt(i));
            if (s == g) bulls++;
            else {
                if (numbers[s] < 0) cows++;
                if (numbers[g] > 0) cows++;
                numbers[s] ++;
                numbers[g] --;
            }
        }
        return bulls + "A" + cows + "B";
    }
}