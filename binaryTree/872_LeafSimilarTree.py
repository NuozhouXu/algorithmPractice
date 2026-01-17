# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def leafSimilarHelper(self, node: Optional[TreeNode], values: List[int]):
        if node is not None:
            if node.left is None and node.right is None:
                values.append(node.val)
            self.__leafSimilarHelper(node.left, values)
            self.__leafSimilarHelper(node.right, values)


    def leafSimilar(self, root1: Optional[TreeNode], root2: Optional[TreeNode]) -> bool:
        values1 = []
        values2 = []
        self.__leafSimilarHelper(root1, values1)
        self.__leafSimilarHelper(root2, values2)
        return values1 == values2