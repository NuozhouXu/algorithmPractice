class Solution {
    public String kthSmallestPath(int[] destination, int k) {
        StringBuilder sb = new StringBuilder();
        int r = destination[0];
        int c = destination[1];
        int remainingDown = r;
        
        for (int step = 0; step < r + c; step++) {
            // Calculate the number of combinations with H selected at this step.
            // All of those combinations will be lexicographically smaller than if V is selected
            int remainingStep = r + c - step - 1;
            int numComb = comb(remainingStep, remainingDown);
            // Kth is within these combinations, we have to choose an H
            if (numComb >= k) {
                sb.append("H");
            } else {
                // Choose a V
                remainingDown--;
                k -= numComb;
                sb.append("V");
            }
        }
        return sb.toString();
    }
    
    // https://stackoverflow.com/questions/2201113/combinatoric-n-choose-r-in-java-math
    private int comb(int n, int r) {
        int nCr = 1;
        for (int k = 0; k < r; k++) {
            nCr = nCr * (n - k) / (k + 1);
        }
        return nCr;
    }
}