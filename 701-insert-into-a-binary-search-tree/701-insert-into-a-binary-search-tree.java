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
    
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null)return new TreeNode(val);
        insertIntoBST1(root, val);   
        return root;
    }
    
    public TreeNode insertIntoBST1(TreeNode root, int val) {
        if (root == null){
            return null;
        }
        if (root.left == null && root.val > val){
            root.left = new TreeNode(val);
            return root;
        }
        if (root.right == null && root.val < val){
            root.right = new TreeNode(val);
            return root;
        }
        
        if (val < root.val)
            return insertIntoBST1(root.left, val);
        else
            return insertIntoBST1(root.right, val);
    }
}