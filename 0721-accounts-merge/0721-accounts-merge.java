class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        
        Map<String, Integer> mapMailNode = new HashMap<>();
        int n = accounts.size();
        DisjointSet ds = new DisjointSet(n);
        
        for(int i = 0; i < n; i++){
            for(int j = 1; j < accounts.get(i).size(); j++){
                if(!mapMailNode.containsKey(accounts.get(i).get(j))){
                    mapMailNode.put(accounts.get(i).get(j), i);
                }else{
                    ds.unionBySize(i, mapMailNode.get(accounts.get(i).get(j)));
                }
            }
        }
        System.out.println(mapMailNode);
        ArrayList<String>[] mergedMail = new ArrayList[n];
        for(int i = 0; i < n; i++){
            mergedMail[i] = new ArrayList<String>();
        }
        
        for(String key : mapMailNode.keySet()) {
            String mail = key;
            int node = ds.findParent(mapMailNode.get(key));
            mergedMail[node].add(mail);
        }
        
        List<List<String>> res = new ArrayList<>();
        
        for(int i = 0; i < n; i++){
            if(mergedMail[i].size() == 0){
                continue;
            }
            
            Collections.sort(mergedMail[i]);
            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0));
            for(int j = 0; j < mergedMail[i].size(); j++){
                temp.add(mergedMail[i].get(j));
            }
            res.add(temp);
        }
        
        return res;
    }
}

class DisjointSet{
    int parent[];
    int size[];
    DisjointSet(int n){
        parent = new int[n];
        size = new int[n];
        for(int i = 0; i < n; i++){
            parent[i] = i;
            size[i] = 1;
        }
    }
    
    public int findParent(int n){
        if(n == parent[n]){
            return n;
        }
        
        int par = findParent(parent[n]);
        return par;
    }
    
    public void unionBySize(int u, int v){
        int ulp_u = findParent(u);
        int ulp_v = findParent(v);
        
        if(ulp_u == ulp_v){
            return;
        }
        
        if(size[ulp_u] < size[ulp_v]){
            parent[ulp_u] = ulp_v;
            size[ulp_v] += size[ulp_u];  
        }else{
            parent[ulp_v] = ulp_u;
            size[ulp_u] += size[ulp_v];  
        }
        
    }
}