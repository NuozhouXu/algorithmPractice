class Codec:
    def encode(self, strs: list[str]) -> str:
        """Encodes a list of strings to a single string.
        
        Format: "length:string" for each string
        Example: ["Hello","World"] -> "5:Hello5:World"
        """
        encoded = []
        for s in strs:
            # Store length, delimiter ':', then the actual string
            encoded.append(str(len(s)))
            encoded.append(':')
            encoded.append(s)
        return ''.join(encoded)
    
    def decode(self, s: str) -> list[str]:
        """Decodes a single string to a list of strings."""
        result = []
        i = 0
        
        while i < len(s):
            # Find the delimiter ':'
            colon_pos = s.find(':', i)
            
            # Extract the length
            length = int(s[i:colon_pos])
            
            # Extract the string of that length
            start = colon_pos + 1
            result.append(s[start:start + length])
            
            # Move to the next encoded string
            i = start + length
        
        return result

# Your Codec object will be instantiated and called as such:
# codec = Codec()
# codec.decode(codec.encode(strs))