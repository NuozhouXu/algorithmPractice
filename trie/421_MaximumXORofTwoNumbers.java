class TrieNode {
    
    private TrieNode[] links;
    
    public TrieNode() {
        this.links = new TrieNode[2];
    }
    
    public boolean containsKey(char key) {
        return links[key - '0'] != null;
    }
    
    public TrieNode get(char key) {
        return links[key - '0'];
    }
    
    public void put(char key, TrieNode node) {
        links[key - '0'] = node;
    }
}

class Solution {
    public int findMaximumXOR(int[] nums) {
        int maxNum = nums[0];
        for (int num : nums) maxNum = Math.max(maxNum, num);
        int L = Integer.toBinaryString(maxNum).length();
        int n = nums.length;
        String[] strNums = new String[n];
        int bitmask = 1 << L;
        for (int i = 0; i < n; i++) {
            strNums[i] = Integer.toBinaryString(bitmask | nums[i]).substring(1);
        }
        
        TrieNode trie = new TrieNode();
        int maxXor = 0;
        for (String num: strNums) {
            TrieNode node = trie;
            TrieNode xorNode = trie;
            int currXor = 0;
            for (Character bit: num.toCharArray()) {
                if (!node.containsKey(bit)) {
                    node.put(bit, new TrieNode());
                }
                node = node.get(bit);
                
                char toggledBit = bit == '1' ? '0' : '1';
                if (xorNode.containsKey(toggledBit)) {
                    currXor = (currXor << 1) | 1;
                    xorNode = xorNode.get(toggledBit);
                } else {
                    currXor = currXor << 1;
                    xorNode = xorNode.get(bit);
                }
            }
            
            maxXor = Math.max(maxXor, currXor);
        }
        return maxXor;
    }
}