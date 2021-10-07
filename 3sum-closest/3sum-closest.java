class Solution {
    public int threeSumClosest(int[] nums, int target) {
       if (nums == null || nums.length < 3)return 0;
        Arrays.sort(nums);
       int closest = nums[0] + nums[1] + nums[nums.length-1];
        
        for (int i = 0; i < nums.length-2; ++i){
            if (i == 0 || nums[i] != nums[i-1]){
                int start = i+1, end = nums.length-1;
                while (start < end){
                    int curSum = nums[i] + nums[start] + nums[end];
                    
                    if (curSum == target)
                        return curSum;
                    else if (curSum < target)
                        start++;
                    else
                        end--;
                    
                    if (Math.abs(curSum - target) < Math.abs(closest - target)){
                        closest = curSum;
                    }
                }
            }
        }
        return closest;
    }
}