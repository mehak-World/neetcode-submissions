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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap();
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }

        int n = preorder.length;

        return helper(preorder, inorder, 0, n-1, 0, n-1, map);
    }

    public TreeNode helper(int[] preorder, int[] inorder, int pre_start, int pre_end, int in_start, int in_end, Map<Integer, Integer> map){
        if(pre_start > pre_end || in_start > in_end) return null;

        TreeNode root = new TreeNode(preorder[pre_start]);
        int idx = map.get(root.val);
        int left_els = idx - in_start;

        root.left = helper(preorder, inorder, pre_start+1, pre_start+left_els, in_start, idx-1, map);

        root.right = helper(preorder, inorder, pre_start+left_els+1, pre_end, idx+1, in_end, map);

        return root;
    }
}
