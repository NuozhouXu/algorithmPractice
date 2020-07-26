class Solution {
    public int numOfSubarrays(int[] arr) {
        long count = 0;
        int numEvenSum = 1;
        int numOddSum = 0;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum % 2 == 1) {
                count += numEvenSum;
                numOddSum++;
            } else {
                count += numOddSum;
                numEvenSum++;
            }
        }
        return (int) (count % 1000000007);
    }
}