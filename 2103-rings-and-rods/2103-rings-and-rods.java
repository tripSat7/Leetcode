class Solution {
    public int countPoints(String rings) {
        char c[] = rings.toCharArray();
        boolean green[] = new boolean[10];
        boolean red[] = new boolean[10];
        boolean blue[] = new boolean[10];
        int count = 0;
        
        for(int i = 0;i<c.length;i=i+2){
            if(c[i]=='B'){
                blue[c[i+1]-'0'] = true;
            }
            if(c[i]=='G'){
                green[c[i+1]-'0'] = true;
            }
            if(c[i]=='R'){
                red[c[i+1]-'0'] = true;
            }
        }
        
        for(int i = 0;i<red.length;i++){
            if(red[i]==true && blue[i]==true && green[i]==true){
                count++;
            }
        }
        
            
        return count;
    }
}