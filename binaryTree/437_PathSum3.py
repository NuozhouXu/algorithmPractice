# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> int:
        def dfs(node, currentSum):
            if not node:
                return 0
            
            # Update current path sum
            currentSum += node.val
            
            # Check if there's a valid path ending at current node
            count = prefixSums[currentSum - targetSum]
            
            # Add current sum to the map
            prefixSums[currentSum] += 1
            
            # Explore left and right subtrees
            count += dfs(node.left, currentSum)
            count += dfs(node.right, currentSum)
            
            # Backtrack: remove current sum from the map
            prefixSums[currentSum] -= 1
            
            return count
        
        # Initialize with {0: 1} to handle paths starting from root
        prefixSums = defaultdict(int)
        prefixSums[0] = 1
        return dfs(root, 0)