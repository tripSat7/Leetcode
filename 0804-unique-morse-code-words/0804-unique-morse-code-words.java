class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String chars[] = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        String res[] =new String[words.length];
        HashSet<String> set = new HashSet<String>();
        
        for(String s:words){
            StringBuilder sb = new StringBuilder();
            for(int i = 0;i<s.length();i++){
                sb.append(chars[s.charAt(i)-'a']);
            }
            set.add(sb.toString());
        }
        
        
        return set.size();
    }
}