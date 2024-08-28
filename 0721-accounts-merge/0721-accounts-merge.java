class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> ans = new ArrayList<>();
        int n = accounts.size();
        DSU ds = new DSU(n);
    
        Map<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            for(int j=1;j<accounts.get(i).size();j++){
                String value = accounts.get(i).get(j);
               
                if(!map.containsKey(value)){
                    map.put(value, i);
                }
                else {
                    ds.unionBySize(i, map.get(value));
                }
            }
        }

        ArrayList<String>[] mergedMail = new ArrayList[n];
        for (int i = 0; i < n; i++) mergedMail[i] = new ArrayList<String>();
        for (Map.Entry<String, Integer> it : map.entrySet()) {
            String mail = it.getKey();
            int node = ds.findPar(it.getValue());
            mergedMail[node].add(mail);
        }
        
        for (int i = 0; i < n; i++) {
            if (mergedMail[i].size() == 0) continue;
            Collections.sort(mergedMail[i]);
            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0));
            for (String it : mergedMail[i]) {
                temp.add(it);
            }
            ans.add(temp);
        }
        return ans;

        
    }
}

class DSU {
    List<Integer> size = new ArrayList<>();
    List<Integer> parents = new ArrayList<>();
    public DSU(int n){
        for(int i=0;i<=n;i++){
            size.add(1);
            parents.add(i);
        }
    }
    
    public int findPar(int node){
        if(node == parents.get(node)){
            return node;
        }
        int ultp = findPar(parents.get(node));
        parents.set(node, ultp);
        return parents.get(node);
    }
    
    public void unionBySize(int u, int v){
        int ultp_u = findPar(u);
        int ultp_v = findPar(v);
        if(ultp_u == ultp_v)
            return;
        int size_u = size.get(ultp_u);
        int size_v = size.get(ultp_v);
        
        if (size_u < size_v) {
            parents.set(ultp_u, ultp_v);
            size.set(ultp_v, size_u + size_v);
        }
        else {
            parents.set(ultp_v, ultp_u);
            size.set(ultp_u, size_u + size_v);
        }
    }
}