class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character,String> map1 = new HashMap<>();
        HashMap<String,Character> map2 = new HashMap<>();
        String []arr = s.split(" ");
        if(arr.length!=pattern.length()){
            return false;
        }
        for(int i=0;i<arr.length;i++){
            char c = pattern.charAt(i);
            
            if(map1.containsKey(c) && !map1.get(c).equals(arr[i])){
                return false;
            }
            if(map2.containsKey(arr[i]) && !map2.get(arr[i]).equals(c)){
                return false;
            }
            map1.put(c,arr[i]);
            map2.put(arr[i],c);
        }
        return true;
    }
}