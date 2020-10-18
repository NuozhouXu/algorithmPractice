class Solution {
    // O(N) time
    public boolean buddyStrings(String A, String B) {
        if (A.length() != B.length() || A.length() <= 1) return false;
        if (A.equals(B)) {
            Set<Character> s = new HashSet<>();
            for (char c : A.toCharArray()) s.add(c);
            return s.size() < A.length();
        }
        List<Integer> diffIndexes = new ArrayList<>();
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) != B.charAt(i)) {
                diffIndexes.add(i);
                if (diffIndexes.size() > 2) return false;
            }
        }
        if (diffIndexes.size() < 2) return false;
        int first = diffIndexes.get(0);
        int second = diffIndexes.get(1);
        return A.charAt(first) == B.charAt(second) && A.charAt(second) == B.charAt(first);
    }
}