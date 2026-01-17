class Solution:
    def isSubsequence(self, s: str, t: str) -> bool:
        ps = 0
        pt = 0
        while ps < len(s) and pt < len(t):
            if s[ps] == t[pt]:
                ps += 1
                pt += 1
            else:
                pt += 1
        return ps == len(s)