class Solution:
    def findMaxAverage(self, nums: List[int], k: int) -> float:
        window_sum = 0
        max_window_sum = -float('inf')
        start = 0
        end = 0
        while end < len(nums):
            window_sum += nums[end]
            end += 1
            if end - start == k:
                if window_sum > max_window_sum:
                    max_window_sum = float(window_sum)
                window_sum -= nums[start]
                start += 1
        return max_window_sum / k

