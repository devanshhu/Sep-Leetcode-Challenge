class Solution {
    public int pseudoPalindromicPaths (TreeNode root) {
        int[] ans = new int[1];
        int[] arr = new int[10];
        helper(root, arr, ans);
        return ans[0];
    }
    
    void helper(TreeNode node,int[] arr, int[] ans ){
        if(node == null) return;
            arr[node.val]++;
        if(node.left == null && node.right == null){
            if(isPal(arr)){
                ans[0]++;
            }
        }
        helper(node.left, arr, ans);
        helper(node.right, arr, ans);
        arr[node.val]--;
    }
    
    boolean isPal(int[] arr){
        int count =0;
        for(int i=0;i<10;i++)
            if(arr[i]%2 == 1) count++;
        return count < 2;
    }
    
    
}
