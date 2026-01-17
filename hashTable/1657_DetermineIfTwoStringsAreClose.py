class Solution:
    def closeStrings(self, word1: str, word2: str) -> bool:
        # Quick check for length equality
        if len(word1) != len(word2):
            return False
        
        # Use Counter
        count1 = Counter(word1)
        count2 = Counter(word2)
        
        # Compare the characters directly
        return count1.keys() == count2.keys() and sorted(count1.values()) == sorted(count2.values())
        