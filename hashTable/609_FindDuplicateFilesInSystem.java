class Solution {
    //Time complexity : O(n*x). n strings of average length x is parsed
    /*
    Follow-up beyond contest:
1. Imagine you are given a real file system, how will you search files? DFS or BFS?

2. If the file content is very large (GB level), how will you modify your solution?
3. If you can only read the file by 1kb each time, how will you modify your solution?
4. What is the time complexity of your modified solution? What is the most time-consuming part and memory consuming part of it? How to optimize?
5. How to make sure the duplicated files you find are not false positive?

https://leetcode.com/problems/find-duplicate-file-in-system/discuss/104120/Follow-up-questions-discussion
    */
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> map = new HashMap<>();
        for (String path: paths) {
            String[] info = path.split(" ");
            String filePath = info[0];
            for (int i = 1; i < info.length; i++) {
                String[] fileStr = info[i].split("\\(");
                fileStr[1] = fileStr[1].replace(")", "");
                String fileName = fileStr[0];
                String fileContent = fileStr[1];
                map.putIfAbsent(fileContent, new ArrayList<>());
                map.get(fileContent).add(filePath + "/" + fileName);
            }
        }
        List<List<String>> output = new ArrayList<>();
        for (String key: map.keySet()) {
            List<String> lst = map.get(key);
            if (lst.size() > 1)
                output.add(lst);
        }
        return output;
    }
}