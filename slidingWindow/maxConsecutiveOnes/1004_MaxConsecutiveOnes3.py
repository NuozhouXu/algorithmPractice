class Solution:
    def longestOnes(self, nums: List[int], k: int) -> int:
        start = 0
        end = 0
        num_zeroes = 0
        max_consecutive_ones = 0
        while end < len(nums):
            if nums[end] == 0:
                num_zeroes += 1

            while num_zeroes > k:
                if nums[start] == 0:
                    num_zeroes -= 1
                start += 1
            max_consecutive_ones = max(max_consecutive_ones, end - start + 1)
            end += 1
        return max_consecutive_ones

        