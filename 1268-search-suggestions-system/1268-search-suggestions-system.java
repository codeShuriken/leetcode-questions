class Solution {
    TrieNode root = new TrieNode();
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        constructTrie(products);
        List<List<String>> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (char c : searchWord.toCharArray()) {
            sb.append(c);
            res.add(searchRes(sb.toString()));
        }
        return res;
    }
    
    private List<String> searchRes(String s){
        TrieNode node = root;
        for (char c : s.toCharArray()) {
            if (node.children[c-'a'] == null)return new ArrayList<>();
            node = node.children[c-'a'];
        }
        List<String> res = new ArrayList<>();
        while (!node.pq.isEmpty() && res.size() < 3)res.add(node.pq.poll());
        return res;
    }
    
    private void constructTrie(String[] products) {
        for (String product : products) {
            TrieNode node = root;
            for (char c : product.toCharArray()) {
                if (node.children[c-'a'] == null){
                    node.children[c-'a'] = new TrieNode();
                }
                node = node.children[c-'a'];
                node.pq.add(product);
            }
        }
    }
}

class TrieNode {
    TrieNode[] children = new TrieNode[26];
    PriorityQueue<String> pq = new PriorityQueue<>((a,b)->a.compareTo(b));
}