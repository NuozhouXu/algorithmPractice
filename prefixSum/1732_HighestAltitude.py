class Solution:
    def largestAltitude(self, gain: List[int]) -> int:
        altitude = 0
        max_altitude = 0
        for i in range(len(gain)):
            altitude += gain[i]
            max_altitude = max(max_altitude, altitude)
        return max_altitude