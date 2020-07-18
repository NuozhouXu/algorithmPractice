class Solution {
    public double angleClock(int hour, int minutes) {
        // 1 min 6 degrees
        // 1 hour 30 degrees.
        double hourDegree = (hour % 12 + minutes / 60.0) * 30.0;
        double minuteDegree = minutes * 6.0;
        double diff = Math.abs(hourDegree - minuteDegree);
        return Math.min(diff, 360.0 - diff);
    }
}