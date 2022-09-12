class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        return helper(tokens, 0, tokens.length -1, power,0);
    }
    
    int helper(int[] arr, int i, int j, int power, int score){
        if( i > j) return score;
        int max = score;
        if(arr[i] <= power)
            max = Math.max(max, helper(arr,i+1,j,power- arr[i], score+1));
        else if(score >= 1)
            max = Math.max(max, helper(arr, i, j-1, power+ arr[j], score-1));
        
        return max;
      }
    
//         Iterative
//         public int bagOfTokensScore(int[] tokens, int power) {
//         Arrays.sort(tokens);
//         int i= 0, j = tokens.length-1, score=0, ans=0;
//         while(i <= j){
//             if(power >= tokens[i]){
//                 score++;
//                 power -= tokens[i];
//                 i++;
//                 ans = Math.max(ans, score);
//             }else if(power < tokens[i] && score > 0){
//                     power += tokens[j];
//                     score--;
//                     j--;
                
//             }else return ans;
            
//         }
//         return ans;
//      }
}