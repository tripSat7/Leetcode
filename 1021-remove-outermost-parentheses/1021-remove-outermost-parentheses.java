class Solution {
    public String removeOuterParentheses(String s) {
        char []c = s.toCharArray();
        int lc=0,rc=0;
        StringBuilder res = new StringBuilder();
        for(int i = 0; i<c.length;i++){
    
            if(c[i]=='('){
                lc++;
                if(lc-rc>1){
                    res.append('(');
                }
            }else{
                rc++;
                if(lc-rc>0){
                    res.append(')');
                }
            }             
        }
        System.out.println(res);
        
        return res.toString();
    }
}