# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __goodNodesHelper(self, node: TreeNode, maximum: int) -> int:
        if node is None:
            return 0
        
        if node.val >= maximum:
            return 1 + self.__goodNodesHelper(node.left, node.val) + self.__goodNodesHelper(node.right, node.val)
        else:
            return self.__goodNodesHelper(node.left, maximum) + self.__goodNodesHelper(node.right, maximum)


    def goodNodes(self, root: TreeNode) -> int:
        return self.__goodNodesHelper(root, root.val)