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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if(root == null) return "";

        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        sb.append(root.val + ",");

        while(!q.isEmpty()){
            TreeNode curr = q.remove();
            if(curr.left != null){
                q.add(curr.left);
                sb.append(curr.left.val + ",");
            }
            else{
                sb.append("#,");
            }
            if(curr.right != null){
                q.add(curr.right);
                sb.append(curr.right.val + ",");
            }
            else{
                sb.append("#,");
            }
        }

        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb.toString());
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length() == 0) return null;
        String[] arr = data.split(",");
        Queue<TreeNode> q = new LinkedList();

        if(arr.length == 0) return null;

        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        q.add(root);

        int i = 1;
        while(!q.isEmpty()){
            TreeNode curr = q.remove();

            String left = arr[i];
            String right = arr[i+1];

            if(left.equals("#")){
                curr.left = null;
            }
            else{
                curr.left = new TreeNode(Integer.parseInt(left));
                q.add(curr.left);
            }
            if(right.equals("#")){
                curr.right = null;
            }
            else{
                curr.right = new TreeNode(Integer.parseInt(right));
                q.add(curr.right);
            }
            i += 2;
        }

        return root;
    }
}
