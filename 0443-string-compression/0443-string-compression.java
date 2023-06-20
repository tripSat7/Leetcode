class Solution {
    public int compress(char[] chars) {
        if(chars.length==1){
            return 1;
        }
        
        int i=0, j=i+1, c=0;
        while(j<chars.length){
            if(chars[i]!=chars[j]){
                int n = j-i;
                System.out.println(i+":"+j+":"+c);
                if(n==1){
                    chars[c]=chars[i];
                    c++;
                }                
                else{
                    chars[c] = chars[i];
                    c++;
                    if(n<10){
                        chars[c] = (char)('0'+n);
                        c++;
                    }
                    else{
                        String s = String.valueOf(n);
                        for(char ch:s.toCharArray()){
                            chars[c]=ch;
                            c++;
                        }
                    }
                }
                i=j;
            }   
            j++;
        }
        
        chars[c] = chars[i];
        int n = j-i;
        if(n==1){
            c++;
        }
        else if(n<10){
            chars[c+1] = (char)('0'+n);
            c+=2;
        }
        else{
            c++;
            String s = String.valueOf(n);
            for(char ch:s.toCharArray()){
                chars[c]=ch;
                c++;
            }
        }
        
        return c;
    }
}