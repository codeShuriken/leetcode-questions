class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        final Map<Integer, Integer> countMap = new HashMap<>();
        
        for (int a : arr)countMap.put(a, countMap.getOrDefault(a, 0) + 1);
        List<Map.Entry<Integer, Integer>> entries = new ArrayList<>();
        for (var entry : countMap.entrySet()){
            entries.add(entry);
        }
        
        Collections.sort(entries, (a, b)-> a.getValue() - b.getValue());
        
        int countUnique = entries.size();
        int index = 0;
        
        while (index < entries.size() && k > 0){
            if (k - entries.get(index).getValue() >= 0){
                k -= entries.get(index++).getValue();
                --countUnique;
            }else{
                k = 0;
            }   
        }
        
        return countUnique;
    }
}