class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i){
            int num = Math.abs(nums[i]) - 1;
            if (nums[num] < 0)res.add(num+1);
            else{
                nums[num] = -nums[num];
            }
        }
        return res;
    }
}