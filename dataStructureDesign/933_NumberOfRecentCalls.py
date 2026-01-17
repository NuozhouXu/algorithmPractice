class RecentCounter:
    def __init__(self):
        # Initialize an empty queue to store the timestamps of requests
        self.requests = deque()
        
    def ping(self, t: int) -> int:
        # Add the new request timestamp to the queue
        self.requests.append(t)
        
        # Remove timestamps that are outside of the 3000ms window
        # Since t is always increasing, we only need to check from the front of the queue
        while self.requests and self.requests[0] < t - 3000:
            self.requests.popleft()
        
        # Return the number of requests within the time window
        return len(self.requests)