class RandomizedSet {
    private Random rand;
    private Map<Integer, Integer> map;
    private List<Integer> nums;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        rand  = new Random();
        map = new HashMap<>();
        nums = new ArrayList<>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val))return false;
        
        int index = nums.size();
        map.put(val, index);
        
        nums.add(val);
        
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val))return false;
        
        int index = map.get(val);
        int lastVal = nums.get(nums.size()-1);
        Collections.swap(nums, index, nums.size()-1);
        nums.remove(nums.size()-1);
        
        map.remove(val);
        if (lastVal != val)map.put(lastVal, index);
        
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        int index = rand.nextInt(nums.size());
        return nums.get(index);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */