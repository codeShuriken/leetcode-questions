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
    int index;
    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder == null || preorder.length == 0)return null;
        index = 0;
        return helper(preorder, Integer.MAX_VALUE);
    }
    
    private TreeNode helper(int[] preorder, int val){
        if (index >= preorder.length || val < preorder[index])return null;
        TreeNode node = new TreeNode(preorder[index++]);
        node.left = helper(preorder, node.val);
        node.right = helper(preorder, val);
        return node;
    }
}