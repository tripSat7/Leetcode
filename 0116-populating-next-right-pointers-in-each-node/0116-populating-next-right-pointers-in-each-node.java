/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root == null){
            return root;
        }
        
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        List<Node> arr = new ArrayList<>();
        List<List<Node>> res = new ArrayList<>();
        
        while(!q.isEmpty()){
            Node temp = q.poll();
            
            if(temp != null){
                arr.add(temp);
                if(temp.left != null){
                    q.add(temp.left);
                }
                
                if(temp.right != null){
                    q.add(temp.right);
                }
                
            }
            else{
                List<Node> copy = new ArrayList<>(arr);
                res.add(copy);
                arr.clear();
                
                if(!q.isEmpty()){
                    q.add(null);
                }
            }
        }
        
        for(List<Node> list : res){
            Node temp = list.get(0);
            for(int i = 1; i < list.size(); i++){
                temp.next = list.get(i);
                temp = temp.next;
            }
            temp.next = null;
        }
        
        return root;
    }
}