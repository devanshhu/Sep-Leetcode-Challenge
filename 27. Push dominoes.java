class Solution {
    public String pushDominoes(String dominoes) {
        int N = dominoes.length();
         char[] arr= new char[N+2];
        arr[0] ='L';
        arr[N+1] ='R';
        for(int i=1;i<=N;i++){
            arr[i]= dominoes.charAt(i-1);
        }
        int j=0,k=1;
        while( k < arr.length){
            while(arr[k] == '.') k++;
            solve(arr, j, k);
            j = k;
            k = j+1;
        }
        
        return String.valueOf(Arrays.copyOfRange(arr, 1,arr.length-1));
    }
    
    void solve(char[] arr, int j, int k){
        if(arr[j] == 'L' && arr[k] == 'L'){
            for(int i=j;i <k;i++){
                arr[i] = 'L';
            }
        }else if(arr[j] == 'L' && arr[k] == 'R'){
            return;
        }else if(arr[j] == 'R' && arr[k] =='L'){
            int diff = k-j;
            int mid = (j+k)/2;

            if(diff%2==0){
                // odd dots
                for(int i=j;i<mid;i++)
                    arr[i] = 'R';
                for(int i=mid+1;i<k;i++)
                    arr[i] ='L';
            }else{
                //even dots
                for(int i=j;i<=mid;i++)
                    arr[i] = 'R';
                for(int i=mid+1;i<k;i++)
                    arr[i] ='L';
}
        }else if(arr[j] =='R' && arr[k] == 'R'){
            for(int i=j;i<k;i++) arr[i] = 'R';
        }
        
    }
}
