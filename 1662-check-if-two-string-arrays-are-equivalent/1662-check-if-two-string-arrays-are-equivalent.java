class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        
        StringBuilder s1=new  StringBuilder("");
        StringBuilder s2=new  StringBuilder("");
        for(int i=0;i<word1.length;i++){
            s1.append(word1[i]);
        }
        for(int j=0;j<word2.length;j++){
            s2.append(word2[j]);
        }
        return s1.toString().equals(s2.toString());
    }
}