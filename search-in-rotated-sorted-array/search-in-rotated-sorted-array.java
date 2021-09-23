class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length-1;
        while (left < right){
            int mid = left + (right - left)/2;
            if (nums[mid] > nums[right]){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        
        int offset = left;
        int n = nums.length;
        
        left = 0;
        right = nums.length - 1;
        while (left <= right){
            int mid = left + (right - left)/2;
            int realMid = (mid + offset) % n;
            if (nums[realMid] == target)
                return realMid;
            else if (nums[realMid] < target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return -1;
    }
}