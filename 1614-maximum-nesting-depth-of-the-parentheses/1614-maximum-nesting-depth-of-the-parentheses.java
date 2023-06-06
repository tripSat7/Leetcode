class Solution {
    public int maxDepth(String s) {
        int max=0, count=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                count++;
            }
            if(s.charAt(i)==')'){
                count--;
            }
            if(count>max){
                max = count;
            }
        }
        return max;
    }
}