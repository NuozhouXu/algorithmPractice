# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def oddEvenList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        # Edge cases: empty list or single node
        if not head or not head.next:
            return head
        
        # Initialize pointers
        odd = head  # Points to current odd node
        even = head.next  # Points to current even node
        even_head = even  # Save the head of even list to connect later
        
        # Traverse and rearrange
        # We continue while there are even nodes to process
        while even and even.next:
            # Connect current odd node to next odd node
            odd.next = even.next
            even.next = even.next.next
            odd = odd.next
            even = even.next
        
        # Connect the end of odd list to the head of even list
        odd.next = even_head
        
        return head
        