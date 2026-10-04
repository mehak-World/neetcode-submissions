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
    public int goodNodes(TreeNode root) {
        return helper(root, Integer.MIN_VALUE);
    }

    public int helper(TreeNode root, int maxVal){
        if(root == null) return 0;

        int cnt = 0;
        int newMax = maxVal;

        if(root.val >= maxVal){
            cnt++;
            newMax = root.val;
        }

        cnt += helper(root.left, newMax);
        cnt += helper(root.right, newMax);

        return cnt;
    }
}
