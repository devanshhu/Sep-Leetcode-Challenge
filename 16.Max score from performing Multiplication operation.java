class Solution {
    public int maximumScore(int[] nums, int[] multipliers) {
        int[][] dp = new int[multipliers.length+1][multipliers.length +1];
        // for(int[] x: dp) Arrays.fill(x, -1);
        return helper(nums, multipliers, 0,  0,dp);
        // return 0;
    }
    
    int helper(int[] ns, int[] ms , int left, int mi, int[][] dp){
        if(mi == ms.length){
            return 0;
        }
        if(dp[left][mi] != 0) return dp[left][mi];
        int right = ns.length -1- (mi - left);
        int start = ns[left] * ms[mi] + helper(ns, ms, left+1, mi+1,dp);
        int end = ns[right] * ms[mi] + helper(ns,ms, left, mi+1,dp);
        return dp[left][mi] = Math.max(start, end);
    }
}