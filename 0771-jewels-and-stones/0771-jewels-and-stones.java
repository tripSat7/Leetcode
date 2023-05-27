class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        int res=0;
        List<Character> jList = new ArrayList<>();
        for (char ch : jewels.toCharArray()) {
            jList.add(ch);
        }
        for(char ch : stones.toCharArray()){
            if(jList.contains(ch)){
                res++;
            }
        }
        return res;
    }
}