class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int n = p.length();
        List<Integer> res = new ArrayList<>();
        int freq[] = new int[26];
        int l = 0, r = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(char ch : p.toCharArray()){
            map.put(ch-'a', map.getOrDefault(ch-'a',0)+1);
        }

        while(r < s.length()){
            freq[s.charAt(r) - 'a']++;

            if(r - l == n - 1){
                boolean isAna = true;
                
                for(int i = 0; i < 26; i++){
                    //System.out.println(r+"||"+i+"::"+freq[i]);
                    if(map.containsKey(i) && freq[i] != map.get(i)){
                        isAna = false;
                        break;
                    }
                }
                if(isAna){
                    res.add(l);
                }
            }
            else if(r - l > n-1){
                freq[s.charAt(l) - 'a']--;
                l++;
                boolean isAna = true;
                for(int i = 0; i < 26; i++){
                    if(map.containsKey(i) && freq[i] != map.get(i)){
                        isAna = false;
                        break;
                    }
                }
                if(isAna){
                    res.add(l);
                }
            }

            r++;
        }

        return res;
    }
}