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
    int total  = 0;
    public int sumRootToLeaf(TreeNode root) {
        helper(root, new StringBuilder());
        return total;
    }
    
    private void helper(TreeNode root, StringBuilder sb){
        if (root == null)return;
        
        sb.append(root.val);
        int size = sb.length();
        
        if (root.left == null && root.right == null){
            total += Integer.parseInt(sb.toString(), 2);
            return;
        }
        helper(root.left, sb);
        sb.setLength(size);
        helper(root.right, sb);
        
    }
}