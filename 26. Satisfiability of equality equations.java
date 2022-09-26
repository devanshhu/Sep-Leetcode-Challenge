class Solution {
    int[] parent;
    int[] rank;
    public boolean equationsPossible(String[] equations) {
        parent = new int[26];
        rank = new int[26];
        for(int i=0;i<26;i++){
            parent[i] = i;
            rank[i] = 1;
            
        }
        
        for(String eqn : equations){
            if(eqn.charAt(1) == '='){
                union( eqn.charAt(0)-'a', eqn.charAt(3)-'a');
            }
        }
        
        for(String eqn : equations){
            if(eqn.charAt(1)  =='!'){
                int lx = find(eqn.charAt(0)-'a');
                int ly = find(eqn.charAt(3)-'a');
                if(lx == ly) return false;
            }
        }
        return true;
    }
    int find(int x){
        if(parent[x] == x) return parent[x];
        return parent[x] = find(parent[x]);
    }
    void union(int x, int y){
        int lx = find(x);
        int ly = find(y);
        
        if(lx != ly){
            if(rank[lx] > rank[ly]){
                parent[ly]= lx;
            }else if(rank[lx] < rank[ly]){
                parent[lx]= ly;
            }else{
                parent[lx] = ly;
                rank[ly]++;
            }
        }
    }
}
