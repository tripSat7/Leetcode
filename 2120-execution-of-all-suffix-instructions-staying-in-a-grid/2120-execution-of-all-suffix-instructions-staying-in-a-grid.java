class Solution {
    public int[] executeInstructions(int n, int[] startPos, String s) {
     
        int res[] = new int[s.length()];
        
        for(int i=0; i<s.length();i++){
            res[i] = helper(s.substring(i), startPos, n);
        }
        
        return res;
    }
    
    public int helper(String s, int[] startPos, int n){
        int c = 0;
        
        int []sp = new int[2];
        sp[0] = startPos[0];
        sp[1] = startPos[1];
        
        for(char ch : s.toCharArray()){
            if(ch =='L'){
                sp[1]--;
            }
            else if(ch =='R'){
                sp[1]++;
            }
            else if(ch == 'D'){
                sp[0]++;
            }
            else
            {
                sp[0]--;
            }
            
            if(sp[0]>=n || sp[1]>=n || sp[0]<0 || sp[1]<0){
                break;
            }
            c++;   
        }
        
        return c;
        
    }
}