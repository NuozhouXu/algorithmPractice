class Solution:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        prev = None
        curr = head
        
        while curr:
            next_temp = curr.next  # Save next node
            curr.next = prev       # Reverse the link
            prev = curr            # Move prev forward
            curr = next_temp       # Move curr forward
        
        return prev
    
    def reverseListRecursive(self, head: Optional[ListNode]) -> Optional[ListNode]:
        # Base case: empty list or single node
        if not head or not head.next:
            return head
        
        # Recursively reverse the rest of the list
        new_head = self.reverseList(head.next)
        
        # Reverse the link between current and next node
        head.next.next = head
        head.next = None
        
        return new_head