class Solution {
    // O(NlogK) where K is the number of unique chars
    public String reorganizeString(String S) {
        Map<Character, Integer> count = new HashMap<>();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            count.put(c, count.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> count.get(b) - count.get(a));
        for (char key: count.keySet()) pq.offer(key);
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            Character c = pq.poll();
            if (sb.length() == 0 || c != sb.charAt(sb.length() - 1)) {
                sb.append(c);
                if (count.get(c) > 1) {
                    count.put(c, count.get(c) - 1);
                    pq.offer(c);
                }
            } else {
                Character c2 = pq.poll();
                if (c2 == null) return "";
                sb.append(c2);
                if (count.get(c2) > 1) {
                    count.put(c2, count.get(c2) - 1);
                    pq.offer(c2);
                }
                pq.offer(c);
            }
        }
        return sb.toString();
    }

    // O(N)
    public String reorganizeStringOptimal(String S) {
        int[] hash = new int[26];
        for (int i = 0; i < S.length(); i++) {
            hash[S.charAt(i) - 'a']++;
        } 
        int max = 0, letter = 0;
        for (int i = 0; i < hash.length; i++) {
            if (hash[i] > max) {
                max = hash[i];
                letter = i;
            }
        }
        if (max > (S.length() + 1) / 2) {
            return ""; 
        }
        char[] res = new char[S.length()];
        int idx = 0;
        while (hash[letter] > 0) {
            res[idx] = (char) (letter + 'a');
            idx += 2;
            hash[letter]--;
        }
        for (int i = 0; i < hash.length; i++) {
            while (hash[i] > 0) {
                if (idx >= res.length) {
                    idx = 1;
                }
                res[idx] = (char) (i + 'a');
                idx += 2;
                hash[i]--;
            }
        }
        return String.valueOf(res);
    }
}