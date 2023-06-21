class Solution {
    public boolean isPalindrome(String s) {
        char ch[] = s.toCharArray();
        int i=0, j=ch.length-1;
        while(i<j){

            while(!Character.isLetterOrDigit(ch[i])&&i<j){
                i++;
            }
            while(!Character.isLetterOrDigit(ch[j])&&i<j){
                j--;
            }
            //System.out.println(ch[i]+"::"+ch[j]);
            if(!(Character.toLowerCase(ch[i])==Character.toLowerCase(ch[j])) || i>j){
                return false;
            }
            i++;j--;
        }
        return true;
    }
}