class Solution:
    def uniqueOccurrences(self, arr: List[int]) -> bool:
        count = defaultdict(int)
        for num in arr:
            count[num] += 1
        return len(count.values()) == len(set(count.values()))
