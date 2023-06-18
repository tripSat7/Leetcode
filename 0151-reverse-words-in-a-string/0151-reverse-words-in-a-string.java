class Solution {
    public String reverseWords(String s) {
        String arr[] = s.split(" ");
        StringBuilder sb = new StringBuilder();
        
        for(int i=arr.length-1;i>0;i--){
            if(!arr[i].equals("")){
                sb.append(arr[i]);
                sb.append(" ");
            }   
        }
        if(!arr[0].equals("")){
            sb.append(arr[0]);
        }
        int j=sb.length()-1;
        while(true){
            if(sb.charAt(j)!=' '){
                break;
            }
            j--;
        }
        String res=sb.substring(0,j+1);
        return res;
    }
}