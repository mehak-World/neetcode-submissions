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
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return maxSum;
    }

    public int helper(TreeNode root){
        if(root == null) return 0;

        int maxLeft = helper(root.left);
        int maxRight = helper(root.right);

        int ans = Math.max(maxLeft, Math.max(maxRight, maxLeft + maxRight)) + root.val;
        maxSum = Math.max(maxSum, Math.max(root.val, ans));

        return root.val + Math.max(0, Math.max(maxLeft, maxRight));
    }
}
