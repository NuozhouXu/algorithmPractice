class Solution {
    // O(n) time O(n) space
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        List<StringBuilder> sbList = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            sbList.add(new StringBuilder());
        }
        int row = 0;
        int dir = -1;
        for (int i = 0; i < s.length(); i++) {
            sbList.get(row).append(s.charAt(i));
            if (row == 0 || row == numRows - 1) dir = -dir;
            row += dir;
        }
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            output.append(sbList.get(i));
        }
        return output.toString();
    }
}