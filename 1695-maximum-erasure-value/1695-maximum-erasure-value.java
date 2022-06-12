class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int maxScore = 0, curScore = 0;
        Set<Integer> set = new HashSet<>();
        int start = 0, end = 0;
        for (;end< nums.length;){
            if (set.contains(nums[end])){
                curScore -= nums[start];
                set.remove(nums[start++]);
            }else{
                set.add(nums[end]);
                curScore += nums[end++];
                maxScore = Math.max(maxScore, curScore);
            }
        }
        return maxScore;
    }
}