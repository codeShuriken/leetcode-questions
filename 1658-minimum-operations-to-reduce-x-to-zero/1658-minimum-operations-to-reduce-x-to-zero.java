class Solution {
    public int minOperations(int[] nums, int x) {
        int totalSum = -x;
        for (int num: nums)totalSum += num;
        if (totalSum == 0)return nums.length;
        int sum = 0, res = Integer.MIN_VALUE;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        
        for (int i = 0; i < nums.length; ++i){
            sum += nums[i];
            if (map.containsKey(sum - totalSum)) {
                res = Math.max(res, i - map.get(sum-totalSum));
            }
            map.put(sum, i);
        }
        return res == Integer.MIN_VALUE ? -1 : nums.length - res;
    }
}