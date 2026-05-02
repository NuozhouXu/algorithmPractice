class StockSpanner:

    def __init__(self):
        # Each element is: (price, span)
        # Stack is decreasing by price from bottom to top
        self.stack = []

    def next(self, price: int) -> int:
        span = 1

        # Any previous price <= today's price is included in today's span.
        # Instead of popping one day at a time, we reuse its stored span.
        while self.stack and self.stack[-1][0] <= price:
            prev_price, prev_span = self.stack.pop()
            span += prev_span

        self.stack.append((price, span))
        return span
        


# Your StockSpanner object will be instantiated and called as such:
# obj = StockSpanner()
# param_1 = obj.next(price)