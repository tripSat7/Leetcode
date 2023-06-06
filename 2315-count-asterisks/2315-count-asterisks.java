class Solution {
    public int countAsterisks(String s) {
        int counter= 0, count = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='|'){
                if(counter==0){
                    counter++;
                }else{
                    counter--;
                } 
            }
            if(s.charAt(i)=='*'&&counter==0){
                count++;
            }
        }
        
        return count;
    }
}