class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int x=0;
        List<String> inc = new ArrayList<String>(Arrays.asList("X++","++X"));
        List<String> dec = new ArrayList<String>(Arrays.asList("X--","--X"));
        for(String s:operations){
            if(inc.contains(s)){
                x=++x;
            }
            if(dec.contains(s)){
                x=--x;
            }
        }
        return x;
    }
}