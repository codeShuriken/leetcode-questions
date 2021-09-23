class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> d = new ArrayDeque<>();
        int[] res = new int[nums.length - k + 1];
        int index = 0;
        for (int i = 0; i < nums.length; ++i){
            while (!d.isEmpty() && nums[d.peekLast()] <= nums[i])d.pollLast();
            while (!d.isEmpty() && i - d.peekFirst() >= k)d.pollFirst();
            d.offer(i);
            if (i - k + 1 >= 0)
                res[index++]  = nums[d.peekFirst()];
        }
        return res;
    }
}