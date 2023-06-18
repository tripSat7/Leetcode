class Solution {
    public int lengthOfLastWord(String s) {
        String arr[] = s.split(" ");
        for(String s1: arr){
            System.out.print("{"+s1+"}");
        }
        
        return arr[arr.length-1].length();
    }
}