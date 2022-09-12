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
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        List<Double> ans = new LinkedList();
        while(q.size() > 0){
            int count=0;
            Double sum =0.0;
            Queue<TreeNode> tmp = new LinkedList();
            while(q.size() > 0){
                
            TreeNode elem = q.remove();
            if(elem.left != null) tmp.add(elem.left);
            if(elem.right != null) tmp.add(elem.right);
            count++;
                sum += (double)elem.val;
            }
            q = tmp;
            ans.add((double)(sum/count));
        }
        return ans;
    }
}