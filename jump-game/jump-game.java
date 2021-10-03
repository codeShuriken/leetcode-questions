class Solution {
    public boolean canJump(int[] nums) {
        int maxJump = 0;
        int curMaxJump = 0;
        for (int i = 0; i < nums.length && curMaxJump >= i; ++i){
            curMaxJump = Math.max(curMaxJump, i + nums[i]);
            if (curMaxJump >= nums.length - 1)
                return true;
        }
        
        return false;
    }
}