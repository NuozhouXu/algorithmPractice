class Solution:
    def pivotIndex(self, nums: List[int]) -> int:
        sum = 0
        left_prefix_sum = 0
        for num in nums:
            sum += num
        for i in range(len(nums)):
            right_prefix_sum = sum - left_prefix_sum - nums[i]
            if left_prefix_sum == right_prefix_sum:
                return i
            left_prefix_sum += nums[i]
        return -1