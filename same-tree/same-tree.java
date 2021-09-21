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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> qe = new LinkedList<>();
        qe.offer(p);
        qe.offer(q);
        while (qe.size() > 1){
            TreeNode left = qe.poll(), right = qe.poll();
            
            if (left == null && right == null)continue;
            
            if (left == null || right == null || left.val != right.val)
                return false;
            
            qe.offer(left.left);
            qe.offer(right.left);
            qe.offer(left.right);
            qe.offer(right.right);
        }
        
        return qe.isEmpty();
    }
}