class Solution {
    public String simplifyPath(String path) {
        
        Stack<String> stk = new Stack<>();
        char ch[] = path.toCharArray();
        stk.push("/");
        for(int i = 1; i < ch.length; i++){
            if(ch[i]=='/'){
                if(!stk.peek().equals("/") && i+1<ch.length){
                    stk.push(String.valueOf(ch[i]));                
                }
            }
            else{
                String temp = "";
                while(i<ch.length && ch[i]!='/'){
                    temp = temp + String.valueOf(ch[i]);
                    i++;
                }
                if(temp.equals("..")){
                    if(stk.size()>2){
                        stk.pop();
                        stk.pop();   
                    }
                }
                else if(temp.equals(".")){
                    if(stk.size()>1){
                        stk.pop();   
                    }
                }
                else{
                    stk.push(temp);
                }
                i--;
            }
        }
        
        if(stk.size()>2 && stk.peek().equals("/")){
            stk.pop();
        }
        
        StringBuilder sb = new StringBuilder();
        while (!stk.isEmpty()) {
            sb.insert(0,stk.pop());
        }
        return sb.toString();
    }
}