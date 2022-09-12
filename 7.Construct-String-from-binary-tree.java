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
    public String tree2str(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        helper(root, sb);
        return sb.substring(1,sb.length()-1).toString();    
    }
    void helper(TreeNode node, StringBuilder sb ){
        if(node == null) return;
        sb.append("(");
        sb.append(node.val);
        if(node.left == null && node.right != null){
            sb.append("()");
        }
        helper(node.left, sb);
        helper(node.right, sb);
        sb.append(")");
     }
}