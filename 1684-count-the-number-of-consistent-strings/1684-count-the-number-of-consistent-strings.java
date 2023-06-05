class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        Set<Character> allowedChar = new HashSet<Character>();
        for(char c:allowed.toCharArray()){
            allowedChar.add(c);
        }
        
        int count=words.length;
        for(String s:words){
            for(char c:s.toCharArray()){
                if(!allowedChar.contains(c)){
                    count--;
                    break;
                }
            }
        }
        
        return count;
    }
}