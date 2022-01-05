class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        dfs(s, res, 0, new ArrayList<>());
        return res;
    }
    
    private void dfs(String s, List<List<String>> res, int index, List<String> temp){
        if (index == s.length()){
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = index; i < s.length(); ++i){
            if (isPalindrome(s, index, i)){
                temp.add(s.substring(index, i+1));
                dfs(s, res, i+1, temp);
                temp.remove(temp.size()-1);
            }
        }
    }
    
    
    private boolean isPalindrome(String s, int i, int j){
        while (i < j){
            if (s.charAt(i++) != s.charAt(j--))return false;
        }
        return true;
    }
}