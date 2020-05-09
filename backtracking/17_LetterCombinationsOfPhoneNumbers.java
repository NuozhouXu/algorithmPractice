class Solution {
    Map<Character, String> phone = new HashMap<Character, String>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};
    
    // O(3^n * 4^m)
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return new ArrayList<>();
        List<String> results = new ArrayList<>();
        backtrack(digits, 0, new char[digits.length()], results);
        return results;
    }
    
    private void backtrack(String digits, int index, char[] curr, List<String> results) {
        if (index == digits.length()) {
            results.add(new String(curr));
        } else {
            System.out.println(index);
            String letters = phone.get(digits.charAt(index));
            for (int i = 0; i < letters.length(); i++) {
                curr[index] = letters.charAt(i);
                backtrack(digits, index + 1, curr, results);
            }
        }
    }
}