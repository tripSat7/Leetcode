class DisjointSet{
    List<Integer> size = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    
    public DisjointSet(int n) {
        for (int i = 0; i <= n; i++) {
            parent.add(i);
            size.add(1);
        }
    }
    
    public int findUltParent(int node){
       
        if(node == parent.get(node)){
            return node;
        }
        
        int ulp = findUltParent(parent.get(node));
        parent.set(node, ulp);
        return parent.get(node);
    } 
    
    public void unionBySize(int u, int v){
        int ultP_u = findUltParent(u);
        int ultP_v = findUltParent(v);
        
        if(ultP_u == ultP_v){
            return; 
        }
        
        if(size.get(ultP_u) < size.get(ultP_v)){
            parent.set(ultP_u, ultP_v);
            size.set(ultP_v, size.get(ultP_v) + size.get(ultP_u));
        }
        else{
            parent.set(ultP_v, ultP_u);
            size.set(ultP_u, size.get(ultP_v) + size.get(ultP_u));
        }
    }
}

class Solution {
    public int makeConnected(int n, int[][] connections) {
        
        DisjointSet ds = new DisjointSet(n);
        int cntExtras = 0;
        int m = connections.length;
        for (int i = 0; i < m ; i++) {
            int u = connections[i][0];
            int v = connections[i][1];
            
            if (ds.findUltParent(u) == ds.findUltParent(v)) {
                cntExtras++;
            } else {
                ds.unionBySize(u, v);
            }
        }
        
        int components = 0;
        for (int i = 0; i < n; i++) {
            if (ds.parent.get(i) == i){
                components++;
            } 
        }
        
        int res = components - 1;
        if (cntExtras >= res){
            return res;
        } 
        
        return -1;
    }
}