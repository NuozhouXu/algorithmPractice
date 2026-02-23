class Solution:
    def tribonacciTopdown(self, n: int) -> int:
        dp = {0: 0, 1: 1, 2: 1}
        def dfs(i):
            if i in dp:
                return dp[i]
            dp[i] = dfs(i - 1) + dfs(i - 2) + dfs(i - 3)
            return dp[i]
        
        return dfs(n)
    def tribonacciBottomUp(self, n: int) -> int:
        if n < 3:
            return 1 if n else 0
        dp = [0] * (n + 1)
        dp[1] = dp[2] = 1
        for i in range(3, n + 1):
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3]
        return dp[n]
    def tribonacci(self, n: int) -> int:
        if n < 3:
            return 1 if n else 0
        first, second, third = 0, 1, 1
        for _ in range(3, n + 1):
            first, second, third = second, third, first + second + third
        return third
        