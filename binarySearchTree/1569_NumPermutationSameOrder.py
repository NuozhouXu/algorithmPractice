class Solution:
    def numOfWays(self, nums: List[int]) -> int:
        def numOfWaysHelper(nums):
            if len(nums) <= 2: return 1
            left = [v for v in nums if v < nums[0]]
            right = [v for v in nums if v > nums[0]]
            return comb(len(left)+len(right), len(right)) * numOfWaysHelper(left) * numOfWaysHelper(right)
        return (numOfWaysHelper(nums)-1) % 1000000007