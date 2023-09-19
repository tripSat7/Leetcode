class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        
        HashMap<String, List<String>> map = new HashMap<>();
        
        for(String s : strs){
            char ch[] = s.toCharArray();
            Arrays.sort(ch);
            String sortedWord = new String(ch);
            
            if(!map.containsKey(sortedWord)){
                map.put(sortedWord, new ArrayList<>());
            }
            map.get(sortedWord).add(s);
        }
        
        return new ArrayList<>(map.values());
    }
}