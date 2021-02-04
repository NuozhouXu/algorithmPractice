class Solution {
    public boolean isNumber(String s) {
        Map<Integer, Map<Character, Integer>> states = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            states.put(i, new HashMap<>());
        }
        states.get(0).put('+', 1);
        states.get(0).put('-', 1);
        states.get(0).put('d', 2);
        states.get(0).put('.', 7);
        
        states.get(1).put('d', 2);
        states.get(1).put('.', 9);
        
        states.get(2).put('d', 2);
        states.get(2).put('.', 3);
        states.get(2).put('e', 5);
        states.get(2).put('E', 5);
        
        states.get(3).put('d', 4);
        states.get(3).put('e', 5);
        states.get(3).put('E', 5);
        
        states.get(4).put('d', 4);
        states.get(4).put('e', 5);
        states.get(4).put('E', 5);
        
        states.get(5).put('d', 8);
        states.get(5).put('+', 6);
        states.get(5).put('-', 6);
        
        states.get(6).put('d', 8);
        
        states.get(7).put('d', 4);
        
        states.get(8).put('d', 8);
        
        states.get(9).put('d', 4);
        
        int currState = 0;
        s = s.trim();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            currState = states.get(currState).getOrDefault(Character.isDigit(c) ? 'd' : c, -1);
            if (currState == -1) return false;
        }
        return currState == 2 || currState == 3 || currState == 4 || currState == 8;
    }
}