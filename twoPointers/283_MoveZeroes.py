class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        # Position to place the next non-zero element
        pos = 0
        
        # Iterate through the array
        for i in range(len(nums)):
            # If current element is non-zero
            if nums[i] != 0:
                # Swap elements if needed (only when pos != i)
                if pos != i:
                    nums[pos] = nums[i]
                    nums[i] = 0
                # Move position pointer forward
                pos += 1