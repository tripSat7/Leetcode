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
            List<Integer> n = generateRow(res.get(i-2));
            res.add(n);
        }
        return res;
    }
    
    public static List<Integer> generateRow(List<Integer> prev){
        List<Integer> temp = new ArrayList<>();
        temp.add(1);
        for(int j=1;j<prev.size();j++){
            int s = prev.get(j)+prev.get(j-1);
            temp.add(s);
        }
        temp.add(1);
        return temp;
    }
}