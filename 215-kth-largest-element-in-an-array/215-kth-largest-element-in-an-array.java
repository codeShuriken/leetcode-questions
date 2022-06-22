class Solution {
    public int findKthLargest(int[] nums, int k) {
       k = nums.length - k;
       return quickSelect(nums, k);
    }
    
    private int quickSelect(int[] nums, int k){
        int start = 0, end = nums.length-1;
        while (start <= end){
            int mid = partition(nums, start, end);
            if (mid == k)
                return nums[mid];
            else if (mid < k)
                start = mid +1;
            else 
                end = mid - 1;
        }
        
        return -1;
    }
    
    private int partition(int[] nums, int start, int end){
        int pivotIndex = start + ((int)Math.random() * (end - start + 1));
        swap(nums, start, pivotIndex);
        
        int index = start+1;
        for (int i = start +1; i <= end; ++i){
            if (nums[start] > nums[i]){
                swap(nums, index++, i);
            }
        }
        
        swap(nums, start, --index);
        
        return index;
    }
    
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}