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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null)return root == subRoot;
        boolean isSubTree = isSubTreeUtil(root, subRoot);
        return isSubTree ? true : isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
    
    private boolean isSubTreeUtil(TreeNode root, TreeNode subRoot){
        if (root == null || subRoot == null)return root == subRoot;
        if (root.val != subRoot.val)return false;
        return isSubTreeUtil(root.left, subRoot.left) && isSubTreeUtil(root.right, subRoot.right);
    }
}