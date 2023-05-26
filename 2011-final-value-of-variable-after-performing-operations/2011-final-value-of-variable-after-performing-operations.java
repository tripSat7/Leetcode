class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int x=0;
        List<String> inc = new ArrayList<String>(Arrays.asList("X++","++X"));
        List<String> dec = new ArrayList<String>(Arrays.asList("X--","--X"));
        for(int i=0;i<operations.length;i++){
            if(inc.contains(operations[i])){
                x=++x;
            }
            if(dec.contains(operations[i])){
                x=--x;
            }
        }
        return x;
    }
}