class Solution {
    public int numberOfSubstrings(String s) {
        int a = -1, b = -1, c = -1, count = 0;
        char ch[] = s.toCharArray();
        for(int i = 0; i < ch.length; i++){
            if(ch[i] == 'a' ){
                a = i;  
            } 
            if(ch[i] == 'b'){
                b = i;
            } 
            if(ch[i] == 'c'){
                c = i;  
            } 
            
            int min = minValue(a,b,c);
            if(min == -1){
                continue;
            }
            
            count = count + min + 1;
        }
        
        return count;
    }
    
    public int minValue(int a, int b, int c){
        
        return Math.min(Math.min(a,b),c);
    }
}