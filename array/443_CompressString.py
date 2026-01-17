class Solution:
    def compress(self, chars: List[str]) -> int:
        idx = 0
        i = 0
        while i < len(chars):
            count = 1
            while (i + count < len(chars) and chars[i + count] == chars[i]):
                count += 1
            chars[idx] = chars[i]
            idx += 1
            if count > 1:
                str_count = str(count)
                chars[idx:idx + len(str_count)] = str_count
                idx += len(str_count)
            i += count
        return idx