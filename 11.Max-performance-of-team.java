class Solution {
    class Pair{
        int e;
        int s;
        Pair(){}
        Pair(int x, int y){
            e = x;
            s = y;
        }
        @Override
        public String toString(){
            return e+"";
        }
    }
    public int maxPerformance(int n, int[] speed, int[] eff, int k) {
        List<Pair> list = new LinkedList();
        int MOD = (int) (1e9 + 7);
        for(int i=0;i<n;i++){
            list.add(new Pair(eff[i], speed[i]));
        }
        
        Collections.sort(list, (a,b) -> b.e - a.e);
        PriorityQueue<Integer> pq = new PriorityQueue<>(k, (a, b) -> a - b);
        long res = Long.MIN_VALUE, totalSpeed = 0;
        
        for(Pair p: list){
            if(pq.size() == k) totalSpeed -= pq.poll();
            pq.add(p.s);
            totalSpeed  = totalSpeed + p.s;
            res = Math.max(res, (totalSpeed* p.e));
        }

        return (int)(res%MOD);
    }
}


