class Solution {
    public int maxProfit(int k, int[] prices) {
        int[][][] dp = new int[prices.length][2][k+1];
        for(int[][] a:dp) for(int[] b: a) Arrays.fill(b,-1);
        return f(prices, 0,0,k,dp);
    }
    
    public int f(int[] arr, int index, int buy, int cap, int[][][] dp){
        if(cap == 0 || index == arr.length) return 0;
        if(dp[index][buy][cap] != -1) return dp[index][buy][cap];
        if(buy == 0){
            return dp[index][buy][cap] = Math.max(
                -arr[index] + f(arr, index+1, 1, cap,dp),
                f(arr, index+1, 0, cap,dp)
            );
        }else{
            return dp[index][buy][cap] = Math.max(
            arr[index] + f(arr, index+1,0, cap-1,dp),
                f(arr, index+1,1, cap,dp)
            );
        }
    }
}