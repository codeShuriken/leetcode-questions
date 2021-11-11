class Solution {
    public int minStartValue(int[] nums) {
        if (nums == null || nums.length == 0)return 0;
        int sum = 0;
        int start = 1;
        for (int num : nums){
            sum += num;
            if (sum < 1)
                start = Math.max(start, Math.abs(sum) + 1);
        }
        
        return start;
    }
}