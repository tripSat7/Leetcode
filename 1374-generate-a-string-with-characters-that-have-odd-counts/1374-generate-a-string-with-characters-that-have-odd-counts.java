class Solution {
    public String generateTheString(int n) {
        String res = "";
        if(n%2!=0){
            res = res + generate(n);
        }else{
            res = res + generate(n-1)+"b"; 
        }
        
        return res;
    }
    
    public static String generate(int n){
        StringBuilder res = new StringBuilder();
        for(int i = 0;i<n;i++){
            res.append('a');
        }
        
        return res.toString();
    }
}