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

class Info{
    int min;
    int max;
    boolean isBST;

    Info(int min, int max, boolean isBST){
        this.min = min;
        this.max = max;
        this.isBST = isBST;
    }
}

class Solution {
    public boolean isValidBST(TreeNode root) {
        Info info = bstHelper(root);
        return info.isBST;
    }

    public Info bstHelper(TreeNode root){
        if(root == null) return new Info(Integer.MAX_VALUE, Integer.MIN_VALUE, true);

        Info left = bstHelper(root.left);
        Info right = bstHelper(root.right);

        int min = Math.min(root.val, Math.min(left.min, right.min));
        int max = Math.max(root.val, Math.max(left.max, right.max));

        if(!left.isBST || !right.isBST) return new Info(min, max, false);

        if(root.val <= left.max || root.val >= right.min){
            return new Info(min, max, false);
        }

        return new Info(min, max, true);
    }
}
