class Solution {
    public boolean isPalindrome(String s) {
        char ch[] = s.toLowerCase().toCharArray();
        int i=0, j=ch.length-1;
        while(i<j){
            // System.out.println(ch[i]>='0');

            while(!((ch[i]>='a' && ch[i]<='z')||(ch[i]>='0' && ch[i]<='9')) && i<j){
                i++;
            }
            while(!((ch[j]>='a' && ch[j]<='z')||(ch[j]>='0' && ch[j]<='9')) && i<j){
                j--;
            }
            System.out.println(ch[i]+"::"+ch[j]);
            if(!(ch[i]==ch[j])){
                return false;
            }
            i++;j--;
        }
        return true;
    }
}