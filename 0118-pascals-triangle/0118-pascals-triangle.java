class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> n1 = new ArrayList<>();
        n1.add(1);
        res.add(n1);
        if(numRows==1){
            return res;
        }
        List<Integer> n2 = new ArrayList<>();
        n2.add(1);
        n2.add(1);
        res.add(n2);
        if(numRows==2){
            return res;
        }
        for(int i=3;i<=numRows;i++){
            List<Integer> n = new ArrayList<>();
            n.add(1);
            for(int j=1;j<i-1;j++){
                int s = res.get(i-2).get(j)+res.get(i-2).get(j-1);
                n.add(s);
            }
            n.add(1);
            res.add(n);
        }
        System.out.println(res);
        return res;
    }
}