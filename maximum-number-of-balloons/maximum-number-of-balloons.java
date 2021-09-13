class Solution {
    public int maxNumberOfBalloons(String text) {
        int count[] = new int[26];
        for (char c : text.toCharArray()){
            count[c - 'a']++;
        }
        
        int max = Integer.MAX_VALUE;
        max  = Math.min(max, count[1]);
        max  = Math.min(max, count[0]);
        max  = Math.min(max, count[11]/2);
        max  = Math.min(max, count[14]/2);
        max  = Math.min(max, count[13]);

        return max;
        
    }
}