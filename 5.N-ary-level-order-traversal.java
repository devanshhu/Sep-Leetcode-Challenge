/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        Queue<Node> q = new LinkedList();
        List<List<Integer>> list  = new LinkedList();
        if(root == null) return list;
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> tmp = new LinkedList();
            for(int i=0;i<size;i++){
                Node node = q.remove();
                tmp.add(node.val);
                for(int j =0; j< node.children.size();j++){                    
                    q.add(node.children.get(j));
                }
            }
            list.add(tmp);
            
        }
        return list;
    }
}