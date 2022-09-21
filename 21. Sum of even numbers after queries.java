class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] qu) {
        int sum = Arrays.stream(nums).filter( i -> (i&1) == 0 ).sum();
        int ans[] = new int[qu.length];
        for(int i=0;i< qu.length;i++ ){
            int val = qu[i][0];
            int index = qu[i][1];
            if(nums[index] % 2 == 0){
                if(val % 2 == 0){
                    nums[index] += val;
                    sum+= val;
                }else{
                    sum -= nums[index];
                    nums[index] += val;
                }
            }else{
                if(val % 2 == 0){
                    nums[index] += val;
                }else{
                    nums[index] += val;
                    sum += nums[index];
                }
            }
            ans[i]= sum;
        
        }
        return ans;
    }
}
