class Pair{
    String first;
    int second;
    
    Pair(String first, int second){
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord, 1));
        
        for(int i = 0; i< wordList.size(); i++){
            set.add(wordList.get(i));
        }
        
        set.remove(beginWord);
        
        while(!q.isEmpty()){
            String word = q.peek().first;
            int steps = q.peek().second;
            q.remove();
            
            if(word.equals(endWord)){
                return steps;
            }
            
            for(int i = 0; i < word.length(); i++){
                for(char ch = 'a'; ch <= 'z'; ch++){
                    char trial[] = word.toCharArray();
                    trial[i] = ch;
                    String repString = new String(trial);
                    
                    if(set.contains(repString) == true){
                        set.remove(repString);
                        q.add(new Pair(repString, steps+1));
                    }
                }
            }   
        }
        
        return 0;
    }
}