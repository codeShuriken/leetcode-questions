class Solution {
    String[] letters = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0)return new ArrayList<>();
        List<String> res = new ArrayList<>();
        dfs(res, digits, new StringBuilder(), 0);
        return res;
    }
    
    private void dfs(List<String> res, String digits, StringBuilder sb, int index){
        if (index == digits.length()){
            res.add(sb.toString());
            return;
        }
        
        int len = sb.length();
        char[] chars = letters[digits.charAt(index) - '0'].toCharArray();
        for (char c : chars){
            sb.append(c);
            dfs(res, digits, sb, index+1);
            sb.setLength(len);
        }
    }
}