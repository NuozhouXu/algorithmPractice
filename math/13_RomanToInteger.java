class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> values = new HashMap<>();
        values.put('M', 1000);
        values.put('D', 500);
        values.put('C', 100);
        values.put('L', 50);
        values.put('X', 10);
        values.put('V', 5);
        values.put('I', 1);
        
        char lastSymbol = s.charAt(s.length() - 1);
        int lastValue = values.get(lastSymbol);
        int total = lastValue;
        
        for (int i = s.length() - 2; i >= 0; i--) {
            char currentSymbol = s.charAt(i);
            int currentValue = values.get(currentSymbol);
            if (currentValue < lastValue) {
                total -= currentValue;
            } else {
                total += currentValue;
            }
            lastValue = currentValue;
        }
        return total;
    }
}