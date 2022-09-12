class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        Set<String> list = new HashSet();
        int[] arr = new int[n];
        for(int i=1;i<10;i++){
            arr[0] = i;
            helper( arr,0,k, list);
        }
      
        return list.stream().map(i -> Integer.parseInt(i)).mapToInt(i -> i).toArray();
    }
    
    public void helper(int[] arr, int index, int diff, Set<String> list){
        if(index == arr.length-1){
            StringBuilder sb = new StringBuilder();
            for(int x: arr) sb.append(x);
            list.add( sb.toString() );
            return;
        }
        
        if( arr[index] - diff >= 0){
            arr[index + 1] = arr[index] - diff;
            helper(arr, index+1, diff, list);
            
        }
        if(arr[index] + diff < 10  ){
            arr[index+1] = arr[index] + diff;
            helper(arr, index+1, diff, list);
            
        }
        
    }
}