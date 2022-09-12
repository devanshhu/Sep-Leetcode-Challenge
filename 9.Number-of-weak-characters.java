class Solution {
    public int numberOfWeakCharacters(int[][] props) {
        int ans =0, max =0;
        Arrays.sort(props , (a,b) -> a[0] == b[0] ? a[1] - b[1] : (b[0]- a[0]));
        for(int i=0;i< props.length;i++){
                if( props[i][1] < max) ans++;
                else max = props[i][1];
            
        }
        return ans;
    }
}