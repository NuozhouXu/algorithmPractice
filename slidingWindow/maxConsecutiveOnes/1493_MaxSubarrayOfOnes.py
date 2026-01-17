class Solution:
    def longestSubarray(self, nums: List[int]) -> int:
        start = 0
        num_zeroes = 0
        max_size = 0
        for end in range(len(nums)):
            if nums[end] == 0:
                num_zeroes += 1
            while num_zeroes > 1:
                if nums[start] == 0:
                    num_zeroes -= 1
                start += 1
            max_size = max(max_size, end - start)
        return max_size