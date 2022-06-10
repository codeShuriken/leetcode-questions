class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0)
            return 0;
        
        Map<Character, Integer> map = new HashMap<>();
        int start = 0, end = 0, count = 0, max  = 0;
        
        while (end < s.length()) {
            char c = s.charAt(end);
            map.put(c, map.getOrDefault(c, 0) + 1);
            
            while (map.get(c) > 1) {
                char ch = s.charAt(start);
                if (map.get(ch) == 1)
                    map.remove(ch);
                else
                    map.put(c, map.getOrDefault(c, 0) - 1);
                ++start;
            }
            
            max = Math.max(max, end - start + 1);
            ++end;
        }
        
        return max;
    }
}