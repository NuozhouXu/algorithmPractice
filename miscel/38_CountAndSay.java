class Solution {
    public String countAndSay(int n) {
        StringBuilder curr = new StringBuilder();
        curr.append("1");
        for (int i = 2; i <= n; i++) {
            StringBuilder prev = curr;
            curr = new StringBuilder();
            int count = 1;
            char say = prev.charAt(0);
            for (int j = 1; j < prev.length(); j++) {
                if (prev.charAt(j) != say) {
                    curr.append(count);
                    curr.append(say);
                    count = 1;
                    say = prev.charAt(j);
                } else {
                    count++;
                }
            }
            curr.append(count);
            curr.append(say);
        }
        return curr.toString();
    }
}