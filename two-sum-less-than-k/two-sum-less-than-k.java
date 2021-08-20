class Solution {
    public int twoSumLessThanK(int[] nums, int k) {
        Arrays.sort(nums);
        int maxNum  = -1;
        
        int left = 0, right = nums.length - 1;
        while (left < right){
            int sum  = nums[left] + nums[right];
            if (sum < k){
                maxNum  = Math.max(maxNum, sum);
                left++;
            }else{
                right--;
            }
        }
        
        return maxNum;
    }
}