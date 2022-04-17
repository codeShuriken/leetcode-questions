/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private TreeNode node = new TreeNode(-1), prev = node;
    public TreeNode increasingBST(TreeNode root) {
        dfs(root);
        return prev.right;
    }
    
    private void dfs(TreeNode root) {
        if (root == null)return;
        dfs(root.left);
        node.right = new TreeNode(root.val);
        node = node.right;
        dfs(root.right);        
    }
}