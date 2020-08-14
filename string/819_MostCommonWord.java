class Solution {
    // O(M + N) time
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> bannedSet = new HashSet<>();
        for (String word: banned) {
            bannedSet.add(word);
        }
        int maxCount = Integer.MIN_VALUE;
        String maxWord = null;
        Map<String, Integer> count = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < paragraph.length(); i++) {
            char c = paragraph.charAt(i);
            if (Character.isLetter(c)) {
                sb.append(Character.toLowerCase(c));
                if (i != paragraph.length() - 1) {
                    continue;
                }
            }
            if (sb.length() > 0) {
                String word = sb.toString();
                count.put(word, count.getOrDefault(word, 0) + 1);
                int num = count.get(word);
                if (num > maxCount && !bannedSet.contains(word)) {
                    maxCount = num;
                    maxWord = word;
                }
                sb = new StringBuilder();
            }
        }
        return maxWord;
    }

    public String mostCommonWordShort(String p, String[] banned) {
        Set<String> ban = new HashSet<>(Arrays.asList(banned));
        Map<String, Integer> count = new HashMap<>();
        String[] words = p.replaceAll("\\W+" , " ").toLowerCase().split("\\s+");
        for (String w : words) if (!ban.contains(w)) count.put(w, count.getOrDefault(w, 0) + 1);
        return Collections.max(count.entrySet(), Map.Entry.comparingByValue()).getKey();
    }
}