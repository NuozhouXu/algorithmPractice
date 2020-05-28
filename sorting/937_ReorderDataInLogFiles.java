class Solution {
    // O(NlogN)
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (log1, log2) -> {
            String[] split1 = log1.split(" ", 2);
            String[] split2 = log2.split(" ", 2);
            boolean isDigitLog1 = Character.isDigit(split1[1].charAt(0));
            boolean isDigitLog2 = Character.isDigit(split2[1].charAt(0));
            if (!isDigitLog1 && !isDigitLog2) {
                int result = split1[1].compareTo(split2[1]);
                if (result == 0) {
                    return split1[0].compareTo(split2[0]);
                }
                return result;
            }
            return isDigitLog1 ? (isDigitLog2 ? 0 : 1) : -1;
        });
        return logs;
    }
}