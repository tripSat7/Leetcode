class Solution {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int count=0,i;
        if(ruleKey.equals("type")){
            i=0;
        }else if(ruleKey.equals("color")){
            i=1;
        }else{
            i=2;
        }
        
        for(List<String> list: items){
            if(list.get(i).equals(ruleValue)){
                count++;
            }
        }
        
        return count;
    }
}