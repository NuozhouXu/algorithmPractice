class Solution:
    def maxOperations(self, nums: List[int], k: int) -> int:
        num_ops = 0
        freq_count = defaultdict(int)
        for num in nums:
            if freq_count[k - num] > 0:
                freq_count[k - num] -= 1
                num_ops += 1
            else:
                freq_count[num] += 1
        return num_ops