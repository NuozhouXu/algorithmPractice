# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def pairSum(self, head: Optional[ListNode]) -> int:
        # Step 1: Find the middle of the linked list
        slow = fast = head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
        
        # Now slow is at the middle (start of second half)
        
        # Step 2: Reverse the second half
        prev = None
        curr = slow
        while curr:
            next_temp = curr.next
            curr.next = prev
            prev = curr
            curr = next_temp
        
        # prev now points to the head of the reversed second half
        
        # Step 3: Calculate twin sums
        max_sum = 0
        first_half = head
        second_half = prev
        
        while second_half:  # second_half will become None first
            twin_sum = first_half.val + second_half.val
            max_sum = max(max_sum, twin_sum)
            first_half = first_half.next
            second_half = second_half.next
        
        return max_sum