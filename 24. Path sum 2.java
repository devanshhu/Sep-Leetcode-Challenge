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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList();
        helper(root, targetSum, new ArrayList(), result);
        return result;
    }
    void helper(TreeNode node, int target, List<Integer> list, List<List<Integer>> result){
        if(node == null) return;
        list.add(node.val);
        if(node.left == null && node.right == null){
            if(target == node.val) result.add(new ArrayList(list));
            list.remove(list.size()-1);
            return;
        }
        
        helper(node.left, target - node.val, list, result);
        helper(node.right, target - node.val, list, result);
        list.remove(list.size()-1);
    }
}