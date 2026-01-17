class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        prefix = [0] * len(nums)
        suffix = [0] * len(nums)
        prefix[0] = 1
        for i in range(1, len(nums)):
            prefix[i] = prefix[i - 1] * nums[i - 1]
        
        suffix[len(nums) - 1] = 1
        for i in range(len(nums) - 2, -1, -1):
            suffix[i] = suffix[i + 1] * nums[i + 1]

        ans = []
        for i in range(len(nums)):
            ans.append(prefix[i] * suffix[i])
        return ans

    def productExceptSelfNoSpace(self, nums: List[int]) -> List[int]:
        ans = [0] * len(nums)
        ans[0] = 1
        for i in range(1, len(nums)):
            ans[i] = ans[i - 1] * nums[i - 1]
        
        r = 1
        for i in range(len(nums) - 1, -1, -1):
            ans[i] = r * ans[i]
            r *= nums[i]

        return ans