class Solution {
    public List<String> removeComments(String[] source) {
        boolean inBlock = false;
        StringBuilder newLine = new StringBuilder();
        List<String> ans = new ArrayList<>();
        for (String line: source) {
            int i = 0;
            if (!inBlock) newLine = new StringBuilder();
            while (i < line.length()) {
                if (!inBlock) {
                    if (i < line.length() - 1 && line.charAt(i) == '/' && line.charAt(i + 1) == '*') {
                        inBlock = true;
                        i += 2;
                    } else if (i < line.length() - 1 && line.charAt(i) == '/' && line.charAt(i + 1) == '/') {
                        break;
                    } else {
                        newLine.append(line.charAt(i));
                        i++;
                    }
                } else {
                    if (i < line.length() - 1 && line.charAt(i) == '*' && line.charAt(i + 1) == '/') {
                        inBlock = false;
                        i += 2;
                    } else {
                        i++;
                    }
                }
            }
            
            if (!inBlock && newLine.length() > 0) {
                ans.add(newLine.toString());
            }
        }
        return ans;
    }
}