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
        return helper(root, subRoot);
    }

    public boolean helper(TreeNode root, TreeNode subRoot){
        if((root == null && subRoot == null) || subRoot == null) return true;
        if(root == null) return false;

        if(root.val == subRoot.val){
            if(isSameTree(root.left, subRoot.left) && isSameTree(root.right, subRoot.right)) return true;
        }

        return helper(root.left, subRoot) || helper(root.right, subRoot);
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;

        if(p.val != q.val) return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
