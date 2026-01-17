# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def longestZigZag(self, root: Optional[TreeNode]) -> int:
        self.max_length = 0
        
        def dfs(node):
            if not node:
                return -1, -1  # left_length, right_length
            
            left_left, left_right = dfs(node.left)
            right_left, right_right = dfs(node.right)
            
            # Current node's zigzag lengths
            # If we go left from current, we extend the right path from left child
            # If we go right from current, we extend the left path from right child
            curr_left = left_right + 1
            curr_right = right_left + 1
            
            self.max_length = max(self.max_length, curr_left, curr_right)
            
            return curr_left, curr_right
        
        dfs(root)
        return self.max_length