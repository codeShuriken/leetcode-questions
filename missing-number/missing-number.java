class Solution {
    public int missingNumber(int[] nums) {
        for (int i = 0; i < nums.length;){
          int j = nums[i] - 1;
            if (nums[i] != 0 && nums[j] != nums[i]){
                swap(nums, i, j);
            } else{
                ++i;
            }
        }
        
        for (int i = 0; i < nums.length; ++i){
            if (i+1 != nums[i]) return i+1;
        }
        
        return 0;
    }
    
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i]  = nums[j];
        nums[j]  = temp;
    }
}