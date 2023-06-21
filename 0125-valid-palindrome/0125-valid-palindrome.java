class Solution {
    public boolean isPalindrome(String s) {
        char ch[] = s.toCharArray();
        int i=0, j=ch.length-1;
        while(i<j){

            while(!((ch[i]>=65 && ch[i]<=90) || (ch[i]>=97 && ch[i]<=122) ||(ch[i]>='0' && ch[i]<='9')) && i<j){
                i++;
            }
            while(!((ch[j]>=65 && ch[j]<=90) || (ch[j]>=97 && ch[j]<=122) ||(ch[j]>='0' && ch[j]<='9')) && i<j){
                j--;
            }
            System.out.println(ch[i]+"::"+ch[j]);
            if(!(Character.toLowerCase(ch[i])==Character.toLowerCase(ch[j])) || i>j){
                return false;
            }
            i++;j--;
        }
        return true;
    }
}