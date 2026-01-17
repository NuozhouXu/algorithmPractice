class Solution:
    def reverseVowels(self, s: str) -> str:
        vowels = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'}
        s_list = list(s)  # Convert string to list to make it mutable
        start = 0
        end = len(s) - 1
        
        while start < end:
            if s_list[start] not in vowels:
                start += 1
            elif s_list[end] not in vowels:
                end -= 1
            else:
                # Swap vowels
                s_list[start], s_list[end] = s_list[end], s_list[start]
                # Move pointers after swapping
                start += 1
                end -= 1
                
        return ''.join(s_list)  # Convert back to string
        