class Solution {
    public int missingNumber(int[] nums) {
        int i = 0;
        while (i < nums.length) {
          if (nums[i] < nums.length && i != nums[i])
            swap(nums, i, nums[i]);
          else
            i++;
        }

        // find the first number missing from its index, that will be our required number
        for (i = 0; i < nums.length; i++)
          if (nums[i] != i)
            return i;

        return nums.length;
    }
    
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
      }
}