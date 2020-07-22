class Solution {
    // O(N)
    public String simplifyPath(String path) {
        if (path.length() == 0) return path;
        StringBuilder sb = new StringBuilder();
        Deque<String> stack = new ArrayDeque<>();
        String[] components = path.split("/");
        for (int i = 0; i < components.length; i++) {
            String c = components[i];
            if (c.length() == 0 || c.equals(".")) {
                continue;
            } else if (c.equals("..")) {
                if (!stack.isEmpty()) stack.pop();
            } else {
                stack.push(c);
            }
        }
        String[] results = new String[stack.size()];
        int index = stack.size() - 1;
        while (!stack.isEmpty()) {
            results[index--] = stack.pop();
        }
        for (int i = 0; i < results.length; i++) {
            sb.append("/");
            sb.append(results[i]);
        }
        return sb.length() > 0 ? sb.toString() : "/";
    }
}